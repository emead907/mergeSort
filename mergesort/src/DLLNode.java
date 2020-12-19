
public class DLLNode<T> {
	
	private DLLNode<T> next;
	private DLLNode<T> previous;
	private T element;
	
	/**
	 * Creates an empty node
	 */
	public DLLNode() 
	{
		next = null;
		previous = null;
		element = null;
	}
	
	/**
	 * Creates a node that stores the given element
	 * @param elem - the element that needs to be stored 
	 */ 
	public DLLNode(T elem)
	{
		next = null;
		element = elem;
	}
	
	/**
	 * Returns the node next node 
	 * @return the node that is stored in next
	 */
	public DLLNode<T>  getNext()
	{
		return next;
	}
	
	/**
	 * Sets the next node to the given node 'node'
	 * @param node - the node that will be set to next
	 */
	public void setNext(DLLNode<T> node)
	{
		next = node;
	}
	
	/**
	 * Returns the element stored in the node
	 * @return the element stored in the node
	 */
	public T getElement()
	{
		return element;
	}
	
	/**
	 * Sets the current nodes element to the element given 'elem'
	 * @param elem - the element that will be set as the element for the current node
	 */
	public void setElement(T elem)
	{
		element = elem;
	}
	
	/**
	 * Returns the node previous to the current node
	 * @return the previous node (the node stored in previous)
	 */
	public DLLNode<T> getPrevious()
	{
		return previous;
	}
	
	/**
	 * Sets the previous node to the given node 'ode'
	 * @param node - the node that will be set as the previous node
	 */
	public void setPrevious(DLLNode<T> node)
	{
		previous = node;
	}
	
	public String toString()
	{
		return "Element: " + element.toString() + " Has next: " + (next != null) + " Has previous: " + (previous != null);
	}
}