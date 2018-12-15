// Deque implementation using Doubly Linked List 

package deque;

public class NodeDeque<E> implements Deque<E> {

	// inner class for doubly linked list nodes
	public class DLNode<E> {
		
		private E element;
		private DLNode<E> prev;
		private DLNode<E> next;
		
		public DLNode() {
			
			this(null, null, null);
		}

		public DLNode(E e, DLNode<E> p, DLNode<E> n) {

			element = e;
			prev = p;
			next = n;
		}
		
		// getters setters
		
		public E getElement() { return element; }
		public DLNode<E> getPrevious() { return prev; }
		public DLNode<E> getNext() { return next; }
		
		public void setElement(E e) { element = e; }
		public void setPrevious(DLNode<E> p) { prev = p; }
		public void setNext(DLNode<E> n) { next = n; }
		
	}
	
	
	// ****Deque fields and operations*****
	
	protected DLNode<E> header, trailer;
	protected int size;
	
	// default constructor for empty deque
	public NodeDeque() {
		
		// here header and trailer don't hold values just the references to previous and next nodes
		header = new DLNode<E>();
		trailer = new DLNode<E>();
		size= 0;
	}
	
	public int size() { return size; }
		
	public boolean isEmpty() { return size==0; }

	public void addFirst(E element) {
		
		DLNode<E> newFirst;
		if(isEmpty()) {
			
			newFirst = new DLNode(element,header,trailer);
			trailer.setPrevious(newFirst);
		}
		else {
			
			DLNode<E> first = header.getNext(); 
			newFirst = new DLNode(element,header,first);
			first.setPrevious(newFirst);
		}
		header.setNext(newFirst);
		size++;
	}

	public E getFirst() throws EmptyDequeException {
		
		if(isEmpty()) throw new EmptyDequeException("Deque is EMPTY!");
		return header.getNext().getElement();
 	}

	public E removeFirst() throws EmptyDequeException {

		if(isEmpty()) throw new EmptyDequeException("Deque is EMPTY!");
		DLNode<E> first = header.getNext();
		DLNode<E> secondFirst = first.getNext();
		E removed = first.getElement();
		header.setNext(secondFirst);
		secondFirst.setPrevious(header);
		size--;
		return removed;
	}

	public void addLast(E element) {

		DLNode<E> newLast;
		if(isEmpty()) {
			
			newLast = new DLNode<E>(element,header,trailer);
			header.setNext(newLast);
		}
		else {
			
			DLNode<E> last = trailer.getPrevious();
			newLast = new DLNode<E>(element,last,trailer);
			last.setNext(newLast);
		}
 		
		trailer.setPrevious(newLast);
		size++;
	}

	public E getLast() throws EmptyDequeException {

		if(isEmpty()) throw new EmptyDequeException("Deque is EMPTY!");
		return trailer.getPrevious().getElement();
	}

	public E removeLast() throws EmptyDequeException {
		
		if(isEmpty()) throw new EmptyDequeException("Deque is EMPTY!");
		DLNode<E> last = trailer.getPrevious();
		DLNode<E> secondLast = last.getPrevious();
		E removed = last.getElement();
		secondLast.setNext(trailer);
		trailer.setPrevious(secondLast);
		size--;
		return removed;
 	}
	
	public String toString() {
		
		String output = "";
		DLNode<E> point = header;
		if(point.getNext() == null) return null;
		while(point.getNext()!=trailer) {
			
			output += point.getNext().getElement()+", ";
			point = point.getNext();
		}
		return output;
	}

	// tester
	
	public static void main(String[] args) {
		
		NodeDeque<Integer> D = new NodeDeque<Integer>();
		D.addFirst(5);
		D.addLast(50);
		System.out.println(D);
		System.out.println(D.size());
	}
}
