package queue.from.stack;

import user.created.dynamic_stack.Dynamic_Stack;

public class Queue_DeQueue_Efficient {
	
	private Dynamic_Stack ds = new Dynamic_Stack();
	
	public void enQueue(int item) throws Exception
	{
		Dynamic_Stack hlp = new Dynamic_Stack();
		while(!ds.isEmpty())
		{
			hlp.push(ds.pop());
		}
		
		hlp.push(item);
		
		while(!hlp.isEmpty())
		{
			ds.push(hlp.pop());
		}
	}
	
	public boolean isFull()
	{
		return ds.isFull();
	}
	
	public boolean isEmpty()
	{
		return ds.isEmpty();
	}
	
	public int getFront() throws Exception
	{
		return ds.peek();
	}
	
	public int deQueue() throws Exception
	{
		return ds.pop();
	}
	
	public void display()
	{
		ds.display();
	}
	
	public static void main(String[] args) throws Exception {
		Queue_DeQueue_Efficient qdf = new Queue_DeQueue_Efficient();
		
		qdf.enQueue(10);
		qdf.enQueue(20);
		System.out.println();
		System.out.println(qdf.getFront());
		qdf.enQueue(30);
		qdf.enQueue(40);
		qdf.enQueue(50);
		System.out.println(qdf.deQueue());
		System.out.println(qdf.deQueue());
		System.out.println();
		
		System.out.println(qdf.getFront());
		qdf.enQueue(60);
		qdf.enQueue(70);
		System.out.println(qdf.deQueue());
		System.out.println(qdf.getFront());
		
		qdf.display();
		System.out.println(qdf.deQueue());
		System.out.println(qdf.getFront());
		
		qdf.display();
	}
}
