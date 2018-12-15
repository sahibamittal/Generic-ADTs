package queue;

public class ArrayQueue<E> implements Queue<E> {

	protected int N; // size of array
	public static final int CAPACITY = 1000;
	protected E Q[]; // array of objects of type E
	protected int front, rear;
	
	// constructors
	
	public ArrayQueue() {
		
		this(CAPACITY);
	}
	
	public ArrayQueue(int cap) {
		
		N = cap;
		front = 0; rear = 0;
		Q = (E[]) new Object[N];
	}

	@Override
	public int size() {
		
		return (N-front+rear) % N;
	}

	@Override
	public boolean isEmpty() {
		
		return front == rear;
	}

	@Override
	public E front() throws EmptyQueueException {
		
		if(isEmpty()) throw new EmptyQueueException("Queue is EMPTY!");
		return Q[front];
	}

	@Override
	public void enqueue(E element) throws FullQueueException {
		
		if(size() == N-1) throw new FullQueueException("Queue is FULL!");
		Q[rear] = element;
		rear = (rear+1) % N; // to maintain circular queue logically
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		
		if(isEmpty()) throw new EmptyQueueException("Queue is EMPTY!");
		E dequeued = Q[front];
		Q[front] = null;
		front = (front+1) % N; // to maintain circular queue logically
		return dequeued;
	}

	
}
