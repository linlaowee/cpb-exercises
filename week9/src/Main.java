import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    private static String[][] text = new String[12][1];
    private static String[][] splitarray = new String[12][1];

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("data.txt");
        scan = new Scanner(file);
        int i = 0;
        while (scan.hasNextLine()) {
            text[i] = scan.nextLine().split(" ");

            i++;
        }

        File file2 = new File("data.txt");
        scan = new Scanner(file2);
        int j = 0;
        while (scan.hasNextLine()) {
            splitarray[j] = scan.nextLine().split("\\. ");

            j++;

        }

        // todo: print alle ord der starter med det der sendes med som argument,
        //printWordsStartingWith("Ø");
        //todo: print alle ord der har præcis det antal bogstaver der sendes med som argument (inkluderer IKKE tal og tegnene '.' og ',')
        //printWordsOfLength(3);


        //test dine metoder ved at kalde dem her:
        System.out.println("Words with double consonant:");
        printWordsWithDoubleConsonant();
        System.out.println("Longest sentence:");
        printLongestSentence();


    }

    private static void printWordsOfLength(int l) {
        boolean wordisvalid = true;

        for (int i = 0; i < text.length; i++) {
            for (String s : text[i]) {
                if (s.length() == l) {
                    if (s.contains(",") || s.contains(".")) {
                        wordisvalid = false;
                    }
                     /*for (int j = 0; j < s.length(); j++) {
                         char c = s.charAt(j);
                         if(c == '.' || c == ','){
                             wordisvalid = false;
                         }
                     }*/
                    if (wordisvalid) {
                        System.out.println(s);
                    }

                }
            }
        }

    }

    private static void printWordsStartingWith(String pattern) {

        for (int i = 0; i < text.length; i++) {
            for (String s : text[i]) {
                if (s.startsWith(pattern) || s.startsWith(pattern.toLowerCase())) {
                    System.out.println(s);
                }
            }

        }

    }

    //skriv dine metoder herunder:

    private static void printWordsWithDoubleConsonant() {
        //boolean wordIsValid = true;

        for (int i = 0; i < text.length; i++) {
            for (String s : text[i]) {
                for (int j = 0; j < s.length() - 1; j++) {
                    if (s.charAt(j) == s.charAt(j + 1) && isConsonant(s.charAt(j))) {
                        System.out.println(s);
                    }
                }

            }
        }
    }

    private static boolean isConsonant(char c) {
        if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u') || (Character.isDigit(c) == true)) {
            return false;
        } else {
            return true;
        }
    }


    private static void printLongestSentence(){
        int maxLength = 0;
        String longestString = null;
        for (int j = 0; j < splitarray.length; j++) {
            for (String s : splitarray[j]) {
                if (s.length() > maxLength) {
                    maxLength = s.length();
                    longestString = s;
                }
            }
        }
        System.out.println(longestString);
    }

}
