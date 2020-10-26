package ru.netology.manager;

import ru.netology.domain.PosterItem;

public class PosterManager {
    private PosterItem[] items = new PosterItem[0];
    private int afishaLength = 10;

    PosterManager() {
    }

    public PosterManager(int afishaLength) {
        this.afishaLength = afishaLength;
    }

    public void add(PosterItem item) {
        int length = items.length + 1;
        PosterItem[] tmp = new PosterItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PosterItem[] getAll() {
        PosterItem[] result = new PosterItem[Math.min(items.length, afishaLength)];
        for (int i = 0; i < items.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
            if ( i >= 9) break;
        }
        return result;
    }
}







