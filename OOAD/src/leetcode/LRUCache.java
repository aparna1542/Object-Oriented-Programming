/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;



/**
 * @author Aparna Ganesh
 * Program to implement LRU cache,which has get(key) and set(key,value) operations
 * Node: when ever we access a node,remove from last , and add it in head
 */
public class LRUCache {

	Node<Integer> head;
	Node<Integer> tail;
	HashMap<Integer,Node<Integer>> hmap = new HashMap<>();
	int capacity;

public LRUCache(int capacity) {
	this.capacity = capacity;
}

	//this method returns the key ,ie page from cache
	public int get(int key) {
		if(hmap.containsKey(key)) {
			Node<Integer> node = hmap.get(key);
			remove(node);
			setHead(node);
			return node.data;
		}
		return -1;
	}
	
	//update val of exisiting key or create a new one
	public void setKey(int key,int data) {
		//first check if the key is there then we need to update
		if(hmap.containsKey(key)){
			Node<Integer> node = hmap.get(key);
			node.data = data;
			remove(node);
			setHead(node);
		}
		else {
			Node<Integer> created = new Node<Integer>(key,data);
			//check if hash map is full
			if(hmap.size() >= capacity) {
				hmap.remove(tail.key);
				remove(tail);
				setHead(created);
			}
			else { //just set the new node as head
				setHead(created);
			}
		hmap.put(key,created);	//add the new node in hash map also
			
		}
		
	}
	
	//method to remove the accessed node from last
	public void remove(Node<Integer> node) {
		if(node.prev !=null) {
			node.prev.next = node.next;
		}
		else {
			head = node.next;
		}
		
		if(node.next !=null) {
			node.next.prev = node.prev;
		}
		else {
			tail = node.prev;
		}
	}
	//method to add the node to head,no need to create a new node here
	public void setHead(Node<Integer> node) {
		node.prev = null;
		node.next = head;
		if(head !=null) {
			head.prev = node;
		}
		head = node;
		if(tail == null) {
			tail = head;
		}
	}
	
	public void printCache() {
		Node<Integer> tmp = head; // assigning to tmp coz cant move the head
		while (tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next; // /making tmp point to next ele
		}
	}
	public static void main(String args[]) {
		LRUCache cache = new LRUCache(5);
		cache.setKey(1, 100);
		cache.setKey(2, 200);
		cache.setKey(3, 300);
		cache.setKey(4, 400);
		System.out.println("accessed key is "+cache.get(3));
		cache.printCache();
		
	}
}
