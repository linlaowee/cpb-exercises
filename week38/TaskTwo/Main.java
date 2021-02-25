class Main{
    public static boolean happy = true;

    public static void main(String [] args) {
        //2.a
        if (iAmHappy())
        {
          System.out.println("I clap my hands");
        }
        else
        {
          System.out.println("I don't clap my hands"); 
        }

        //2.b
        System.out.println(sumOfInts(3, 5));

        //2.c
        System.out.println(upperCaseString("word"));

        //2.d
        System.out.println(isFirstLetterUpperCase("Uppercase"));
        System.out.println(isFirstLetterUpperCase("lowercase"));
    }

    //2.a
    public static boolean iAmHappy()
    {
        // fill out what is missing here: 
        if (happy){
            return true;

        }
        else {
            return false;
        }
    }

    //2.b
    public static int sumOfInts(int a, int b){
        int sum = a + b;
        return sum;
    }

    //2.c
    public static String upperCaseString(String c){
        String up = c.toUpperCase();
        return up;
    }

    //2.d
    public static boolean isFirstLetterUpperCase(String d){
        char firstLetter = d.charAt(0);
        boolean result = Character.isUpperCase(firstLetter);
        return result;

    }
}