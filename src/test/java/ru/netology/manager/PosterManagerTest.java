package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.*;

public class PosterManagerTest {

    PosterManager manager = new PosterManager();
    PosterItem first = new PosterItem(1, 2, "first", 1, 1);
    PosterItem second = new PosterItem(2, 2, "second", 2, 2);
    PosterItem third = new PosterItem(3, 3, "third", 3, 3);
    PosterItem forth = new PosterItem(4, 4, "forth", 4, 4);
    PosterItem fifth = new PosterItem(5, 5, "fifth", 5, 5);

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
        PosterItem sixth = new PosterItem(6, 6, "sixth", 6, 6);
        PosterItem seventh = new PosterItem(7, 7, "seventh", 7, 7);
        PosterItem eighth = new PosterItem(8, 8, "eighth", 8, 8);
        PosterItem ninth = new PosterItem(9, 9, "ninth", 9, 9);
        PosterItem tenth = new PosterItem(10, 10, "tenth", 10, 10);
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
        PosterItem sixth = new PosterItem(6, 6, "sixth", 6, 6);
        PosterItem seventh = new PosterItem(7, 7, "seventh", 7, 7);
        PosterItem eighth = new PosterItem(8, 8, "eighth", 8, 8);
        PosterItem ninth = new PosterItem(9, 9, "ninth", 9, 9);
        PosterItem tenth = new PosterItem(10, 10, "tenth", 10, 10);
        PosterItem eleventh = new PosterItem(11, 11, "eleventh", 11, 11);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        PosterItem[] actual = manager.getAll();
        PosterItem[] expected = new PosterItem[] {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, null};
        assertArrayEquals(expected, actual);

    }
}