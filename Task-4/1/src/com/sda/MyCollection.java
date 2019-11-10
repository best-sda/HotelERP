package com.sda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyCollection<T> implements Collection<T> {
    private final int INIT_SIZE = 5;
    private Object[] arr;
    private int size;

    public MyCollection() {
        this.arr = new Object[INIT_SIZE];
        this.size = 0;
    }

    public MyCollection(T[] arr) {
        this.arr = arr == null ? new Object[INIT_SIZE] :
                Arrays.copyOf(arr, arr.length);
        this.size = arr == null ? 0 : arr.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {
        return Arrays.stream(arr).limit(size).anyMatch(e -> e == object);
    }

    @Override
    public Iterator iterator() {
        return Arrays.stream(arr).limit(size).iterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    @Override
    public <E> E[] toArray(E[] a) {
        if (size <= a.length) {
            Object[] result = new Object[a.length];
            Arrays.copyOf(Arrays.stream(arr).limit(size).toArray(), size);
            return ((E[]) result);
        }
        return (E[]) Arrays.stream(arr).limit(size).toArray();
    }

    @Override
    public boolean add(T t) {
        if (size >= arr.length - 1) {
           resize(arr.length*2);
       }
        arr[size++] = t;
        return true;
    }

    private void resize(int newLength) {
        Object[] newArr = new Object[newLength];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    @Override
    public boolean remove(Object object) {
        int index = Arrays.asList(arr).indexOf(object);
        if (index == size - 1) {
            size--;
        } else if (index >= 0) {
            System.arraycopy(arr, index + 1, arr, index, size - index);
            return true;
        }
        return false;
    }


    @Override
    public boolean containsAll(Collection <?> c) {
        return Arrays.stream(arr).limit(size).allMatch(c::contains);
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object object : c) {
            add((T) object);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection <?> c) {
        int sizeBefore = arr.length;
        arr = Arrays.stream(arr).limit(size).filter(e -> c.contains(e)).toArray();
        size = arr.length;
        return sizeBefore != arr.length;
    }

    @Override
    public boolean retainAll(Collection c) {
        int sizeBefore = arr.length;
        arr = Arrays.stream(arr).limit(size).filter(c::contains).toArray();
        size = arr.length;
        return sizeBefore != arr.length;
    }

    @Override
    public void clear() {
        arr = new Object[INIT_SIZE];
        size = 0;
    }

}
