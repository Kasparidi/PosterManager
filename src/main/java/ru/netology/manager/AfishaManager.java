package ru.netology.manager;

import ru.netology.domain.AfishaItem;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository afishaRepository;

    public AfishaManager(AfishaRepository repository) {this.repository = repository;}

    public void add(AfishaItem item) {
        repository.save(item);
    }

    public AfishaItem[] getAll() {
        AfishaItem[] items = repository.findAll();
        AfishaItem[] result = new AfishaItem[items.length];
        for (int i = 0; i < items.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
            if (i >= 9) break;
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}







