package array_hw;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {
    private Object[] array;
    private int capacityOfArray;

    public ArrayImpl() {
        array = new Object[]{};
        capacityOfArray = 0;
    }

    public ArrayImpl(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        if (capacity > 0) {
            array = new Object[capacity];
        } else if (capacity == 0) {
            array = new Object[]{};
        }
        capacityOfArray = 0;
    }

    @Override
    public void clear() {
        capacityOfArray = 0;
    }

    @Override
    public int size() {
        return this.capacityOfArray;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        int index = 0;

        public IteratorImpl() {
        }

        @Override
        public boolean hasNext() {
            if (index < size()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[index++];
        }

        @Override
        public void remove() {
            index--;
            final Object[] newArray = new Object[array.length - 1];
            int indexToRemove = index + 1;

            System.arraycopy(array, 0, newArray, 0, indexToRemove);
            System.arraycopy(array, indexToRemove + 1, newArray, indexToRemove, newArray.length - indexToRemove);

            array = newArray;
        }
    }

    @Override
    public void add(Object element) {
        if (capacityOfArray != array.length) {
            array[capacityOfArray++] = element;
        } else {
            Object[] var = new Object[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                var[i] = array[i];
            }
            var[array.length] = element;
            capacityOfArray += 1;
            array = var;
        }
    }

    @Override
    public void set(int index, Object element) {
        if ((index > (capacityOfArray - 1)) || (index < 0))
            throw (new NoSuchElementException());
        array[index] = element;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < capacityOfArray; i++) {
                if (array[i] == null)
                    return i;
            }
            return -1;
        }

        for (int i = 0; i < capacityOfArray; i++) {
            if (array[i] == null)
                continue;
            if (array[i].equals(element))
                return i;
        }

        return -1;
    }

    @Override
    public void remove(int index) {
        Object[] newArray = new Object[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (i < index) {
                newArray[i] = array[i];
            } else if (i > index) {
                newArray[i - 1] = this.array[i];
            }
        }
        array = newArray;
        capacityOfArray -= 1;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) stringBuilder.append(array[i]);
            else stringBuilder.append(array[i]).append(", ");
        }
        return "[" + stringBuilder.toString() + "]";
    }


    public static void main(String[] args) {
        Array arr = new ArrayImpl(3);
        arr.add("Andrey");
        arr.add("Artem");
        arr.add("John");
        System.out.print(arr.toString());
        System.out.print("\n");
        Iterator<Object> it = arr.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.print("\n");

        Array arr2 = new ArrayImpl(3);
        arr2.add("Andrey");
        arr2.add("Artem");
        arr2.add("John");
        Iterator<Object> it2 = arr2.iterator();
        it2.remove();
        System.out.print(arr2.toString());
    }
}