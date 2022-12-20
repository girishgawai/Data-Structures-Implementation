package user.created.dynamic_stack;

import user.created.ds.Stack;

public class Dynamic_Stack extends Stack {
	
	@Override
	public void push (int item) throws Exception
	{
		if(isFull())
		{
			int[] newarrStack = new int[2*arr.length];
			for (int i = 0; i < arr.length; i++) {
				newarrStack[i] = arr[i];
			}
			
			arr = newarrStack;
		}
		
		super.push(item);
	}
	

}
