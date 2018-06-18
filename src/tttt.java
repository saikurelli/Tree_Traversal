import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class tttt {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("tttt.in"));
        PrintWriter out = new PrintWriter( new File("tttt.out"));
        char mat [] [] = new char[3][3];
        for(int i = 0; i< 3; i++){
            String ln = sc.nextLine();
            for(int j = 0; j< 3; j++){
                mat[i][j]= ln.charAt(j);
            }
        }
        String item1 = "" + mat[0][0]+ mat[0][1]+ mat[0][2];
        //System.out.println(item1);
        String item2 = ""+ mat[2][0]+ mat[2][1] + mat[2][2];
        //System.out.println(item2);
        String item3 = "" + mat[0][0]+ mat[1][0]+ mat[2][0];
        //System.out.println(item3);
        String item4 = "" + mat[0][2]+ mat[1][2] + mat[2][2];
        //System.out.println(item4);
        String item5 = ""+ mat[0][0]+ mat[1][1] + mat[2][2];
        //System.out.println(item5);
        String item6= "" + mat[0][2] +mat[1][1] + mat[2][0];
        //System.out.println(item6);
        String item7 = ""+ mat[0][1] + mat[1][1]+ mat[2][1];
        String item8 = ""+ mat[1][0] + mat[1][1]+ mat[1][2];
        String arr[] = {item1,item2,item3,item4, item5, item6,item7,item8};
        int onecownumbertime = 0;
        int numbertimestwocow = 0;
        ArrayList <Character> oneCow = new ArrayList<>();
        ArrayList<String> twoCow = new ArrayList<>();
        for(String s : arr){
            if(s.charAt(0)== s.charAt(1) && s.charAt(1) == s.charAt(2)){
                if(!oneCow.contains(s.charAt(0))){
                    oneCow.add(s.charAt(0));
                }
            }else if(s.charAt(0)==s.charAt(2)){
                if(s.charAt(2)> s.charAt(1)){
                    String p = s.charAt(1)+""+s.charAt(2);
                    twoCow.add(p);
                }else{
                    String p = s.charAt(2)+""+s.charAt(1);
                    twoCow.add(p);
                }
            }else if(s.charAt(0) == s.charAt(1)){
                if(s.charAt(2)> s.charAt(1)){
                    String p = s.charAt(1)+""+s.charAt(2);
                    twoCow.add(p);
                }else{
                    String p = s.charAt(2)+""+s.charAt(1);
                    twoCow.add(p);
                }
            }else if(s.charAt(1)==s.charAt(2)){
                if(s.charAt(0)> s.charAt(1)){
                    String p = s.charAt(1)+""+s.charAt(0);
                    twoCow.add(p);
                }else{
                    String p = s.charAt(0)+""+s.charAt(1);
                    twoCow.add(p);
                }
            }
        }
        /*
         ArrayList<Character> possWInnersOneCow = new ArrayList<>();
        HashMap<Character, Character> possWinTwo  =  new HashMap<>();
        for (String s : arr) {
            //System.out.println(arr[i]);
            if (s.charAt(1) == s.charAt(0)) {
                if (s.charAt(2) == s.charAt(1)) {
                    //System.out.println(s + i);
                    if (!possWInnersOneCow.contains(s.charAt(2))) {
                        onecownumbertime++;
                        possWInnersOneCow.add(s.charAt(2));
                    }
                    //numbertimestwocow++;
                } else {
                    if (!(possWinTwo.containsKey(s.charAt(2)) && possWinTwo.get(s.charAt(2)) == s.charAt(1))) {
                        numbertimestwocow++;
                        possWinTwo.put(s.charAt(2), s.charAt(1));
                    }

                }
            } else {
                if (s.charAt(1) == s.charAt(2) || s.charAt(2) == s.charAt(0)) {
                    if (s.charAt(1) == s.charAt(2)) {
                        if (!(possWinTwo.containsKey(s.charAt(2)) && possWinTwo.get(s.charAt(2)) == s.charAt(1))) {
                            numbertimestwocow++;
                            possWinTwo.put(s.charAt(2), s.charAt(1));
                        }
                    }
                    if (s.charAt(2) == s.charAt(0)) {
                        if (!(possWinTwo.containsKey(s.charAt(2)) && possWinTwo.get(s.charAt(2)) == s.charAt(0))) {
                            numbertimestwocow++;
                            possWinTwo.put(s.charAt(2), s.charAt(0));
                        }
                    }
                }
            }
        }
         */
        out.println(oneCow.size());
        out.println(twoCow.size());
        out.close();
    }
}
