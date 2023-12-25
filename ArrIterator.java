import java.util.NoSuchElementException;

/**
 * Created by :
 * Aviv Yonathan Eliyahu
 * Ariel Goldwaser
 * Matan Asraf
 */
public class ArrIterator<T> implements Iterator<T> {
    /**
     * Class's features
     */
    private int index = 0;
    private Object[] array;

    /**
     * a constructor that receives a generic T[] type of array and creates an ArrIterator object.
     * if the given array is null, throws NoSuchElementException();
     *
     * @param t given T array.
     */
    public ArrIterator(T[] t) {
        this.array = t;
    }

    /**
     * a constructor receives an int[] type of array, casting it using castToObject() method
     * and calls the generic ArrIterator(T[] t) constructor.
     *
     * @param t given int array.
     */
    public ArrIterator(int[] t) {
        this((T[]) castToObject(t));
    }

    /**
     * a constructor receives a double[] type of array, casting it using castToObject() method
     * and calls the generic ArrIterator(T[] t) constructor.
     *
     * @param t given int array.
     */
    public ArrIterator(double[] t) {
        this((T[]) castToObject(t));

    }

    /**
     * a constructor receives a char[] type of array, casting it using castToObject() method
     * and calls the generic ArrIterator(T[] t) constructor.
     *
     * @param t given int array.
     */
    public ArrIterator(char[] t) {
        this((T[]) castToObject(t));

    }

    /**
     * a method that receives an int[] type of array, casting it into an Object[] array and returns it
     * this method way of work (not code) was created with the help of ChatGPT.
     *
     * @param array the given int[] array
     * @return Object[] type of array
     */
    private static Object[] castToObject(int[] array) {
        Object[] objectArray = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            objectArray[i] = array[i];
        }
        return objectArray;
    }

    /**
     * a method that receives a double[] type of array, casting it into an Object[] array and returns it
     * this method way of work (not code) was created with the help of ChatGPT.
     *
     * @param array the given double[] array
     * @return Object[] type of array
     */
    private static Object[] castToObject(double[] array) {
        Object[] objectArray = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            objectArray[i] = array[i];
        }
        return objectArray;
    }

    /**
     * a method that receives a char[] type of array, casting it into an Object[] array and returns it
     * this method way of work (not code) was created with the help of ChatGPT.
     *
     * @param array the given char[] array
     * @return Object[] type of array
     */
    private static Object[] castToObject(char[] array) {
        Object[] objectArray = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            objectArray[i] = array[i];
        }
        return objectArray;
    }

    /**
     * a method that implemented from Iterator interface.
     * the method check if the given array has another object in its next index.
     *
     * @return true if it does, false if it doesn't.
     */
    @Override
    public boolean hasNext() {
        return index<=array.length - 1;
    }

    /**
     * a method that implemented from Iterator interface.
     * the method uses "hasNext()" method, if true - advance the index by 1 and return the element.
     *
     * @return if true - return next element and advance index
     * @throws NoSuchElementException in case that there isn't next element.
     */
    @Override
    public T next() throws NoSuchElementException {
        if (hasNext()) {
            T tmp = (T) array[index];
            index++;
            return tmp;

        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * a method that implemented from Iterator interface.
     * the method check if a given element exists inside our array.
     *
     * @param element the element we want to check if exists.
     * @return if exists - return element's index. if not - return -1
     */
    @Override
    public int indexOf(T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
}

