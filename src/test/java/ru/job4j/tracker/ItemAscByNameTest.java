package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(new Item("item3"), new Item("item1"), new Item("item2"));
        List<Item> expected = Arrays.asList(new Item("item1"), new Item("item2"), new Item("item3"));
        items.sort(new ItemAscByName());
        assertThat(items.equals(expected)).isTrue();
    }
}