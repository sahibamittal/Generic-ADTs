package stack;

import java.util.EmptyStackException;

public interface Stack<E> {

	public int size();
	public boolean isEmpty();
	public E top() throws EmptyStackException;
	public void push(E element) throws FullStackException;
	public E pop() throws EmptyStackException;
}
