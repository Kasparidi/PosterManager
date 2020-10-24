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

    AfishaItem first = new AfishaItem(1, 2, "first", "comedy", true);
    AfishaItem second = new AfishaItem(2, 2, "second", "drama", true);
    AfishaItem third = new AfishaItem(3, 3, "third", "thriller", true);
    AfishaItem forth = new AfishaItem(4, 4, "forth", "fiction", true);
    AfishaItem fifth = new AfishaItem(5, 5, "fifth", "fantasy", true);

    @BeforeEach
    public void SetUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
    }

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