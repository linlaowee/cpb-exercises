public class Main{
    public static void main(String[] args){
        //4.a
        int[] intArray = {2, 5, 6, 4, 1};
        String[] stringArray = {"woomy", "ngyes", "veemo", "oomi"};
        boolean[] boolArray = {true, false, true};

        //4.b
        printEachString(stringArray);
        //4.c
        System.out.println(sumOfInts(intArray));
        //4.d
        System.out.println(averageOfInts(intArray));

        //4.e
        /*
        You could use Arrays.sort method by importing java.util.Arrays.


        You could also use a double for loop. One that goes through the whole index [i] and 
        then one who goes through 1 index [j = i+1] above the previous loop. So have an index [i] 
        and index [j] from the first and second loops respectively. 
        
        An if statement compares the values for [i] and [j], and if [i] has a higher value 
        than [j], then [i] gets [j]'s value and vice versa.
        */
        orderArrayLowToHigh(intArray);
        for(int i = 0; i < intArray.length; i++){
            System.out.println(intArray[i]);
        }


    }

    //4.b
    static void printEachString(String array[]){
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

    }

    //4.c
    static int sumOfInts(int array[]){
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }

    //4.d
    static float averageOfInts(int array[]){
        float sum = (float)sumOfInts(array);
        float average = (float) sum / array.length;
        return average;
    }

    //4.e
    static void orderArrayLowToHigh(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}