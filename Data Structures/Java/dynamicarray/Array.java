// A warining by which the compiler indicates that it cannot ensure type safety
@SuppressWarning("unchecked")
public class Array <T> implements Iterable <T>{
	private T [] arr; // internal array
	private int len = 0; // length user think array is
	private int capacity = 0; // Acual array size

	public Array() {this(16);}

	public Array(int capacity){
		if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		this.capacity = capacityl
		arr = (T[]) new Object[capacity]; // initialize our array and pass type T
	}

	public int size() {return len; }
	public boolean isEmpty() {return size() == 0;}

	public T get(int index) {return arr[index];}
	public T set(int index, T elem) {arr[index] = elem; }

	public void clear(){
		for (int i =0; i < capacity; i++){
			arr[i] = null;
		}
		len = 0;
	}

	public void add(T elem){
		// Need to resize
		if (len + 1  >= capacity){
			if (capacity == 0) capacity = 1;
			else capacity *=2; // double size
			T[] new_arr = (T[]) new Object[capacity];
			for (int i = 0; i < len; i++){
				new_arr[i] = arr[i]; // arr has extra nulls padded
			}
			arr = new_arr;
		}

		arr[len++] = elem;
	}

	// Removes element at specific index, return the data that we just removed
	public T removeAt(int rm_index){
		if (rm_index >= len && rm_index < 0) throw new IndexOutOfBoundsException();
		T data = arr[rm_index];
		T[] new_arr = (T[]) new Object[len-1];
		for (int i = 0; j = 0; i < len; i++; j++){
			if (i == rm_index) j--; // skipping over rm_index by fixing j temporary
			else new_arr[j] = arr[i];
		}
		arr = new_arr;
		capacity = --len; // reset capacity
		return data;
	}

	public boolean remove(Object obj){
		for (int i = 0; i < len; i++){
			if (arr[i] == obj){
				removeAt(i);
				return true;
			}
		}
		return false;
	}

	public int indexOf(Object obj){
		for (int i = 0; i < len; i++){
			if (arr[i] == obj){
				return i;
			}
		return -1;
		}
	}

	public boolean contains(Object obj){
		return indexOf(obj) != -1;
	}

	// Iterator is still fast but not as fast as iterative for loop
	@Override public java.util.Iterator <T> iterator(){
		return new java.util.Iterator <T> (){
			int index = 0;
			public boolean hasNext(){
				return index < len;
			}
			public T next() {
				return arr[index++];
			}
		};
	}


	Override public String toString(){
		if (len == 0) return "[]";
		else{
			StringBuilder sb = new StringBuilder(len).append("[");
			for (int i = 0; i < len-1; i++)
				sb.append(arr[i] + ", ");
			return sb.append(arr[len-1] + "]").toString();
		}
	}
}	
