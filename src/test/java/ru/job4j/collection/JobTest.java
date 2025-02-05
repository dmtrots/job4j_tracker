package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAsc() {
        Comparator<Job> cmpNameAsc = new JobAscByName();
        int result = cmpNameAsc.compare(
                new Job("BBB", 0),
                new Job("AAA", 0)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameDesc() {
        Comparator<Job> cmpNameAsc = new JobDescByName();
        int result = cmpNameAsc.compare(
                new Job("BBB", 0),
                new Job("BBB", 0)
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenComparatorByPriorityAsc() {
        Comparator<Job> cmpNameAsc = new JobAscByPriority();
        int result = cmpNameAsc.compare(
                new Job("BBB", 1),
                new Job("BBB", 0)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        Comparator<Job> cmpNameAsc = new JobDescByPriority();
        int result = cmpNameAsc.compare(
                new Job("AAA", 2),
                new Job("XXX", 0)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAscAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAscAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int result = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 2)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameDescAndPriorityAscAndNameAsc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority().thenComparing(new JobAscByName()));
        int result = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 0)
        );
        assertThat(result).isEqualTo(0);
    }
}