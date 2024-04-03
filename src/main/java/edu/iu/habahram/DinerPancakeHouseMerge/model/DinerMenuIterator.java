
package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
        this.position = 0;
    }
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }

    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
}
