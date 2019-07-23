import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;


public class RegexTest {

    @Test
    void regexMatches(){
     String s1 = "ZZ123K00";
     String s2 = "1ZZ100K02";
     String regex = "\\D\\D\\d\\d\\d\\D\\d\\d";
     assertTrue(s1.matches(regex));
     assertFalse(s2.matches(regex));
    }

    @Test
    void regexCompile(){
        String s1 = "ZZ123K00";
        String s2 = "1ZZ100K02";
        String regex = "\\D\\D\\d\\d\\d\\D\\d\\d";

        Pattern p = Pattern.compile(regex);

        assertTrue(p.matcher(s1).matches());
        assertFalse(p.matcher(s2).matches());
    }


}
