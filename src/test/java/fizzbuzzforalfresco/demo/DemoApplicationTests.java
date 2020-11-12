package fizzbuzzforalfresco.demo;

import fizzbuzzforalfresco.demo.dto.Range;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Mock
    private FizzBuzz fizzBuzz;

    @ParameterizedTest(name = "{index} => expectedString: ''{0}''")
    @MethodSource("textSource")
    void testFizzBuzz(String expectedString, boolean firstSolution) {
        Range range = new Range(1, 20);
        Mockito.doCallRealMethod().when(fizzBuzz).printResult(range, firstSolution);

        assertEquals(expectedString, fizzBuzz.printResult(range, firstSolution));
    }

    private static Stream<Arguments> textSource() {
        return Stream.of(
                Arguments.of("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz", true),
                Arguments.of("1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz", false)
        );
    }

}
