package com.mycompany;

public class Array<T> {
    private T[] items;
    private int count;

    public Array(int length) {
        items = (T[]) new Object[length];
    }

    public void insert(T item) {
        resizeIfRequired();
        items[count++] = item;
    }

    public void insertAt(T item, int index) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        // Note that I've extracted the logic for
        // resizing the array into this private
        // method so we can reuse in insert() and
        // insertAt() methods.
        //
        // This also made our code cleaner and
        // more readable.
        resizeIfRequired();

        for (int i = count - 1; i >= index; i--)
            items[i + 1] = items[i];

        items[index] = item;
        count++;
    }

    private void resizeIfRequired() {
        if (items.length == count) {
            T[] newItems = (T[]) new Object[2*count];

            for (int i = 0; i < count; i++)
                newItems[i] = items[i];

            items = newItems;
        }
    }

    public void reverse() {
        T[] newItems = (T[]) new Object[count];

        for (int i = 0; i < count; i++)
            newItems[i] = items[count - i - 1];

        items = newItems;
    }

    public <T extends Comparable<? super T>> T max(T a, T b) {
        // O(n): Because we have to iterate over
        // the entire array to find the largest
        // number. This number may be at the end
        // of the array (worst case scenario).
        if(a == null){
            if(b == null) return a;
            else return b;
        }
        if(b == null){
            return a;
        }
        return a.compareTo(b) > 0 ? a : b;
    }

    public Array intersect(Array other) {
        var intersection = new Array(count);

        for (T item : items)
            if (other.indexOf(item) >= 0)
                intersection.insert(item);

        return intersection;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i + 1];

        count--;
    }

    public int indexOf(T item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;

        return -1;
    }

    public void clear(){
        items = null;
        count = 0;
    }

    public int getSize(){
        return count;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }
}
