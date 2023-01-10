package io.mpj.in28minutes.unittesting.unittesting.spike;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class AssertjTest {
    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 15, 45);

        assertThat(numbers)
                .hasSize(3)
                .contains(12, 45)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100);

        assertThat("").isEmpty();
        assertThat("ABCDE")
                .contains("BCD")
                .startsWith("AB")
                .endsWith("DE");
    }
}
