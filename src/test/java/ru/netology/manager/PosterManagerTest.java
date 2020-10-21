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

    @BeforeEach
    public void SetUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void removeByID() {
    int idToRemove = 1;
    manager.removeById(idToRemove);
    PosterItem[] actual = manager.getAll();
    PosterItem[] expected = new PosterItem[] {third, second};
    assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNotRemoveIfNotExist() {
        PosterManager manager = new PosterManager();
        int idToRemove = 4;
        manager.removeById(idToRemove);
        PosterItem[] actual = manager.getAll();
        PosterItem[] expected = new PosterItem[] {third, second};
        assertArrayEquals(expected, actual);

    }
}