package user.created.dynamic_queue;

import user.created.ds.Queue;

public class Dynamic_Queue extends Queue {

	@Override
	public void EnQueue (int item) throws Exception
	{
		if(isFull())
		{
			int[] newarrQueue = new int[arr.length * 2];
			
			for (int i = 0; i <size; i++) {
				int idx = (front+i)%arr.length;
				newarrQueue[i] = arr[idx];
			}
			
			arr=newarrQueue;
			front=0;
		}
		
		super.EnQueue(item);				// super likhne se parent class wala fn call hoga .. isi cls wala fn nhi
	}
	
	public static void main (String[] args) throws Exception
	{
		Dynamic_Queue dq = new Dynamic_Queue();
		System.out.println(dq.isEmpty());
		dq.EnQueue(10);
		dq.EnQueue(20);
		dq.EnQueue(30);
		System.out.println(dq.size);
		dq.EnQueue(40);
		dq.EnQueue(50);
		System.out.println(dq.isEmpty());
		System.out.println(dq.DeQueue());
		System.out.println(dq.DeQueue());
		dq.EnQueue(60);
		dq.EnQueue(70);
		dq.display();
		
		dq.EnQueue(80);
		dq.display();
	}
}
