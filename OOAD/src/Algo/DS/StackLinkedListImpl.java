package Algo.DS;

public class StackLinkedListImpl implements Stack {

	//maintain head reference throughout since its LinkedList Implementation
	private Node head=null;

	

	
	@Override
	public boolean isEmpty()
	{
		return head==null;
	}


	@Override
	public void push(String data) {

		Node n=head;
		head=new Node(data,head);
		head.next=n;
		System.out.println("pushed element:" + data);

	}

	
	@Override
	public String pop(){

		if(isEmpty()) {
			System.out.println("Attempt to pop empty Stack");
			return null;
		}
		String	data=head.data;
		head=head.next;
		System.out.println("popped element:" + data);
		printStack();
		return data;

	}
	
	
	public void printStack()
	{
		Node temp=head;
		if(isEmpty()) {
			System.out.println("Empty Stack");
			return;
		}
		System.out.println("The stack elements are ");
		while (temp !=null) {
			String data=temp.data;
			System.out.print("\t" + data);
			temp=temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Stack s = new StackLinkedListImpl();
		s.push("30");
		s.push("40");
		s.push("hhh");
		s.push("jjj");
		s.push("kkk");
		s.pop();
		}

}
