package ru.job4j.tracker;

import org.junit.jupiter.api.*;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;
    private SqlTracker tracker;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @BeforeEach
    void initTracker() {
        tracker = new SqlTracker(connection);
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    void whenAddItemThenFindByIdReturnsSameItem() {
        Item item = new Item("test");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result).isEqualTo(item);
    }

    @Test
    void whenReplaceItemThenOldItemIsReplaced() {
        Item item = tracker.add(new Item("old"));
        Item newItem = new Item("new");
        boolean replaced = tracker.replace(item.getId(), newItem);
        assertThat(replaced).isTrue();
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("new");
    }

    @Test
    void whenReplaceNonExistingItemThenReturnsFalse() {
        boolean replaced = tracker.replace(999, new Item("does not exist"));
        assertThat(replaced).isFalse();
    }

    @Test
    void whenDeleteItemThenCannotFindIt() {
        Item item = tracker.add(new Item("toDelete"));
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenDeleteNonExistingItemThenNothingHappens() {
        tracker.delete(999);
        assertThat(tracker.findAll()).isEmpty();
    }

    @Test
    void whenFindAllItemsThenReturnsAll() {
        Item item1 = tracker.add(new Item("first"));
        Item item2 = tracker.add(new Item("second"));
        List<Item> all = tracker.findAll();
        assertThat(all).containsExactlyInAnyOrder(item1, item2);
    }

    @Test
    void whenFindByNameThenReturnsMatchingItems() {
        Item item1 = tracker.add(new Item("match"));
        Item item2 = tracker.add(new Item("nomatch"));
        Item item3 = tracker.add(new Item("match"));
        List<Item> found = tracker.findByName("match");
        assertThat(found).containsExactlyInAnyOrder(item1, item3);
        assertThat(found).doesNotContain(item2);
    }

    @Test
    void whenFindByIdNonExistingThenReturnsNull() {
        assertThat(tracker.findById(999)).isNull();
    }
}