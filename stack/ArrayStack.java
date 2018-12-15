package stack;

import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E>{

	protected int capacity;
	public static final int CAPACITY = 1000;
	protected E S[]; // generic array to implement the stack
	protected int top = -1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	public ArrayStack(int cap) {
		
		capacity = cap;
		S = (E[]) new Object[capacity];
	}
	
	public int size() {
		
		return top+1;
	}
	
	public boolean isEmpty() {
		
		return(top < 0);
	}
	
	public void push(E element) throws FullStackException {
		
		if (size() == capacity)
			throw new FullStackException("Stack is FULL");
		S[++top] = element;
	}
	
	public E top() throws EmptyStackException {
		
		if (isEmpty()) throw new EmptyStackException();
		return S[top];
	}
	
	public E pop() throws EmptyStackException {
		
		if (isEmpty()) throw new EmptyStackException();
		E popped = S[top];
		S[top--] = null;  // GC
		return popped;
	}
	
	public String toString() {
		
		String s = "[";
		if(isEmpty()) return "Empty Stack";
		if(size() > 0) s += S[0];
		if(size() > 1)
			for(int i=1; i<=size()-1; i++) {
				s += " , "+S[i];
			}
		return s+"]";
	}

	public void status(String op, Object element) {
		
		 System.out.print("-----> "+op);
		 System.out.println(", returns "+element);
		 System.out.print(", isEmpty? : "+isEmpty());
		 System.out.println(" "+size()+"\t"+this); // contents of stack
	}
	
	// returns sum of all elements in stack
	public int getSum() {
		
		int sum = 0;
		for(int i=0; i<size(); i++) {
			
			sum = sum + (Integer) S[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		
		Object o; 
		ArrayStack<Integer> A = new ArrayStack<Integer>();   
		A.status("new ArrayStack<Integer> A", null);   
		try {
			A.push(15);
			A.status("A.push(15)", null); 
			A.push(20);
			A.status("A.push(20)", null);
			A.push(5);
			A.status("A.push(5)", null); 
			o = A.pop();   
			A.status("A.pop()", o);  
			A.push(17);   
			A.status("A.push(17)", null);
			A.push(12);   
			A.status("A.push(12)", null);
			o = A.pop(); 
			A.status("A.pop()", o);
			A.push(7);   
			A.status("A.push(7)", null);
			A.push(13);   
			A.status("A.push(13)", null);
			A.push(2);   
			A.status("A.push(2)", null);
			System.out.println("\nSum of all elements in Stack is : "+A.getSum());
		}
		catch (FullStackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
}
