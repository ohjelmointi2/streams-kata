package part09;

import static utils.StreamAssertions.assertStreamsEqual;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pizza.Pizza;

public class PizzaStreamsTest {

    // the data that we need for the tests
    private final Pizza margherita = new Pizza("Margherita", 8.99,
            List.of("tomato sauce", "mozzarella", "basil"));
    private final Pizza pepperoni = new Pizza("Pepperoni", 10.99,
            List.of("tomato sauce", "pepperoni", "mozzarella"));
    private final Pizza vegetarian = new Pizza("Vegetarian", 9.99,
            List.of("tomato sauce", "mushrooms", "bell peppers", "onions", "mozzarella"));
    private final Pizza hawaiian = new Pizza("Hawaiian", 11.99,
            List.of("tomato sauce", "ham", "pineapple", "mozzarella"));
    private final Pizza tropical = new Pizza("Tropical", 13.99,
            List.of("tomato sauce", "chicken", "pineapple", "banana peppers", "mozzarella"));
    private final Pizza bbq = new Pizza("BBQ Chicken", 12.99,
            List.of("bbq sauce", "chicken", "pineapple", "red onions", "mozzarella"));

    // the object that we want to test
    private PizzaStreams solution = new PizzaStreams();

    // the stream of pizzas that we will use in the tests
    private Stream<Pizza> pizzas;

    /**
     * This method creates a new stream of pizzas before each test. This way we can
     * be sure that the stream is not modified by the tests.
     */
    @BeforeEach
    void createPizzaStream() {
        pizzas = Stream.of(margherita, pepperoni, vegetarian, hawaiian, tropical, bbq);
    }

    @Test
    void testGetPizzasWithPineapple() {
        Stream<Pizza> withPineapple = solution.getPizzasWithPineapple(pizzas);

        assertStreamsEqual(Stream.of(hawaiian, tropical, bbq), withPineapple);
    }

    @Test
    void testGetPizzasWithoutPineapple() {
        Stream<Pizza> withoutPineapple = solution.getPizzasWithoutPineapple(pizzas);

        assertStreamsEqual(Stream.of(margherita, pepperoni, vegetarian), withoutPineapple);
    }

    @Test
    void testGetPizzasWithTopping() {
        Stream<Pizza> withBasil = solution.getPizzasWithTopping(pizzas, "basil");

        // only margherita has basil
        assertStreamsEqual(Stream.of(margherita), withBasil);
    }

    @Test
    void testGetPizzasWithAnyOfToppings() {
        List<String> toppings = List.of("basil", "chicken");

        Stream<Pizza> pizzasContainingToppings = solution.getPizzasWithAnyOfToppings(pizzas, toppings);

        assertStreamsEqual(Stream.of(margherita, tropical, bbq), pizzasContainingToppings);
    }

    @Test
    void testSortPizzasByPrice() {
        Stream<Pizza> sortedByPrice = solution.sortPizzasByPrice(pizzas);

        assertStreamsEqual(Stream.of(margherita, vegetarian, pepperoni, hawaiian, bbq, tropical), sortedByPrice);
    }

    @Test
    void testSortPizzasByName() {
        Stream<Pizza> sortedByName = solution.sortPizzasByName(pizzas);

        assertStreamsEqual(Stream.of(bbq, hawaiian, margherita, pepperoni, tropical, vegetarian), sortedByName);
    }

    // If you got this far, you definitely deserve a slice of pizza.
    // Here you go: 🍕
    // Good job and enjoy! 😉
}
