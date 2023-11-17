package part07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import person.Person;

public class ObjectStreamsTest {

    // the object to be tested
    private ObjectStreams solution = new ObjectStreams();

    private List<Person> persons = List.of(
            new Person("Ada", 20),
            new Person("Bob", 30),
            new Person("Carol", 40));

    @Test
    void testGetLengths() {
        List<Integer> lengths = solution.getLengths(Stream.of("a", "bb", "ccc"));

        assertNotNull(lengths, "getLengths must return a list");
        assertEquals(List.of(1, 2, 3), lengths);
    }

    @Test
    void testGetAges() {
        List<Integer> ages = solution.getAges(persons.stream());

        assertNotNull(ages, "getAges must return a list");
        assertEquals(List.of(20, 30, 40), ages);
    }

    @Test
    void testGetNames() {
        List<String> names = solution.getNames(persons.stream());

        assertNotNull(names, "getNames must return a list");
        assertEquals(List.of("Ada", "Bob", "Carol"), names);
    }

    @Test
    void testGetAverageAge() {
        double averageAge = solution.getAverageAge(persons.stream());
        assertEquals(30, averageAge);

        // check that the method works with an empty stream
        assertEquals(0, solution.getAverageAge(Stream.empty()));
    }
}
