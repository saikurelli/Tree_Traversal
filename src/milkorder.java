import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class milkorder {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner( new File("milkorder.in"));
        PrintWriter out= new PrintWriter( new File("milkorder.out"));
        int numbercows = sc.nextInt();
        int numberOrder = sc.nextInt();
        int numpos = sc.nextInt();
        sc.nextLine();
        int actorder [] = new int[numbercows];
        String [] order = sc.nextLine().split(" ");
        ArrayList <Integer> tbhorder = new ArrayList<>();
        for (int i = 0; i < order.length; i++) {
            String s = order[i];
            tbhorder.add(Integer.parseInt(s));
        }
        String ln1[]= sc.nextLine().split(" ");
        String ln2[] = sc.nextLine().split(" ");
        for(int i = 0; i< numpos; i++){
            actorder[Integer.parseInt(ln2[i])-1] = Integer.parseInt(ln1[i]);
            if(tbhorder.contains(Integer.parseInt(ln1[i]))){
                int growth = 0;
                boolean condition = false;
                for(int p= 0; p< tbhorder.size(); p++){
                    if(tbhorder.get(p) == Integer.parseInt(ln1[i])){
                        condition=true;
                    }else if(condition){
                        /*
                        if(Integer.parseInt(ln2[i]) + growth != -1 && Integer.parseInt(ln2[i]) + growth!= actorder.length && actorder[Integer.parseInt(ln2[i]) + growth]==0){
                            actorder[Integer.parseInt(ln2[i]) + growth] = tbhorder.get(p);
                            growth++;
                        }*/

                    }else{

                        if(actorder[Integer.parseInt(ln2[i])-1]==0){
                            actorder[Integer.parseInt(ln2[i])-1]= tbhorder.get(p);
                        }else{
                            int amt = 2;
                            while(actorder[Integer.parseInt(ln2[i])-amt]!=0){
                                amt++;
                            }
                            actorder[Integer.parseInt(ln2[i])-amt] = tbhorder.get(p);
                        }
                    }
                }
            }

        }

        boolean value = false;
        for (int i = 0; i < actorder.length; i++) {
            if(actorder[i]==0 && !value){
                out.println(i+1); value=true;
               // out.println("HI");
            }
        }
        out.close();


    }
}
