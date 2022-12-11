package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddDoublePassport() {
        Citizen citizen = new Citizen("2424ff", "Ivan Ivanov");
        Citizen citizen2 = new Citizen("2424ff", "Petr Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizen2);
        boolean result = office.add(citizen2);
        assertThat(result).isFalse();
    }
}