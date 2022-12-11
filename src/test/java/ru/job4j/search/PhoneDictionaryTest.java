package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenListIsEmpty() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Alex");
        boolean result = persons.isEmpty();
        assertThat(result).isTrue();
    }

    @Test
    public void whenOutOfBoundsException() {
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> {
                    PhoneDictionary phones = new PhoneDictionary();
                    phones.add(
                            new Person("Petr", "Arsentev", "534872", "Bryansk")
                    );
                    ArrayList<Person> persons = phones.find("Kirill");
                    persons.get(0).getSurname();
                });
        assertThat(exception.getMessage()).isEqualTo("Index 0 out of bounds for length 0");
    }
}