/*
 *  Josephus Problem
 *  Solution using circular array-based Queue
 */

package queue;

public class Josephus {

	// building Queue from an array of objects
	public static <E> Queue<E> buildQueue(E a[]) throws FullQueueException{
		
		Queue<E> Q = new ArrayQueue<E>();
		for(int i=0; i<a.length; i++) {
			
			Q.enqueue(a[i]);
		}
		return Q;
	}
	
	// solution of Josephus problem
	public static <E> E JosephusSolution(Queue<E> Q, int k) throws FullQueueException, EmptyQueueException {
		
		if (Q.isEmpty()) return null;
		while(Q.size()>1) {
			
			System.out.println("Queue : "+Q+", k : "+k);
			for(int i=0; i<k; i++)
				Q.enqueue(Q.dequeue());
			E e = Q.dequeue();
			System.out.println(", "+e+" is out.");
		}
		return Q.dequeue(); // winner
	}
	
	public static void main(String[] args) throws FullQueueException, EmptyQueueException {
		
		// tester
		String[] a1 = {"A","B","C","D","E","F","G"};		
		System.out.println("And the Winner is "+JosephusSolution(buildQueue(a1),5));
	}

}
