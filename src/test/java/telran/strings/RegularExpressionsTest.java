package telran.strings;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import telran.strings.Strings;

@SuppressWarnings("unused")
public class RegularExpressionsTest {    
    @Test
    public void testJavaVariable() {
        String regex = Strings.javaVariable();
        Pattern pattern = Pattern.compile(regex);
       
        assertTrue(pattern.matcher("validName").matches());
        assertTrue(pattern.matcher("_validName").matches());
        assertTrue(pattern.matcher("$validName").matches());
        assertTrue(pattern.matcher("validName123").matches());
        
        assertFalse(pattern.matcher("1invalidName").matches());
        assertFalse(pattern.matcher("invalid-name").matches());
        assertFalse(pattern.matcher("invalid name").matches());
        assertFalse(pattern.matcher("invalid.name").matches());
    }
    @Test
    void number0_300TrueTest() {
        String regex = Strings.number0_300();
        assertTrue("0".matches(regex));
        assertTrue("300".matches(regex));
        assertTrue("250".matches(regex));
        assertTrue("25".matches(regex));
        assertTrue("12".matches(regex));
        assertTrue("299".matches(regex));
        assertTrue("1".matches(regex));
    }
    @Test
    void number0_300FalseTest() {
        String regex = Strings.number0_300();
        assertFalse("00".matches(regex));
        assertFalse("301".matches(regex));
        assertFalse("01".matches(regex));
        assertFalse("000".matches(regex));
        assertFalse("1(".matches(regex));
        assertFalse("1000".matches(regex));
        assertFalse("020".matches(regex));
        assertFalse("1001".matches(regex));
    }
    @Test
    void ipV40ctetTrueTest() {
        String regex = Strings.ipV40ctet();
        assertTrue("0".matches(regex));
        assertTrue("00".matches(regex));
        assertTrue("000".matches(regex));
        assertTrue("10".matches(regex));
        assertTrue("100".matches(regex));
        assertTrue("255".matches(regex));
        assertTrue("199".matches(regex));
        assertTrue("249".matches(regex));
       
    }
    @Test
    void ipV40ctetFalseTest() {
        String regex = Strings.ipV40ctet();
        assertFalse("0000".matches(regex));
        assertFalse("t".matches(regex));
        assertFalse("-1".matches(regex));
        assertFalse("1111".matches(regex));
        assertFalse("0001".matches(regex));
        assertFalse("256".matches(regex));
        assertFalse("300".matches(regex));
        assertFalse("*".matches(regex));
        assertFalse("1 ".matches(regex));
    }
    @Test
    void ipV4AddressTrueTest() {
        String regex = Strings.ipV4Address();
        assertTrue("0.0.0.0".matches(regex));
        assertTrue("255.255.255.255".matches(regex));
    }
    @Test
    void ipV4AddressFalseTest() {
        String regex = Strings.ipV4Address();
        assertFalse("0.0.0".matches(regex));
        assertFalse("256.256.256.256".matches(regex));
        assertFalse("0.0.0+0".matches(regex));
        assertFalse("0".matches(regex));
        assertFalse("0.-".matches(regex));
        assertFalse("0.0.0 0".matches(regex));
    }
    @Test
    void stringWithJavaNamesTest() {
        String names = "123 1a _ abs int enum null lmn";
        String expected = "abs lmn";
        assertEquals(expected, Strings.stringWithJavaNames(names));
    }
    
    @Test
    void isArithmeticExpressionTest() {
        // Корректные выражения
        assertTrue(Strings.isArithmeticExpression("(c - d)/(7000 + a)"));
        assertTrue(Strings.isArithmeticExpression("(a + b) * c"));
        assertTrue(Strings.isArithmeticExpression("a + b * 1000"));
        assertTrue(Strings.isArithmeticExpression("111 + 22 * 3"));
        assertTrue(Strings.isArithmeticExpression("a + 1 * (b - 2000)"));

        // Некорректные выражения
        assertFalse(Strings.isArithmeticExpression("a + (b * c"));
        assertFalse(Strings.isArithmeticExpression("222 + b * c)"));            
        assertFalse(Strings.isArithmeticExpression("a + b * c) + d"));
    }
    
}
