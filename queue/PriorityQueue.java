// we'll implement it using sorted List
package queue;

public interface PriorityQueue<K, V> {

	public int size();
	public boolean isEmpty();
	public void insert(K key, V value);
	public V min();
	public V remove();
}
