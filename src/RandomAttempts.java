public class RandomAttempts {
    public static void main(String[] args) {
        String items= " * 5.0";
        String arr[] = items.split(" ");
        for(int i = 0; i< arr.length; i++){
            try{
                System.out.println("Double " + Double.parseDouble(arr[i]));
            }catch (Exception e){
                System.out.println("operand "+ arr[i]);
            }
        }
    }
}
