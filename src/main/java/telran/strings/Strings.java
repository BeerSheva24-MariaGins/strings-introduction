package telran.strings;

public class Strings {
    public static String firstName() {        
        return "[A-Z][a-z]{4,}";
    }
    public static String javaVariable() {
        //regular expression for testing syntax
        //of java variable names
        //only ASCII symbols are allowed
        return "^[a-zA-Z_$][a-zA-Z0-9_$]*$";
    }
}
