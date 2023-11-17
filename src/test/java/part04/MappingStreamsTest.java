package part04;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static utils.StreamAssertions.assertStreamsEqual;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class MappingStreamsTest {

    // the object to be tested
    private MappingStreams solution = new MappingStreams();

    @Test
    void testDoubleValuesInStream() {
        // what do these years have in common? ;)
        IntStream numbers = IntStream.of(1995, 2011, 2019, 2022);

        IntStream doubled = solution.doubleValuesInStream(numbers);

        assertStreamsEqual(IntStream.of(2 * 1995, 2 * 2011, 2 * 2019, 2 * 2022), doubled);
    }

    @Test
    void testMultiplyValuesInStream() {
        IntStream numbers = IntStream.of(1995, 2011, 2019, 2022);

        IntStream tripled = solution.multiplyValuesInStream(numbers, 3);

        assertStreamsEqual(IntStream.of(3 * 1995, 3 * 2011, 3 * 2019, 3 * 2022), tripled);
    }

    @Test
    void testMapListToIntStream() {
        List<Integer> original = List.of(1995, 2011, 2019, 2022);

        IntStream mapped = solution.mapListToIntStream(original);

        assertStreamsEqual(IntStream.of(1995, 2011, 2019, 2022), mapped);
    }

    @Test
    void testPrefixAllStrings() {
        Stream<String> urls = Stream.of("ohjelmointi2.github.io", "python-ohjelmointi.github.io");
        Stream<String> prefixed = solution.prefixAllStrings(urls, "https://");

        assertStreamsEqual(Stream.of("https://ohjelmointi2.github.io", "https://python-ohjelmointi.github.io"),
                prefixed);
    }

    @Test
    void testSuffixAllStrings() {
        // some common email aliases that should be made into full email addresses
        Stream<String> aliases = Stream.of("noreply", "abuse", "admin");

        // add the @ and domain name to each alias
        Stream<String> addresses = solution.suffixAllStrings(aliases, "@example.com");

        assertStreamsEqual(Stream.of("noreply@example.com", "abuse@example.com", "admin@example.com"), addresses);
    }

    @Test
    void testRemoveSuffix() {
        // three of these files have the .pdf suffix, but one does not
        Stream<String> files = Stream.of("cv.pdf", "thesis.pdf", "photo.png", "letter.pdf");

        Stream<String> removed = solution.removeSuffix(files, ".pdf");

        assertStreamsEqual(Stream.of("cv", "thesis", "photo.png", "letter"), removed);
    }

    @Test
    void testStreamFizzBuzz() {
        IntStream numbers = IntStream.rangeClosed(1, 5);

        // create a stream of fizzbuzz words based on the numbers
        Stream<String> fizzBuzz = solution.streamFizzBuzz(numbers);
        assertNotNull(fizzBuzz, "streamFizzBuzz must return a stream");

        // the words are converted to lowercase to make the test case-insensitive
        assertStreamsEqual(Stream.of("1", "2", "fizz", "4", "buzz"), fizzBuzz.map(String::toLowerCase));

        // test that the logic handles multiples of both 3 and 5 correctly
        IntStream fifteen = IntStream.rangeClosed(15, 15);
        Stream<String> stream = solution.streamFizzBuzz(fifteen);

        assertStreamsEqual(Stream.of("fizzbuzz"), stream.map(String::toLowerCase));
    }
}
