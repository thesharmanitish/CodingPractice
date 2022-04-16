package com.interview.google.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * 
 * The Least Recently Used (LRU) cache is a cache eviction algorithm that
 * organizes elements in order of use. In LRU, as the name suggests, the element
 * that hasn't been used for the longest time will be evicted from the cache.
 * 
 * https://www.baeldung.com/wp-content/uploads/2021/07/Screenshot-from-2021-07-03-14-30-34-1.png
 * 
 * 
 * 
 * All operations should run in order of O(1) 
 * The cache has a limited size 
 * It's mandatory that all cache operations support concurrency
 * If the cache is full, adding a new item must invoke the LRU strategy
 * 
 * In practice, LRU cache is a kind of Queue — if an element is reaccessed, it
 * goes to the end of the eviction order 
 * 
 * This queue will have a specific capacity as the cache has a limited size. Whenever a new element is brought
 * in, it is added at the head of the queue. When eviction happens, it happens
 * from the tail of the queue. 
 * 
 * Hitting data in the cache must be done in constant time, which isn't possible in Queue! But, it is possible 
 * with Java's HashMap data structure 
 * 
 * Removal of the least recently used element must be
 * done in constant time, which means for the implementation of Queue, we'll use
 * DoublyLinkedList instead of SingleLinkedList or an array
 * 
 * 
 * 
 *  Algo :
 * 
 * If the key is present in HashMap, it's a cache hit; else, it's a cache miss.
 * 
 * We'll follow two steps after a cache miss occurs:
 * 
 * Add a new element in front of the list. 
 * Add a new entry in HashMap and refer to the head of the list.
 * 
 * And, we'll do two steps after a cache hit:
 * 
 * Remove the hit element and add it in front of the list. Update HashMap with a
 * new reference to the front of the list.
 * 
 * 
 * https://www.baeldung.com/java-lru-cache
 * 
 * 
 * 
 * @author nisharma
 *
 */

interface Cache<K,V>{
	int size();
	boolean put(K k , V v);
	boolean get(K k);
	boolean isEmpty();
	boolean clear();	
}

class CacheElement<K,V>{
	K k;
	V v;
	
	public CacheElement(K k, V v) {
		super();
		this.k = k;
		this.v = v;
	}
	public K getK() {
		return k;
	}
	public void setK(K k) {
		this.k = k;
	}
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}
	
}

class LinkedListNode<K>{
	
	K k;
	
	LinkedListNode prev, next;

	public LinkedListNode(K k) {
		super();
		this.k = k;
		this.prev = null;
		this.next = null;
	}
	public LinkedListNode  updateAndMoveToFront(LinkedListNode<K> node, CacheElement v){
		
		
		
		return node;
		
	}
	
 }
class DoublyLinkedList<K> extends LinkedList<K>{
	K k;
	K start;
	K end;
	
}
public class LRUCache<K,V> implements Cache<K,V>{
	private int size;
	Map<K,LinkedListNode<CacheElement<K,V>>> cacheMap;
	LinkedList<CacheElement<K,V>> cacheQueue;
	
	
	public LRUCache(int size) {
		this.size = size;
		this.cacheMap = new ConcurrentHashMap<>(size);
		this.cacheQueue = new LinkedList<>();  // need to implement Doubly Linked List
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean put(K k, V v) {
		CacheElement<K, V> item = new CacheElement<K, V>(k, v);
		LinkedListNode<CacheElement<K, V>> newNode;
		if (this.cacheMap.containsKey(k)) {
			LinkedListNode<CacheElement<K,V>> node =  cacheMap.get(k);
			newNode = this.updateAndMoveToFront(cacheQueue, node, item);

			
		}else {
			if(this.size <= cacheQueue.size()) {
				this.evictElement();
			}
			this.cacheQueue.add(item);
		}
		
		
		return false;
	}

	private void evictElement() {
		// TODO Auto-generated method stub
		
	}

	private LinkedListNode<CacheElement<K, V>> updateAndMoveToFront(LinkedList<CacheElement<K, V>> cacheQueue2,
			LinkedListNode<CacheElement<K, V>> node, CacheElement<K, V> item) {
		
		
		//TODO
		return null;
	}

	@Override
	public boolean get(Object k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clear() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
