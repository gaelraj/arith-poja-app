package school.hei.exo.service;

import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

class ArithServiceTest {

    private final ArithService arithService = new ArithService();

    // TESTS FOR ADDITION

    @Test
    void addition_of_two_positive_numbers_returns_their_sum() {
        double result = arithService.add(10.0, 5.0);
        assertEquals(15.0, result);
    }

    @Test
    void addition_with_zero_returns_the_same_number() {
        double result = arithService.add(0.0, 7.0);
        assertEquals(7.0, result);
    }

    @Test
    void addition_with_decimal_numbers_works_correctly() {
        double result = arithService.add(2.5, 3.7);
        assertEquals(6.2, result);
    }

    @Test
    void addition_with_negative_first_number_throws_error() {
        assertThrows(ResponseStatusException.class,
                () -> arithService.add(-10.0, 5.0));
    }

    @Test
    void addition_with_negative_second_number_throws_error() {
        assertThrows(ResponseStatusException.class,
                () -> arithService.add(10.0, -5.0));
    }

    @Test
    void addition_with_NaN_throws_error() {
        assertThrows(ResponseStatusException.class,
                () -> arithService.add(Double.NaN, 5.0));
    }

    // TESTS FOR SUBTRACTION

    @Test
    void subtraction_of_two_positive_numbers_returns_difference() {
        double result = arithService.subtract(10.0, 3.0);
        assertEquals(7.0, result);
    }

    @Test
    void subtraction_can_return_a_negative_result() {
        double result = arithService.subtract(5.0, 10.0);
        assertEquals(-5.0, result);
    }

    @Test
    void subtraction_with_zero_does_nothing() {
        double result = arithService.subtract(8.0, 0.0);
        assertEquals(8.0, result);
    }

    @Test
    void subtraction_with_decimal_numbers_works() {
        double result = arithService.subtract(10.5, 3.2);
        assertEquals(7.3, result);
    }

    @Test
    void subtraction_with_negative_numbers_works() {
        double result = arithService.subtract(-5.0, -3.0);
        assertEquals(-2.0, result);
    }

    @Test
    void subtraction_with_NaN_throws_error() {
        assertThrows(ResponseStatusException.class,
                () -> arithService.subtract(Double.NaN, 5.0));
    }

    // TESTS FOR MULTIPLICATION

    @Test
    void multiplication_of_two_positive_numbers_returns_positive_result() {
        double result = arithService.multiply(4.0, 3.0);
        assertEquals(12.0, result);
    }

    @Test
    void multiplication_with_zero_returns_zero() {
        double result = arithService.multiply(10.0, 0.0);
        assertEquals(0.0, result);
    }

    @Test
    void multiplication_with_decimal_numbers_works() {
        double result = arithService.multiply(2.5, 1.5);
        assertEquals(3.75, result);
    }

    @Test
    void positive_multiplied_by_negative_returns_negative() {
        double result = arithService.multiply(5.0, -3.0);
        assertEquals(-15.0, result);
    }

    @Test
    void negative_multiplied_by_negative_returns_positive() {
        double result = arithService.multiply(-4.0, -2.0);
        assertEquals(8.0, result);
    }

    @Test
    void multiplication_with_infinite_number_throws_error() {
        assertThrows(ResponseStatusException.class,
                () -> arithService.multiply(Double.POSITIVE_INFINITY, 5.0));
    }

    //TESTS FOR DIVISION

    @Test
    void division_of_two_positive_numbers_returns_positive_result() {
        double result = arithService.divide(10.0, 2.0);
        assertEquals(5.0, result);
    }

    @Test
    void division_with_numerator_zero_returns_zero() {
        double result = arithService.divide(0.0, 5.0);
        assertEquals(0.0, result);
    }

    @Test
    void division_with_decimal_numbers_works() {
        double result = arithService.divide(7.5, 2.5);
        assertEquals(3.0, result);
    }

    @Test
    void division_by_zero_throws_error() {
        assertThrows(ResponseStatusException.class,
                () -> arithService.divide(10.0, 0.0));
    }

    @Test
    void positive_divided_by_negative_returns_negative() {
        double result = arithService.divide(10.0, -2.0);
        assertEquals(-5.0, result);
    }

    @Test
    void negative_divided_by_negative_returns_positive() {
        double result = arithService.divide(-10.0, -2.0);
        assertEquals(5.0, result);
    }

    @Test
    void division_with_NaN_throws_error() {
        assertThrows(ResponseStatusException.class,
                () -> arithService.divide(Double.NaN, 5.0));
    }
}