package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaManagerTest {

    AfishaManager manager = new AfishaManager();
    AfishaItem first = new AfishaItem(1, 2, "first", 1, 1);
    AfishaItem second = new AfishaItem(2, 2, "second", 2, 2);
    AfishaItem third = new AfishaItem(3, 3, "third", 3, 3);
    AfishaItem forth = new AfishaItem(4, 4, "forth", 4, 4);
    AfishaItem fifth = new AfishaItem(5, 5, "fifth", 5, 5);

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
        AfishaItem sixth = new AfishaItem(6, 6, "sixth", 6, 6);
        AfishaItem seventh = new AfishaItem(7, 7, "seventh", 7, 7);
        AfishaItem eighth = new AfishaItem(8, 8, "eighth", 8, 8);
        AfishaItem ninth = new AfishaItem(9, 9, "ninth", 9, 9);
        AfishaItem tenth = new AfishaItem(10, 10, "tenth", 10, 10);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        AfishaItem[] actual = manager.getAll();
        AfishaItem[] expected = new AfishaItem[] {tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddFive() {
        AfishaItem[] actual = manager.getAll();
        AfishaItem[] expected = new AfishaItem[] {fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotAddMoreThanTen() {
        AfishaItem sixth = new AfishaItem(6, 6, "sixth", 6, 6);
        AfishaItem seventh = new AfishaItem(7, 7, "seventh", 7, 7);
        AfishaItem eighth = new AfishaItem(8, 8, "eighth", 8, 8);
        AfishaItem ninth = new AfishaItem(9, 9, "ninth", 9, 9);
        AfishaItem tenth = new AfishaItem(10, 10, "tenth", 10, 10);
        AfishaItem eleventh = new AfishaItem(11, 11, "eleventh", 11, 11);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        AfishaItem[] actual = manager.getAll();
        AfishaItem[] expected = new AfishaItem[] {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, null};
        assertArrayEquals(expected, actual);

    }
}