import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class milk2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("milk2.in"));
        int n = sc.nextInt();
        PrintWriter out = new PrintWriter(new File("milk2.out"));
        List<Interval> items = new ArrayList<>();
        for(int i = 0; i< n; i++){
            sc.nextLine();
            items.add(new Interval(sc.nextInt(),sc.nextInt()));
        }
        Collections.sort(items, Comparator.comparingInt(o -> o.start));
        for(int i = 0; i< items.size()-1; i++){
            Interval item1 = items.get(i); Interval item2 = items.get(i+1);
            if(item1.end>=item2.start){
                items.remove(item1); items.remove(item2);
                items.add(i, new Interval(Math.min(item1.start,item2.start),Math.max(item1.end,item2.end)));
            }
        }
        int size = items.size();
        long longestTimeCont = -1;
        long GapLongestIme = -1;
        for(int i= 0; i < size-1;i++ ){
            Interval item1 = items.get(i);
            longestTimeCont = Math.max(longestTimeCont,item1.end-item1.start);
            Interval item2 = items.get(i+1);
            GapLongestIme = Math.max(GapLongestIme, item2.start- item1.end);
        }
        longestTimeCont= Math.max(items.get(size-1).end- items.get(size-1).start,longestTimeCont);
        //System.out.println(items);

        out.println(longestTimeCont+ " "+ GapLongestIme);
        out.close();
    }
    static class Interval{
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int compareTo(Interval item2){
            return this.start- item2.start;
        }
        public String toString(){
            return "" + start+" "+ end;
        }
    }
}
