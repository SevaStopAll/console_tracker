package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

class FactTest {

    @Test
    public void whenException() {
        IllegalAccessException exception = assertThrows(
                IllegalAccessException.class,
                () -> {
                    Fact.calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0.");
    }

    @Test
    public void when3Then6() throws IllegalAccessException {
        int number = 3;
        int expected = 6;
        int result = Fact.calc(number);
        assertThat(result).isEqualTo(expected);
    }

}
