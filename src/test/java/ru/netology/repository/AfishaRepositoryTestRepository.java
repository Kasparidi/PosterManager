package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTestRepository {

    AfishaRepository afishaRepository = new AfishaRepository();
    AfishaItem first = new AfishaItem(1, 1, "first", 1, 1);
    AfishaItem second = new AfishaItem(2, 2, "second", 2, 2);
    AfishaItem third = new AfishaItem(3, 3, "third", 3, 3);
    AfishaItem forth = new AfishaItem(4, 4, "forth", 4, 4);
    AfishaItem fifth = new AfishaItem(5, 5, "fifth", 5, 5);

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
    void removeById() {
        int idToRemove = 3;
        afishaRepository.removeById(idToRemove);
        AfishaItem[] actual = afishaRepository.findAll();
        AfishaItem[] expected = new AfishaItem[] {first, second, forth, fifth};
        assertArrayEquals(expected, actual);
    }

//    @Test
//    void findById() {
//        int idToFind = 4;
//        afishaRepository.findById(idToFind);
//        AfishaItem[] actual = afishaRepository.findAll();
//        AfishaItem[] expected = new AfishaItem[] {null, null, null, forth, null};
//        assertArrayEquals(expected, actual);
//    }

//    @Test
//    void removeAll() {
//        afishaRepository.removeAll();
//        AfishaItem[] actual = afishaRepository.findAll();
//        AfishaItem[] expected = new AfishaItem[] {null, null, null, null, null};
//        assertArrayEquals(expected, actual);
//    }
}