public class DoublyLinkedList <T> implements Iterable <T>{
	private int size = 0;
	private Node <T> head = null;
	private Node <T> tail = null;

	// Internal node class to represent data
	private class Node <T>{
		T data;
		Node <T> prev, next;
		public Node(T data, Node <T> prev, Node <T> next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		@Override public String toString(){
			return data.toString();
		}
	}

	// Empty this linked lists, O(n)
	public void clear(){
		Node <T> trav = head;
		while (trav != null){
			Node <T> next = trav.next;
			trav.prev = null;
			trav.next = null;
			trav.data = null;
			trav = next;
		}
		head = tail = trav = null;
		size = 0;
	}

	// Return size of list
	public int size(){
		return size;
	}

	// Is linked list empty
	public isEmpty(){
		return size() == 0;
	}

	// Add element to the tail of linked list
	public void add(T elem){
		addLast(elem);
	}

	// Add an element to the head of linked list
	public void addFirst(T elem){
		// The linkedlis is Empty
		if(isEmpty){
			head = tail = new Node <T> (elem, null, null);
		}
		else{
			head.prev = new Node <T> (elem, null, next);
			head = head.prev;
		}
		size ++;
	}

	// Add a node to last
	public void addLast(T elem){
		if (isEmpty) head = tail = new Node <T> (elem, null, null);
		else{
			tail.next = new Node <T> (elem, tail, null);
			tail = tail.next;
		}
		size++;
	}

	// Check that value of first node if it exists, O(1)
	public T peekFirst(){
		if(!isEmpty) return head.data;
		throw new RuntimeException ("Empty list");
	}

	// Check the value of the last node if it exist, O(1)
	public T peekLast(){
		if(!isEmpty) return tail.data;
		throw new RuntimeException("Empty list");
	}

	// Remove first value of linked list, O(1)
	public T removeFirst(){
		if(isEmpty()) throw new RuntimeException ("Empty list");
		

		T data = head.data;
		head = head.next;
		-- size;

		// edge caese: after remove list is empty
		if (isEmpty()) tail = null;
		else head.prev = null;
		return data;
	}

	public T removeLast(){
		if (isEmpty) throw new RuntimeException ("Empty list");
		T data = tail.data;
		tail = tail.prev;
		--size;
		if (isEmpty) head = null;
		else tail.next = null;
		return data;

	}

	public T remove(Node <T> node){ // O(1)
		// If the node to remove is somewhere either at the head or tail
		if (node.prev == null) return removeFirst();
		if (node.next == null) return removeLast();

		// resetup links between front and back of node
		node.next.prev = node.prev;
		node.prev.next = node.next;

		T data = node.data;

		// clean up data
		node.data = null;
		node = node.prev = node.next = null
		--size;

		return data;
	}

	public T removeAt(int index){ // O(n)
		//out of scope
		if (index >= len || index < 0) throw new IllegalArgumentException();

		int i;
		Node <T> trav;

		// Divide the list to two search
		if (index < size/2){
			for (i = 0; trav = head; i != index; i++){
				trav = trav.next;
			}
		}else{
			for (i = size-1; trav = tail; i != index; i--){
				trav = trav.prev;
			}
		}
		return remove(trav);
	}

	public boolean remove(Object obj){
		Node <T> trav = head;

		// support searching for null object
		if (obj == null){
			for (trav = head; trav != null; trav = trav.next){
				if(trav.data == null){
					remove(trav); // 
				}
			}
		}else{
			for (trav = head; trav != null; trav = trav.next){
				if (obj.equals(trav.data)){
					remove(trav);
					return true;
				}
			}
		}
		return false
	}


	
}










