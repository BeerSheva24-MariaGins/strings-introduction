package telran.strings;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Strings {
    static final String keyWords[] = { "abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum", "extends", "false",
                "final", "finally", "float", "for", "goto", "if", "implements",
                "import", "instanceof", "int", "interface", "long", "native",
                "new", "null", "package", "private", "protected", "public",
                "return", "short", "static", "strictfp", "super", "switch",
                "synchronized", "this", "throw", "throws", "transient", "true",
                "try", "void", "volatile", "while" };
    public static String firstName() {
        // regex for strings startin with
        // capital letter and rest as a
        // lower case letters
        // minimal length is 5 letters
        return "[A-Z][a-z]{4,}";
    }

    public static String javaVariable() {
        // regular expression for testing synthax
        // of Java variable names
        return "((?!_$)[a-zA-Z$_][\\w$]*)";
    }
    public static String number0_300() {
       
        return "[1-9]\\d?|[1-2]\\d\\d|300|0";
    }
    public static String ipV4Octet(){
        
        return "([0-1]?\\d{1,2}|2([0-4]\\d|5[0-5]))";
    }
    public static String ipV4Address(){
        String octetExpr = ipV4Octet();
        return String.format("%s(\\.%s){3}", octetExpr, octetExpr);
    }
    public static String stringWithJavaNames(String names) {
       String [] tokens = names.split("\\s+");
       int i = getJavaNameIndex(tokens, -1);
       String res = "";
       if (i >= 0) {
         res = tokens[i];
       }
       while((i = getJavaNameIndex(tokens, i)) > 0) {
            res += " " + tokens[i];
       }
       
        return res;
    }

    private static int getJavaNameIndex(String[] tokens, int i) {
        i++;
        while(i < tokens.length && !isJavaName(tokens[i])) {
            i++;
        }
        return i < tokens.length ? i : -1;
    }

    private static boolean isJavaName(String string) {
        
        return string.matches(javaVariable()) && Arrays.binarySearch(keyWords, string) < 0;
}
    public static boolean isArithmeticExpression(String expr) {
        boolean flag = true;        
        String operatorRegex = "[*/+-]";
        String variableRegex = "[a-zA-Z$][a-zA-Z0-9_$]*";
        String numberRegex = "\\d+";
        String operandRegex = variableRegex + "|" + numberRegex;
        
        
        // String expressionRegex = "\\s*(" + operandRegex + "|\\(\\s*" + operandRegex + "(\\s*" + operatorRegex + "\\s*" + operandRegex + ")*\\s*\\))\\s*(" + operatorRegex + "\\s*(" + operandRegex + "|\\(\\s*" + operandRegex + "(\\s*" + operatorRegex + "\\s*" + operandRegex + ")*\\s*\\))\\s*)*";

        // if (!Pattern.matches(expressionRegex, expr.replaceAll("\\s+", ""))) {
        //     flag = false;
        // }

       
        int bracketCounter = 0;
        for (char c : expr.toCharArray()) {
            if (c == '(') {
                bracketCounter++;
            } else if (c == ')') {
                bracketCounter--;
                if (bracketCounter < 0) {
                    flag = false;
                }
            }
        }
        
        return flag && bracketCounter == 0;
    }

    
}
