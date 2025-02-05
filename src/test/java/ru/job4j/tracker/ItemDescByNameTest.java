package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(new Item("item3"), new Item("item1"), new Item("item2"));
        List<Item> expected = Arrays.asList(new Item("item3"), new Item("item2"), new Item("item1"));
        items.sort(new ItemDescByName());
        assertThat(items.equals(expected)).isTrue();
    }
}