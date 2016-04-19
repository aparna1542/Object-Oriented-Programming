package Algo.DS;

public interface Stack {

	public abstract boolean isEmpty();

	/**
	 * create temp ref to existing node first node
	 * create a new node
	 * push item to the first node
	 * connect both the nodes ie create reference
	 * @param item
	 */
	public abstract void push(String item);

	public abstract String pop();

}