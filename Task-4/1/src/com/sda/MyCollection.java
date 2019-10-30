package com.sda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class MyCollection<T> implements Collection<T> {
    private final int INIT_SIZE = 5;
    //private final int CUT_RATE = 4;
    private Object[] arr = new Object[INIT_SIZE];
    private int size = 0;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator <T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size)
            return (T1[]) Arrays.copyOf(arr, size, a.getClass());
        System.arraycopy(arr, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }



    @Override
    public boolean add(T t) {
       if (size == arr.length - 1) {
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
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {
                System.arraycopy(arr, i + 1, arr, i,size--);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean containsAll(Collection <?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection <? extends T> c) {
        Object[] a = c.toArray();
        if (arr.length <= size+ a.length +1){
            System.arraycopy(a, 0, arr, size,a.length );
            return true;
        }
        else {
            resize(arr.length + a.length +1);
            System.arraycopy(a, 0, arr, size,a.length );
            return true;
        }
    }

    @Override
    public boolean removeAll(Collection <?> c) {
        Object[] a = c.toArray();
        int count = 0;
        for (int i = 0; i < a.length ; i++) {
            for (int j = 0; j < size ; j++) {
                if (arr[i].equals(a[i])) {
                    System.arraycopy(arr, i + 1, arr, i,size--);
                    count++;
                }

            }
        }
        if (count == a.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeIf(Predicate <? super T> filter) {
        return false;
    }

    @Override
    public boolean retainAll(Collection <?> c) {
        Object[] a = c.toArray();

        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size ; i++) {
            arr[i] = null;
        }
    }
}
