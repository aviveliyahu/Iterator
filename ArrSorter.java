import java.util.Arrays;

/**
 * Created by :
 * Aviv Yonathan Eliyahu
 * Ariel Goldwaser
 * Matan Asraf
 */
public class ArrSorter<T> {
    public static final int BUBBLE_SORT = 1;
    public static final int MERGE_SORT = 2; // default sort
    public static final int QUICK_SORT = 3;

    /**
     * Class's features
     */
    private Object[] arrOrigin;
    private Object[] arrSorted;
    private Object[] arrReversed;

    /**
     * a constructor that receives a T[] type of array, calling a constructor with default sort algorithm
     * which is merge_sort.
     *
     * @param t given T[] array.
     */
    public ArrSorter(T[] t) {
        this(t, MERGE_SORT);
    }

    /**
     * a constructor that receives a T[] type of array and sort algorithm number (as int)
     * creating the object using selected sort algorithm.
     * if unknown algorithm number entered - creating object with only arrOrigin feature.
     *
     * @param t             given array
     * @param SortAlgorithm given sort algorithm
     */
    public ArrSorter(T[] t, int SortAlgorithm) {
        arrOrigin = new Object[t.length];
        for (int i = 0; i < arrOrigin.length; i++) {
            arrOrigin[i] = t[i];
        }

        if (SortAlgorithm == BUBBLE_SORT) {
            arrSorted = BUBBLE_SORT(arrOrigin);
        }
        if (SortAlgorithm == MERGE_SORT) {
            Object[] tmp = new Object[arrOrigin.length];
            for (int i = 0; i < arrOrigin.length; i++) {
                tmp[i] = arrOrigin[i];
            }
            arrSorted = MERGE_SORT(tmp, 0, tmp.length - 1);
        }
        if (SortAlgorithm == QUICK_SORT) {
            Object[] tmp = new Object[arrOrigin.length];
            for (int i = 0; i < arrOrigin.length; i++) {
                tmp[i] = arrOrigin[i];
            }
            arrSorted = QUICK_SORT(tmp, 0, tmp.length - 1);
        }
        if (arrSorted != null) {
            arrReversed = REVERSE_SORT(arrSorted);
        }
    }

    /**
     * a constructor that receives an int[] type of array, casting the array into an Object[] type of array.
     * then calling default constructor with default sort algorithm
     * which is merge_sort.
     *
     * @param t given int[] array.
     */
    public ArrSorter(int[] t) {
        this((T[]) castToObject(t));
    }

    /**
     * a constructor that receives an int[] type of array and sort algorithm number,
     * casting the array into an Object[] type of array.
     * then calling default constructor with entered sort algorithm number.
     *
     * @param t             given int[] array.
     * @param SortAlgorithm given type of sort algorithm.
     */
    public ArrSorter(int[] t, int SortAlgorithm) {
        this((T[]) castToObject(t), SortAlgorithm);
    }

    /**
     * a constructor that receives a double[] type of array, casting the array into an Object[] type of array.
     * then calling default constructor with default sort algorithm
     * which is merge_sort.
     *
     * @param t given double[] array.
     */
    public ArrSorter(double[] t) {
        this((T[]) castToObject(t));
    }

    /**
     * a constructor that receives a double[] type of array and sort algorithm number,
     * casting the array into an Object[] type of array.
     * then calling default constructor with entered sort algorithm number.
     *
     * @param t             given double[] array.
     * @param SortAlgorithm given type of sort algorithm.
     */
    public ArrSorter(double[] t, int SortAlgorithm) {
        this((T[]) castToObject(t), SortAlgorithm);
    }

    /**
     * a constructor that receives a char[] type of array, casting the array into an Object[] type of array.
     * then calling default constructor with default sort algorithm
     * which is merge_sort.
     *
     * @param t given char[] array.
     */
    public ArrSorter(char[] t) {
        this((T[]) castToObject(t));
    }

    /**
     * a constructor that receives a char[] type of array and sort algorithm number,
     * casting the array into an Object[] type of array.
     * then calling default constructor with entered sort algorithm number.
     *
     * @param t             given char[] array.
     * @param SortAlgorithm given type of sort algorithm.
     */
    public ArrSorter(char[] t, int SortAlgorithm) {
        this((T[]) castToObject(t), SortAlgorithm);
    }

    /**
     * A method that uses a sorting algorithm that works in a recursive way
     * this method uses the private method named 'merge()'in order to sort the given array.
     *
     * @param arr  given array
     * @param low  starting index of the array
     * @param high ending index of the array
     * @return sorted array
     */
    private static Object[] MERGE_SORT(Object[] arr, int low, int high) { //1
        if (low < high) {
            int mid = (low + high) / 2;
            MERGE_SORT(arr, low, mid);
            MERGE_SORT(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
        return arr;
    }

    /**
     * A method that uses sorting algorithm that works in a recursive way, the algorithm breaks the given array into halves,
     * then when it cant break it to halves anymore, it compares one element to another and merge them by acceding way.
     * this is the most efficient sorting algorithm.
     * <p>
     * This sort method code was written with the assist of Chat-GPT.
     *
     * @param array given array
     * @param low   starting index of the array
     * @param mid   middle index of the array
     * @param high  ending index of the array
     */
    private static void merge(Object[] array, int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        Object[] leftArray = new Object[leftSize];
        Object[] rightArray = new Object[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[low + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = low;

        while (i < leftSize && j < rightSize) {
            if ((((Comparable) leftArray[i]).compareTo(rightArray[j]) < 0 || ((Comparable) leftArray[i]).compareTo(rightArray[j]) == 0)) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /**
     * A method that uses a sorting algorithm that compare each element of the given array to the rest of the elements it has.
     * the algorithm switch the element's location with the one that's bigger than him (and its index is smaller)
     *
     * @param arrOrigin given array that need to be sorted
     * @return sorted array
     */
    private static Object[] BUBBLE_SORT(Object[] arrOrigin) { //2
        Object[] arr = Arrays.copyOf(arrOrigin, arrOrigin.length);
        for (int i = 1; i <= arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (((Comparable) arr[j]).compareTo(arr[j + 1]) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * A method that uses sorting algorithm in a recursive way.
     * this method uses the private method 'partition' in order to sort and receive the pivot point.
     * in the end of the recursive type of work, we receive a sorted array.
     *
     * @param arr  given array
     * @param low  starting index (usually 0)
     * @param high ending index (usually length-1)
     * @return sorted array
     */
    private static Object[] QUICK_SORT(Object[] arr, int low, int high) { //3
        if (low < high) {
            int index = partition(arr, low, high);
            QUICK_SORT(arr, low, index - 1);
            QUICK_SORT(arr, index + 1, high);
        }
        return arr;
    }

    /**
     * a sorting algorithm chooses the last element of the array as pivot point,
     * sets the pivot element in its right index (by comparing it to the other elements in the array)
     *
     * @param arr  given array
     * @param low  starting index
     * @param high ending index
     * @return sorted array with the pivot in its right index location.
     */
    private static int partition(Object[] arr, int low, int high) {
        int index = low - 1;
        Object pivot = arr[high];
        for (int j = low; j < high; j++) {
            if (((Comparable) arr[j]).compareTo(pivot) < 0 || ((Comparable) arr[j]).compareTo(pivot) == 0) {
                index++;
                Object tmp = arr[index];
                arr[index] = arr[j];
                arr[j] = tmp;
            }
        }
        Object tmp = arr[index + 1];
        arr[index + 1] = arr[high];
        arr[high] = tmp;
        return index + 1;
    }

    /**
     * A method that uses a sorting algorithm based on given sorted array.
     * this method put the element in a reversed way
     *
     * @param arrSorted given sorted element
     * @return reversed sorted element
     */
    final Object[] REVERSE_SORT(Object[] arrSorted) {
        Object[] arr = new Object[arrSorted.length];
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[index] = arrSorted[i];
            index++;
        }
        return arr;
    }

    /**
     * a method that creates an Iterator object by using the original array.
     *
     * @return iterator object based on given array.
     */
    public ArrIterator original() {
        return new ArrIterator(this.arrOrigin);
    }

    /**
     * a method that creates an Iterator object by using the sorted array.
     *
     * @return iterator object based on given array.
     */
    public ArrIterator sorted() {
        return new ArrIterator(this.arrSorted);
    }

    /**
     * a method that creates an Iterator object by using the reversed array.
     *
     * @return iterator object based on given array.
     */
    public ArrIterator reverse() {
        return new ArrIterator(this.arrReversed);
    }

    /**
     * a method that casting an int[] array into an Object[] array.
     * this method's way of work achieved with ChatGPT but writing and creating was done by us.
     *
     * @param array given int[] array
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
     * a method that casting a double[] array into an Object[] array.
     * this method's way of work achieved with ChatGPT but writing and creating was done by us.
     *
     * @param array given double[] array
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
     * a method that casting a char[] array into an Object[] array.
     * this method's way of work achieved with ChatGPT but writing and creating was done by us.
     *
     * @param array given char[] array
     * @return Object[] type of array
     */
    private static Object[] castToObject(char[] array) {
        Object[] objectArray = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            objectArray[i] = array[i];
        }
        return objectArray;
    }
}
