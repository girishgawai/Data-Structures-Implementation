package user.created.ds;

import java.util.Iterator;

public class Stack {

	protected int[] arr;
	private int top;
	
	public Stack()
	{
		arr = new int[5];
		top=-1;
	}

	public Stack(int size) {
		this.arr = new int[size];
		this.top = -1;
	}
	
	public void push(int item) throws Exception
	{
		if(isFull()==true)
			throw new Exception("Stack is Full");
		
		top++;
		arr[top]=item;
	}
	
	public int pop() throws Exception
	{
		if(isEmpty())
			throw new Exception("No Data Present in Stack to POP");
		
		int val = arr[top];		// data udya top ka
		top--;					// then top ko ek se piche krege.. jha pe data phle wala avalaible hai.. next data push krte time top bdhega
		return val;
	}

	public boolean isFull() {
		// TODO Auto-generated method stub
		return top==arr.length-1;
	}
	
	public int peek() throws Exception
	{
		if(isEmpty())
			throw new Exception("Stack is Empty");
		return arr[top];
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
//		if(top==-1)
//			return true;
		return top==-1;
	}
	
	public int size()
	{
		return top+1;
	}
	
	public void display()
	{
		for (int i = 0; i <= top; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

}
