package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerLengthTest {

    PosterItem first = new PosterItem(1, 2, "first", "comedy", true);
    PosterItem second = new PosterItem(2, 2, "second", "drama", true);
    PosterItem third = new PosterItem(3, 3, "third", "thriller", true);
    PosterItem forth = new PosterItem(4, 4, "forth", "fiction", true);
    PosterItem fifth = new PosterItem(5, 5, "fifth", "fantasy", true);
    PosterItem sixth = new PosterItem(6, 6, "sixth", "comedy", true);

    @Test
    public void shouldAddFour() {
        PosterManager manager = new PosterManager(4);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        PosterItem[] actual = manager.getAll();
        PosterItem[] expected = new PosterItem[] {forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddFive() {
        PosterManager manager = new PosterManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        PosterItem[] actual = manager.getAll();
        PosterItem[] expected = new PosterItem[] {fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSix() {
        PosterManager manager = new PosterManager(6);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        PosterItem[] actual = manager.getAll();
        PosterItem[] expected = new PosterItem[] {sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}
