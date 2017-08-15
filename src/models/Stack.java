package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Stack implementation using the Agenda interface
 * 
 * @author Oleksandr Kononov
 * @version 10-08-2017
 * @param <T>
 */
public class Stack<T> implements Agenda<T> {

	List<T> list;
	
	public Stack(){
		list = new ArrayList<T>();
	}
	
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public void add(T t) {
		list.add(t);
	}

	@Override
	public T remove() {
		if(isEmpty()) return null;
		T obj = list.get(size()-1);
		list.remove(size()-1);
		return obj;
	}

	@Override
	public T peek() {
		if(isEmpty()) return null;
		return list.get(size()-1);
	}

}
