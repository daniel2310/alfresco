package fizzbuzzforalfresco.demo;

import fizzbuzzforalfresco.demo.dto.Range;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class FizzBuzz {

    public static final String FIZZ = "fizz";
    public static final String BUZZ = "buzz";
    public static final String ALFRESCO = "alfresco";

    public String printResult(Range range, boolean firstSolution) {

        if (firstSolution) {
            return IntStream.rangeClosed(range.getMinValue(), range.getMaxValue())
                    .mapToObj(this::computeFirstSolution)
                    .collect(Collectors.joining(" "));
        } else {
            return IntStream.rangeClosed(range.getMinValue(), range.getMaxValue())
                    .mapToObj(this::computeSecondSolution)
                    .collect(Collectors.joining(" "));
        }
    }

    private String computeFirstSolution(Integer number) {
        String result = Optional.of(number)
                .map(n -> (isMultipleOfValue(n, 3) ? FIZZ : "")
                        + (isMultipleOfValue(n, 5) ? BUZZ : ""))
                .get();

        return result.isEmpty() ? Integer.toString(number) : result;
    }

    private String computeSecondSolution(Integer number) {
        String result = Optional.of(number)
                .map(n ->
                        (containsSpecifiedValue(n, "3") ? ALFRESCO : "")
                                + (isMultipleOfValue(n, 3) && (!containsSpecifiedValue(n, "3")) ? FIZZ : "")
                                + (isMultipleOfValue(n, 5) ? BUZZ : ""))
                .get();

        return result.isEmpty() ? Integer.toString(number) : result;
    }

    private boolean isMultipleOfValue(Integer number, int value) {
        return number % value == 0;
    }

    private boolean containsSpecifiedValue(Integer number, String value) {
        return String.valueOf(number).contains(value);
    }
}
