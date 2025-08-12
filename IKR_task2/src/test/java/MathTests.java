import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class MathTests {

    MathService service = new MathService();

    @ParameterizedTest
    @CsvSource({
            "1, -3, 2, 2.0, 1.0",
            "1, -2, 1, 1.0, 1.0",
            "2, -7, 3, 3.0, 0.5"
    })
    void ParametrizedPositiveTest(int a, int b, int c, double expectedFirst, double expectedSecond) throws NotFoundAnswerException {
        Pair answer = service.getAnswer(a, b, c);

        assertEquals(expectedFirst, answer.first);
        assertEquals(expectedSecond, answer.second);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1",
            "2, 2, 5",
            "3, 0, 2"
    })
    void ParametrizedNegativeTest(int a, int b, int c) {
        assertThrows(NotFoundAnswerException.class, () -> service.getAnswer(a, b, c));
    }

    @Test
    void testGetD() {
        assertEquals(0, service.getD(1, 2, 1));
    }

}
