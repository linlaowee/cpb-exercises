import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Opgave 1:
        System.out.println("Opgave 1:");
        System.out.println(min(3, -2, 7));
        System.out.println(min(19, 27, 6));

        //Opgave 2:
        System.out.println("Opgave 2:");
        printEvenNumbers(10);
        printEvenNumbers(9);
        printEvenNumbers(15);
        printEvenNumbers(-6);

        //Opgave 3:
        System.out.println("Opgave 3:");
        System.out.println(smallestAbsVal(1,9,-11));
        System.out.println(smallestAbsVal(-8, 2, 12));

        //Opgave 4:
        System.out.println("Opgave 4:");
        System.out.println(sumDigits(33));
        System.out.println(sumDigits(931));
        System.out.println(sumDigits(-99));

        //Opgave 5:
        System.out.println("Opgave 5: ");
        reverseVertical("laptop");

        //Opgave 6:
        System.out.println("Opgave 6:");
        processName();

        //Opgave 7:
        System.out.println("Opgave 7:");
        System.out.println(repeat("hej"));
        System.out.println(repeat("woomy"));
        System.out.println(repeat(""));

        //Opgave 8:
        System.out.println("Opgave 8:");
        Scanner scan = new Scanner(System.in);
        shortestName(scan, 4);
        shortestName(scan, -1);
        shortestName(scan, 0);

        //Opgave 9:
        System.out.println("Opgave 9:");
        randomNumbers();

        //Opgave 10:
        System.out.println("Opgave 10:");
        maxMin();

        //Opgave 11:
        System.out.println("Opgave 11:");
        printMultiple(5);
        printMultiple(7);
        printMultiple(-1);

        //Opgave 12:
        System.out.println("Opgave 12:");
        int[] intArray1 = {4, 0, 2, 58, 3};
        int[] intArray2 = {3, 5, 6, 0, -23};
        System.out.println(max(intArray1));
        System.out.println(max(intArray2));

        //Opgave 13:
        System.out.println("Opgave 13:");
        int[] intArray3 = {1, 2, 3};
        int[] intArray4 = {2, 4, 6};
        int[] intArray5 = {34, 5, 5};

        System.out.println(allLess(intArray3, intArray4));
        System.out.println(allLess(intArray4, intArray5));
        System.out.println(allLess(intArray4,intArray3));
        System.out.println(allLess(intArray1, intArray3));



    }

    //Opgave 1:
    public static int min(int a, int b, int c){
        int d = Math.min(a, b);
        if (d < c){
            return d;
        }
        else {
            return c;
        }

    }

    //Opgave 2:
    public static void printEvenNumbers(int a){
        if (a < 2) {
            System.out.println("Error. Number must be above 2");
        } else {
            for (int i = 0; i < a; i += 2) {
                System.out.println(i);
            }
        }
    }

    //Opgave 3:
    public static int smallestAbsVal(int a, int b, int c){
        a = Math.abs(a);
        b = Math.abs(b);
        c = Math.abs(c);
        int d = min(a, b, c);
        return d;
    }

    //Opgave 4:
    public static int sumDigits(int num){
        num = Math.abs(num);
        int total = 0;
        while (num > 0) {
            //int total = 0;
            int digit = num % 10;
            num = num / 10;
            total = total + digit;
        }
        return total;
    }

    //Opgave 5:
    public static void reverseVertical(String word){
        for (int i = word.length()-1; i >= 0; i --){
            System.out.println(word.charAt(i));
        }
    }

    //Opgave 6:
    public static void processName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Write you full name: ");

        String userName = scan.nextLine();
        userName = userName.toUpperCase();
        System.out.println("Your full name in upper case is: " + userName);
    }

    //Opgave 7:
    public static String repeat(String word){
        String s = "";
        for (int i = 0; i < word.length(); i++){
            s = s + word;
        }
        return s;

    }

    //Opgave 8:
    public static void shortestName(Scanner scan, int n){
        ArrayList <String> names = new ArrayList<String>();

        try {
            for (int i = 0; i < n; i++) {
                int nameNumber = i + 1;
                System.out.println("Type name#" + nameNumber + ": ");
                names.add(scan.nextLine());
            }
            Collections.sort(names, Comparator.comparing(String::length));

            System.out.println("The shortest name is: " + names.get(0));
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
    }

    //Opgave 9:
    public static void randomNumbers(){
        int randNum = 0;
        Random random = new Random();
        while (randNum < 900){
            randNum = random.nextInt(1001);
            System.out.println("Random number: " +randNum);
        }
    }


    //Opgave 10:
    public static void  maxMin(){
        Scanner scan = new Scanner(System.in);
        ArrayList <Integer> numbers = new ArrayList<Integer>();
        int input = 0;

        try {

            while (input != -1) {
                System.out.println("Write a positive number (or -1 to end): ");
                input = scan.nextInt();
                if (input >= 0) {
                    numbers.add(input);
                }
                if (input < 0 && input != -1) {
                    System.out.println("Error. Not a positive number.");
                }
            }
            numbers.sort(Comparator.comparing(Integer::valueOf));
            System.out.println(numbers.get(0));
            System.out.println(numbers.get(numbers.size() - 1));
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Ended by typing -1");
        }

    }

    //Opgave 11:
    public static void printMultiple(int n){
        for (int i = 1; i < 10; i++){
            System.out.print(n*i);
            if (i < 10-1){
                System.out.print(" og ");
            }
        }
        System.out.println("");
    }

    //Opgave 12:
    public static int max(int[] arr){

        Arrays.sort(arr);
        int biggest = arr[arr.length - 1];
        return biggest;
    }

    //Opgave 13:
    public static boolean allLess(int[] arrSmall, int[] arrBig){
        boolean bool = true;

        if (arrSmall.length == arrBig.length) {
            for (int i = 0; i < arrSmall.length; i++){
                if (arrSmall[i] < arrBig[i]){
                    bool = true;
                }
                else {
                    bool = false;
                }
            }
        }
        else {
            bool = false;
        }
        return bool;

    }


}
