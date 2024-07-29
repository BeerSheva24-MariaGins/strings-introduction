package telran.strings;
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
}


