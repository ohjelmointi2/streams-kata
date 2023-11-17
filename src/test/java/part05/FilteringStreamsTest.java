package part05;

import static utils.StreamAssertions.assertStreamsEqual;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class FilteringStreamsTest {

    // the object to be tested
    private FilteringStreams solution = new FilteringStreams();

    @Test
    void testFilterEvenNumbers() {
        IntStream numbers = IntStream.of(11, 22, 33, 44, 55, 66, 77);

        IntStream evenNumbers = solution.filterEvenNumbers(numbers);

        assertStreamsEqual(IntStream.of(22, 44, 66), evenNumbers);
    }

    @Test
    void testFilterNumbersBetween() {
        IntStream numbers = IntStream.of(1995, 2011, 2019, 2022);

        IntStream numbersBetween = solution.filterNumbersBetween(numbers, 2000, 2020);

        assertStreamsEqual(IntStream.of(2011, 2019), numbersBetween);
    }

    @Test
    void testFilterStringsStartingWith() {
        Stream<String> words = Stream.of("@ohjelmointi2", "@python", "java@example.com", "stream", "lambda");

        // should produce a stream containing only the strings that start with "@"
        Stream<String> filtered = solution.filterStringsStartingWith(words, "@");

        assertStreamsEqual(Stream.of("@ohjelmointi2", "@python"), filtered);
    }

    @Test
    void testFilterIncludingSubstring() {
        Stream<String> words = List.of("ham", "hamster", "hammock", "java", "stream", "lambda").stream();

        // should contain "ham" and "hammock" but not "java" or "lambda"
        Stream<String> wordsWithHam = solution.filterIncludingSubstring(words, "ham");

        assertStreamsEqual(Stream.of("ham", "hamster", "hammock"), wordsWithHam);
    }

    @Test
    void testFilterNotIncludingSubstring() {
        Stream<String> words = List.of("ham", "hamster", "hammock", "java", "stream", "lambda").stream();

        Stream<String> wordsWithoutHam = solution.filterNotIncludingSubstring(words, "ham");

        assertStreamsEqual(Stream.of("java", "stream", "lambda"), wordsWithoutHam);
    }
}
