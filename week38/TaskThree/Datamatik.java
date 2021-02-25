public class Datamatik{
    public static void main(String[] args){
        Teacher teacher1 = new Teacher("Jesper", 29, false);
        Student student1 = new Student("Lin", 20, false, "F"); //false 'cause I'm non-binary
        Student student2 = new Student("Mads", 41, false, "F");

        System.out.println("The name of one of my teachers: " +teacher1.name);
        System.out.println("My name is " +student1.name+ " and I am in team " +student1.datamatikerTeam+ ".");
        System.out.println("My fellow student's name is " +student2.name+ " and is in team " +student2.datamatikerTeam+ ".");
        
    }
}