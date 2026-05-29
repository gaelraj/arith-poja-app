package school.hei.exo.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ArithService {

    public double add(double a, double b) {
        validatePositive(a, "First operand");
        validatePositive(b, "Second operand");

        double result = a + b;

        if (Double.isInfinite(result)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Addition overflow! Result is too large.");
        }

        return result;
    }

    public double subtract(double a, double b) {
        validateNotNull(a, b);

        double result = a - b;

        if (Double.isInfinite(result)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Subtraction overflow! Result is too large.");
        }

        return result;
    }

    public double multiply(double a, double b) {
        validateNotNull(a, b);

        double result = a * b;

        if (Double.isInfinite(result)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Multiplication overflow! Result is too large.");
        }

        return result;
    }

    public double divide(double a, double b) {
        validateNotNull(a, b);

        if (b == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Division by zero is not allowed!");
        }

        double result = a / b;

        if (Double.isInfinite(result)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Division results in infinity!");
        }

        return result;
    }

    private void validatePositive(double value, String operandName) {
        if (Double.isNaN(value)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    operandName + " cannot be NaN (Not a Number)!");
        }

        if (Double.isInfinite(value)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    operandName + " cannot be infinite!");
        }

        if (value < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    operandName + " must be positive! Provided value: " + value);
        }
    }

    private void validateNotNull(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Operands cannot be NaN (Not a Number)!");
        }

        if (Double.isInfinite(a) || Double.isInfinite(b)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Operands cannot be infinite!");
        }
    }
}