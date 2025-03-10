package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenNothingFound() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Dmitriy", "Trotsenko", "12345", "Ufa")
        );
        ArrayList<Person> persons = phones.find("Moscow");
        assertThat(persons.isEmpty());
    }

        @Test
        public void whenFindByNameFunction() {
            var phones = new PhoneDictionary();
            phones.add(
                    new Person("Petr", "Arsentev", "534872", "Bryansk")
            );
            ArrayList<Person> persons = phones.find("Petr");
            assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
        }
}