package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;
	LLNode<E> pointer;
	
	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		pointer = new LLNode<E>();
	}
	

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		// Create a new node 
		if ( element == null ) throw new NullPointerException("Data is null");
		
		LLNode<E> newNode = new LLNode<E>(element);

		// Append to the Linked List
		
		newNode.next = tail;
		newNode.prev = newNode.next.prev;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		// update the size list
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		
	
		if (size == 0 && index == 0) throw new IndexOutOfBoundsException("Out of Boundries");
		if (index == -1) throw new IndexOutOfBoundsException("Out of Boundries");
		if (index > size -1 ) throw new IndexOutOfBoundsException("Out of Boundries");
		
		pointer = head.next;
		int i = 0;
		while (i < index) {
			pointer = pointer.next;
			i++;
		}
		
		return pointer.data;
	}

	
	
	
	
	
	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		
		if ( element == null ) throw new NullPointerException("Data is null");
//		if (size == 0) throw new IndexOutOfBoundsException("Out of Boundries");
		if (index < 0) throw new IndexOutOfBoundsException("Out of Boundries");
		if (index > size) throw new IndexOutOfBoundsException("Out of Boundries");
		
		// set the Pointer, find inex and postinon in the linked list
		pointer = head.next;  
		int i = 0;
		while (i < index) {
			pointer = pointer.next;
			i++;
		}

		// Create a new node object for new element
		LLNode<E> newNode = new LLNode<E>(element);

		// Append to the Linked List
		
		newNode.next = pointer;
		newNode.prev = newNode.next.prev;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		// update the size list
		size++;
		
		// TODO: Implement this method
	}


	
	
	
	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		
		if (index < 0) throw new IndexOutOfBoundsException("Out of Boundries");
		if (index > size) throw new IndexOutOfBoundsException("Out of Boundries");
		if (size == 0) throw new IndexOutOfBoundsException("Out of Boundries");
		
		// Move the pointer to the index on the list
		pointer = head.next;  
		int i = 0;
		while (i < index) {
			pointer = pointer.next;
			i++;
		}
		
		
		pointer.next.prev = pointer.prev;
		pointer.prev.next = pointer.next;
		
		size--;
		
		return pointer.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method

		if (index < 0) throw new IndexOutOfBoundsException("Out of Boundries");
		if (index > size) throw new IndexOutOfBoundsException("Out of Boundries");
		if (size == 0) throw new IndexOutOfBoundsException("Out of Boundries");
		if ( element == null ) throw new NullPointerException("Data is null");
		
		// Move the pointer to the index on the list
		pointer = head.next;  
		int i = 0;
		while (i < index) {
			pointer = pointer.next;
			i++;
		}
		
		E data = pointer.data; // we need to return this 
		pointer.data = element; // Set the new data on the node
		return data;
		
	}   
}

//Node Class 
class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode() {
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
