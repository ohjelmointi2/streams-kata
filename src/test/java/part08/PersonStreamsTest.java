package part08;

import static utils.StreamAssertions.assertStreamsEqual;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import person.Person;

public class PersonStreamsTest {

    // the objects to be used in the tests
    private static final Person ada = new Person("Ada", 10);
    private static final Person bob = new Person("Bob", 20);
    private static final Person carol = new Person("Carol", 30);

    // the object to be tested
    private PersonStreams solution = new PersonStreams();

    @Test
    void testGetAdults() {
        Stream<Person> adults = solution.getAdults(Stream.of(ada, bob, carol));

        assertStreamsEqual(Stream.of(bob, carol), adults);
    }

    @Test
    void testIncrementAge() {
        Stream<Person> incremented = solution.incrementAge(Stream.of(ada, bob, carol));

        Stream<Person> expected = Stream.of(
                new Person("Ada", 11),
                new Person("Bob", 21),
                new Person("Carol", 31));

        assertStreamsEqual(expected, incremented);
    }

    @Test
    void testCsvToPersons() {
        // these lines contain the same names and ages as the persons above
        Stream<String> csvLines = Stream.of("Ada,10", "Bob,20", "Carol,30");

        // the method should return a stream that matches the Person objects above
        Stream<Person> generated = solution.csvToPersons(csvLines);

        assertStreamsEqual(Stream.of(ada, bob, carol), generated);
    }

}
