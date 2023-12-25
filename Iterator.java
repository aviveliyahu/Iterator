import java.util.NoSuchElementException;

public interface Iterator<T> {
    public boolean hasNext();
    public T next() throws NoSuchElementException;
    public int indexOf(T element);
}