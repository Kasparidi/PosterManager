package ru.netology.manager;

import ru.netology.domain.PosterItem;

public class PosterManager {
    private PosterItem[] items = new PosterItem[0];

    public void add(PosterItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        PosterItem[] tmp = new PosterItem[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PosterItem[] getAll() {
        PosterItem[] result = new PosterItem[items.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < items.length; i++) {
            int index = items.length - i - 1;
            if (index <= 9) {
            }
            result[i] = items[index];
        }
        return result;
    }

    // наивная реализация
    public void removeById(int id) {
        int length = items.length - 1;
        PosterItem[] tmp = new PosterItem[length];
        int index = 0;
        for (PosterItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        // меняем наши элементы
        items = tmp;
    }
}







