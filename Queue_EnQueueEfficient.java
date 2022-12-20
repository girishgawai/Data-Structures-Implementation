package queue.from.stack;

import user.created.dynamic_stack.Dynamic_Stack;

public class Queue_EnQueueEfficient {
	
	private Dynamic_Stack ds = new Dynamic_Stack();
	
	public void enQueue(int item) throws Exception
	{
		ds.push(item);
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
		Dynamic_Stack hlp = new Dynamic_Stack();
		while(!ds.isEmpty())
		{
			hlp.push(ds.pop());
		}
		
		int item = hlp.pop();
		ds.push(item);
		
		while(!hlp.isEmpty())
		{
			ds.push(hlp.pop());
		}
		
		return item;
	}
	
	public int deQueue() throws Exception
	{
		Dynamic_Stack hlp = new Dynamic_Stack();
		while(ds.size()>1)
		{
			hlp.push(ds.pop());
		}
		
		int item = ds.pop();
		
		while(!hlp.isEmpty())
		{
			ds.push(hlp.pop());
		}
		return item;
	}
	
	public void display()
	{
		ds.display();
	}
	
	public static void main(String[] args) throws Exception {
		Queue_EnQueueEfficient qdf = new Queue_EnQueueEfficient();
		
		qdf.enQueue(10);
		qdf.enQueue(20);
		qdf.enQueue(30);
		qdf.enQueue(40);
		qdf.enQueue(50);
		System.out.println(qdf.deQueue());
		System.out.println(qdf.deQueue());
		System.out.println(qdf.getFront());
		qdf.enQueue(60);
		qdf.enQueue(70);
		System.out.println(qdf.deQueue());
		System.out.println(qdf.getFront());
		
		qdf.display();
	}
}
