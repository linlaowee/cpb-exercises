public class Oops {
    public static void main (String[] args){
        int a = 7;
        int b = 42;

        if (minimum(a,b) == a){
            System.out.println(a+ " is the smallest!");
        }
    }


    static int minimum(int a, int b){
        int smaller;
        if (a < b){
            return a;
        }
        else{
            return b;
        }
    }
    
}