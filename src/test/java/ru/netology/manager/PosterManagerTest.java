package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.*;

public class PosterManagerTest {

    PosterManager manager = new PosterManager();
    PosterItem first = new PosterItem(1, 2, "first", "comedy", true);
    PosterItem second = new PosterItem(2, 2, "second", "drama", true);
    PosterItem third = new PosterItem(3, 3, "third", "thriller", true);
    PosterItem forth = new PosterItem(4, 4, "forth", "fiction", true);
    PosterItem fifth = new PosterItem(5, 5, "fifth", "fantasy", true);
    PosterItem sixth = new PosterItem(6, 6, "sixth", "comedy", true);
    PosterItem seventh = new PosterItem(7, 7, "seventh", "drama", true);
    PosterItem eighth = new PosterItem(8, 8, "eighth", "thriller", true);
    PosterItem ninth = new PosterItem(9, 9, "ninth", "fiction", true);
    PosterItem tenth = new PosterItem(10, 10, "tenth", "fantasy", true);
    PosterItem eleventh = new PosterItem(11, 11, "eleventh", "comedy", true);

    @BeforeEach
    public void SetUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
    }

    @Test
    void shouldAddTen() {
        PosterItem sixth = new PosterItem(6, 6, "sixth", "comedy", true);
        PosterItem seventh = new PosterItem(7, 7, "seventh", "drama", true);
        PosterItem eighth = new PosterItem(8, 8, "eighth", "thriller", true);
        PosterItem ninth = new PosterItem(9, 9, "ninth", "fiction", true);
        PosterItem tenth = new PosterItem(10, 10, "tenth", "fantasy", true);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        PosterItem[] actual = manager.getAll();
        PosterItem[] expected = new PosterItem[] {tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddFive() {
        PosterItem[] actual = manager.getAll();
        PosterItem[] expected = new PosterItem[] {fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotAddMoreThanTen() {
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        PosterItem[] actual = manager.getAll();
        PosterItem[] expected = new PosterItem[] {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second};
        assertArrayEquals(expected, actual);
    }
}