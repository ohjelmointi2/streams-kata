package part03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static utils.StreamAssertions.assertStreamsEqual;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class ListsAndStreamsTest {

    // the object to be tested
    private ListsAndStreams solution = new ListsAndStreams();

    @Test
    void testMakeStream() {
        List<String> names = List.of("Monica", "Chandler", "Phoebe");

        // convert the list into a stream
        Stream<String> generated = solution.makeStream(names);

        // check that the names are correct
        assertStreamsEqual(Stream.of("Monica", "Chandler", "Phoebe"), generated);
    }

    @Test
    void testMakeList() {
        Stream<String> nameStream = Stream.of("Monica", "Chandler", "Phoebe");

        // convert a stream into a list
        List<String> asList = solution.makeList(nameStream);

        assertNotNull(asList, "makeList must return a list");
        assertEquals(List.of("Monica", "Chandler", "Phoebe"), asList);
    }

    @Test
    void testStreamWithLimit() {
        List<String> names = List.of("Monica", "Chandler", "Phoebe", "Ross", "Rachel", "Joey");

        // create a stream that contains only the first two names
        Stream<String> streamOfTwo = solution.streamWithLimit(names, 2);

        assertStreamsEqual(Stream.of("Monica", "Chandler"), streamOfTwo);
    }
}
