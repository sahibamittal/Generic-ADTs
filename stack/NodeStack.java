package stack;

import java.util.EmptyStackException;

public class NodeStack<E> implements Stack<E> {
	
	public class Node<E>{
		
		private E element;
		private Node<E> next;
		
		public Node() {
			
			this(null,null);
		}
		
		public Node(E ele, Node<E> nextNode) {
			
			element = ele;
			next = nextNode;
		}
		
		// Accessors
		public E getElement() { return element; }
		public Node<E> getNext(){ return next; }
		
		// modifiers
		public void setElement(E e) { element = e; }
		public void setNext(Node<E> n) { next = n; }
		
	}
	
	protected Node<E> top;
	protected int size;
	
	public NodeStack() {
		
		top = null; size = 0;
	}
	
	public int size() { return size; }
	
	public boolean isEmpty( ) { return top == null; }
	
	public void push(E elem) {
		
		Node<E> newNode = new Node<E>(elem,top);
		top = newNode; size++;
	}
	
	public E top() throws EmptyStackException {
		
		if(isEmpty()) throw new EmptyStackException();
		return top.getElement();
	}
	
	public E pop() throws EmptyStackException {
		
		if(isEmpty()) throw new EmptyStackException();
		E popped = top.getElement();
		top = top.getNext();
		size--;
		return popped;
	}

}
