package part06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class PredicatesWithStreamsTest {

    // the object to be tested
    private PredicatesWithStreams solution = new PredicatesWithStreams();

    @Test
    void testAllPositive() {
        // these are all positive
        IntStream positives = IntStream.of(1, 2, 3, 4, 5);
        assertTrue(solution.allPositive(positives));

        // these are all negative
        IntStream negatives = IntStream.of(-1, -2, -3, -4, -5);
        assertFalse(solution.allPositive(negatives));

        // this stream has both positive and negative numbers
        IntStream mixed = IntStream.of(-1, 2, -3, 4, -5);
        assertFalse(solution.allPositive(mixed));
    }

    @Test
    void testGetFirstPositive() {
        IntStream numbers = IntStream.of(-1, -2, -3, 4, 5);
        assertEquals(4, solution.getFirstPositive(numbers));

        // this stream has no positive numbers, so the method should return 0
        IntStream negatives = IntStream.of(-1, -2, -3, -4, -5);
        assertEquals(0, solution.getFirstPositive(negatives));
    }

    @Test
    void testContainsNoNulls() {
        // this stream has no null values, so the method should return true
        Stream<String> noNulls = Stream.of("a", "b", "c");
        assertTrue(solution.containsNoNulls(noNulls));

        // this stream has null values, so the method should return false
        Stream<String> withNulls = Stream.of("a", null, "b", null, "c");
        assertFalse(solution.containsNoNulls(withNulls));
    }
}
