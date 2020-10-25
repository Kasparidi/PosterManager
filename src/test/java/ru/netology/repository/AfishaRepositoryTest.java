package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    AfishaRepository afishaRepository = new AfishaRepository();

    AfishaItem first = new AfishaItem(1, 2, "first", "comedy", true);
    AfishaItem second = new AfishaItem(2, 2, "second", "drama", true);
    AfishaItem third = new AfishaItem(3, 3, "third", "thriller", true);
    AfishaItem forth = new AfishaItem(4, 4, "forth", "fiction", true);
    AfishaItem fifth = new AfishaItem(5, 5, "fifth", "fantasy", true);

    @BeforeEach
    public void setUp () {
        afishaRepository.save(first);
        afishaRepository.save(second);
        afishaRepository.save(third);
        afishaRepository.save(forth);
        afishaRepository.save(fifth);
    }

    @Test
    void save() {
    afishaRepository.findAll();
    AfishaItem[] actual = afishaRepository.findAll();
    AfishaItem[] expected = new AfishaItem[] {first, second, third, forth, fifth};
    assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        afishaRepository.findAll();
        AfishaItem[] actual = afishaRepository.findAll();
        AfishaItem[] expected = new AfishaItem[] {first, second, third, forth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        int idToRemove = 3;
        afishaRepository.removeById(idToRemove);
        AfishaItem[] actual = afishaRepository.findAll();
        AfishaItem[] expected = new AfishaItem[] {first, second, forth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        int idToFind = 4;
        afishaRepository.findById(idToFind);
        AfishaItem actual = afishaRepository.findById(idToFind);
        AfishaItem expected = forth;
        assertEquals(expected, actual);
    }

    @Test
    void findByIdNotExist() {
        int idToFind = 6;
        afishaRepository.findById(idToFind);
        AfishaItem actual = afishaRepository.findById(idToFind);
        AfishaItem expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void removeAll() {
        afishaRepository.removeAll();
        AfishaItem[] actual = afishaRepository.findAll();
        AfishaItem[] expected = {};
        assertArrayEquals(expected, actual);
    }
}