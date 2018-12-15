package deque;

public interface Deque<E> {

	public int size();
	
	public boolean isEmpty();
	
	// front methods
	public void addFirst(E element);
	public E getFirst() throws EmptyDequeException;
	public E removeFirst() throws EmptyDequeException;
	
	// rear methods
	public void addLast(E element);
	public E getLast() throws EmptyDequeException;
	public E removeLast() throws EmptyDequeException;
}
