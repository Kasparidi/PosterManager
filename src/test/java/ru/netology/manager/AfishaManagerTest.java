package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.AfishaItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {

    @Mock
            private AfishaRepository repository;

    @InjectMocks
            AfishaManager manager;

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

//    @Test
//    void shouldSave() {
//        AfishaItem[] returned = new AfishaItem[] {first, second, third, forth, fifth};
//        doReturn(returned).when(repository).findAll();
//        doNothing().when(repository).add(AfishaItem);
//        manager.add(AfishaItem);
//        AfishaItem[] actual = manager.getAll();
//        AfishaItem[] expected = new AfishaItem[] {fifth, forth, third, second, first};
//        assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldRemoveIfExist() {
        int idToRemove = 1;
        AfishaItem[] returned = new AfishaItem[] {second,third, forth,fifth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        AfishaItem[] actual = manager.getAll();
        AfishaItem[] expected = new AfishaItem[]{fifth, forth, third, second};
        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }

    @Test
    public void findById() {
        int idToFind = 3;
        AfishaItem[] returned = new AfishaItem[] {null, null, third, null, null};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).findById(idToFind);
        manager.findById(idToFind);
        AfishaItem[] actual = manager.getAll();
        AfishaItem[] expected = new AfishaItem[] {null, null, third, null, null};
        assertArrayEquals(expected, actual);
        verify(repository).findById(idToFind);
    }

    @Test
    public void shouldRemoveIfNotExist() {
        int idToRemove = 6;
        AfishaItem[] returned = new AfishaItem[] {first, second, third, forth, fifth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        AfishaItem[] actual = manager.getAll();
        AfishaItem[] expected = new AfishaItem[]{fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }


}