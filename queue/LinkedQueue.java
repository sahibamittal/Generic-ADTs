package queue;

public class LinkedQueue<E> implements Queue<E> {

		// inner class - Node
	public class Node<E> {
			
		private E element;
		private Node<E> next;
			
		public Node() {
				
			this(null, null);
		}
			
		public Node(E e, Node<E> n) {
				
			element = e;
			next = n;
		}
		
		// accessors
		public E getElement() { return element; }
		public Node<E> getNext(){ return next; }
		
		// modifiers
		public void setElement(E e) { element = e; }
		public void setNext(Node<E> n) { next = n; }
	}
	
	protected int size;
	protected Node<E> front;
	protected Node<E> rear;
	
	// constructor
	public LinkedQueue() {
		
		size = 0;
		front = null; rear= null;
	}
	
	public int size() { return size; }
	
	public boolean isEmpty() { return size == 0; }
	
	public E front() throws EmptyQueueException {
		
		if (isEmpty()) throw new EmptyQueueException("Queue is Empty!");
		return front.getElement();
	}
	
	public void enqueue(E ele) {
		
		Node<E> newNode = new Node<E>(ele,rear);
		if (rear == null) front = newNode;
		else rear.next = newNode;
		rear = newNode;
		size += 1;
	}
	
	public E dequeue() throws EmptyQueueException {
		
		if (isEmpty()) throw new EmptyQueueException("Queue is Empty!");
		E dequeued = front.getElement();
		front = front.getNext();
		size -= 1;
		if (front == null) rear = null;
		return dequeued;
	}

}
