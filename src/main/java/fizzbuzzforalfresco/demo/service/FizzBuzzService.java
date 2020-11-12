package fizzbuzzforalfresco.demo.service;

import fizzbuzzforalfresco.demo.FizzBuzz;
import fizzbuzzforalfresco.demo.dto.Range;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class FizzBuzzService {

    private String result;

    public void firstSolution(Range range) {
        result = IntStream.rangeClosed(range.getMinValue(), range.getMaxValue())
                .mapToObj(this::computeFirstSolution)
                .collect(Collectors.joining(" "));
    }

    public void secondSolution(Range range) {
        result = IntStream.rangeClosed(range.getMinValue(), range.getMaxValue())
                .mapToObj(this::computeSecondSolution)
                .collect(Collectors.joining(" "));
    }


    private String computeFirstSolution(Integer number) {
        String result = Optional.of(number)
                .map(n -> (isMultipleOfValue(n, 3) ? FizzBuzz.FIZZ : "")
                        + (isMultipleOfValue(n, 5) ? FizzBuzz.BUZZ : ""))
                .get();

        return result.isEmpty() ? Integer.toString(number) : result;
    }

    private String computeSecondSolution(Integer number) {
        String result = Optional.of(number)
                .map(n ->
                        (containsSpecifiedValue(n, "3") ? FizzBuzz.ALFRESCO : "")
                                + (isMultipleOfValue(n, 3) && (!containsSpecifiedValue(n, "3")) ? FizzBuzz.FIZZ : "")
                                + (isMultipleOfValue(n, 5) ? FizzBuzz.BUZZ : ""))
                .get();

        return result.isEmpty() ? Integer.toString(number) : result;
    }

    private boolean isMultipleOfValue(Integer number, int value) {
        return number % value == 0;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private boolean containsSpecifiedValue(Integer number, String value) {
        return String.valueOf(number).contains(value);
    }
}
