public class Exception1{
    public static void main(String[] args){
        try{
            int result = divide(10, 0);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static int divide(int a, int b){
        return a/b;
    }
}