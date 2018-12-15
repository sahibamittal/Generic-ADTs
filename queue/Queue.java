package queue;

public interface Queue<E> {

	public int size();
	public boolean isEmpty();
	
	public E front() throws EmptyQueueException;
	
	public void enqueue(E element) throws FullQueueException;
	
	public E dequeue() throws EmptyQueueException;
	
}
