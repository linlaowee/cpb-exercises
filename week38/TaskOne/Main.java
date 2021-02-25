public class Main {
    static void emptyLine(){
        System.out.println();
    }
    static void methodWithString(String a){
        System.out.println(a);
    }
    static void nameAndAge(String name, int age){
        System.out.println("My name is " +name+ ", I am " +age+ " years old." );
    }

    public static void main(String[] args){
        emptyLine();
        methodWithString("something");
        nameAndAge("Lin", 20);
    }
}