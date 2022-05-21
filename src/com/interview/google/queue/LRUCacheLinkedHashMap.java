package com.interview.google.queue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHashMap {

	LinkedHashMap<Integer, Integer> map;

	public LRUCacheLinkedHashMap(int capacity) {
		map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > capacity;
			}
		};
	}

	public int get(int key) {
		return map.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		map.put(key, value);
	}

}

class Node {
	int key;
	int value;
	Node next;
	Node prev;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

class LRUCache1 {
	Node head, tail;
	int size, capacity;
	Map<Integer, Node> map;

	public LRUCache1(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
	}

	public void remove(Node root) {
		if (head == null)
			return;
		else if (root.next == root.prev) {
			head = null;
			tail = null;

		} else if (root.next == null) {
			tail = root.prev;
			tail.next = null;
			root.prev = null;
		} else if (root.prev == null) {
			head = head.next;
			head.prev = null;
			root.next = null;
		} else {
			Node tmp = root.prev;
			tmp.next = root.next;
			root.next.prev = tmp;
			root.prev = null;
			root.next = null;
		}
		size--;
	}

	public void addToFront(Node temp) {
		if (head == null) {
			head = temp;
			tail = head;
		} else {

			temp.next = head;
			head.prev = temp;
			head = temp;
		}

		size++;
	}

	public int get(int key) {
		Node temp = map.get(key);
		if (temp == null)
			return -1;

		remove(temp);
		addToFront(temp);
		map.put(key, head);
		return temp.value;
	}

	public void put(int key, int value) {
		Node tmp = map.get(key);

		if (tmp != null) {
			remove(tmp);
		} else if (size == capacity) {
			map.remove(tail.key);
			remove(tail);

		}
		addToFront(new Node(key, value));
		map.put(key, head);

	}
}
