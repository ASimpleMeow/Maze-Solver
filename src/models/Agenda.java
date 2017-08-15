package models;

/**
 * Interface for agenda used in solving mazes.
 * The implementation for agenda will be in the form of 
 * Stack and Queue.
 * 
 * @author Oleksandr Kononov
 * @version 10-08-2017
 *
 * @param <T>
 */

public interface Agenda<T> {
	
	/**
	 * Checks if the agenda is empty
	 * @return Boolean
	 */
	public boolean isEmpty();
	
	/**
	 * Return the size of the agenda
	 * @return Integer
	 */
	public int size();
	
	/**
	 * Adds object to the agenda
	 * @param t
	 */
	public void add(T t);
	
	/**
	 * Removes the object from the agenda
	 * @return Element T
	 */
	public T remove();
	
	/**
	 * Peeks at the an object from the agenda without Removing it
	 * @return Element T
	 */
	public T peek();
}
