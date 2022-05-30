import org.junit.jupiter.api.Test;
import ro.siit.javaOop2.ApplicationStart;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationStartTest {

    @Test
    public void convertToStringDummyMethodTest() {
        // given
        int input = 7;
        String expected = "7";

        // when
        String actual = ApplicationStart.convertToStringDummyMethod(input);

        // then
        assertEquals(expected, actual);
    }
}
