public class Datamatik{
    public static void main(String[] args){
        Student[] studentArray = new Student[10];

        //initializing the students in the sudentArray
        studentArray[0] = new Student("Oliver", 22, false, "E");
        studentArray[1] = new Student("Eske", 25, false, "F");
        studentArray[2] = new Student("Christian C. S.", 25, false, "G");
        studentArray[3] = new Student("Angeliza", 25, true, "K");
        studentArray[4] = new Student("Bjarke", 25, false, "E");
        studentArray[5] = new Student("Christian S.", 35, false, "C");
        studentArray[6] = new Student("Berken", 20, false, "J");
        studentArray[7] = new Student("Nikolaj", 25, false, "A");
        studentArray[8] = new Student("Oliver", 22, false, "E");
        studentArray[9] = new Student("Mads", 41, false, "F");

        //5.b
        /* studentName(studentArray[0]);
        studentName(studentArray[4]);
        studentName(studentArray[7]); */

        //5.c
        /* findIndexOfName(studentArray,"Mads"); */
    }

    //5.b - can't get this to work
    /* static void studentName(Student[int n] array){
        System.out.println(array[n].name);
    } */

    //5.c - can't figure these out. Idk what to put as the other return statement
    /* static int findIndexOfName(Student[] array, String c){
        for (int i = 0; i < array.length; i++){
            if (array[i].name == c){
                return i;
            } 
        
            
        }
    } */
}