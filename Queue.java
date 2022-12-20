package user.created.ds;

public class Queue {
	protected int[] arr;
	protected int front;
	protected int size;
	
	public Queue() {
		// TODO Auto-generated constructor stub
		this.arr = new int[5];
		this.front=0;
		this.size=0;
	}

	public Queue(int[] arr, int front, int size) {
		this.arr = arr;
		this.front = front;
		this.size = size;
	}
	
	// isse circular queue bnegi
	public void EnQueue(int item) throws Exception
	{
		if(isFull())
			throw new Exception("Queue is Full");
		
//		arr[size]=item;		// but if a data is removed and size-- kia toh phle wale pos pe hi data overwrite hoga.. toh purana data uss queue ka udd jayega
		
		int idx = (size+front)%arr.length;		// isse data bra br wali postn pe jayega queue me.. WUE me DATA FIFO se niklta/dalta hai
		arr[idx] = item;
		size++;
	}
	
	public int DeQueue() throws Exception
	{
		if(isEmpty())
			throw new Exception("Queue is Empty");
		
		int val = arr[front];			
//		front++;					// but isse Enque me problm hue usko chng kia.. ab isme v problm hoga jb front aar ki len jitna hoga
										// usko firse phle wale index se chlana tha data remove krne ke liye
		
		front = (front+1)%arr.length;		// isse front arr ki len pe jayega nh.. firse phle me ayega data remove krne ke liye
		size--;
		
		return val;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	public boolean isFull() {
		// TODO Auto-generated method stub
		return size==arr.length;
	}
	
	public int getFront() throws Exception
	{
		if(isEmpty())
			throw new Exception("Queue is Empty");
		
		int val = arr[front];
		return val;
	}
	
	public int size ()
	{
		return size;
	}
	
	public void display()		// display brabr krna pdega.. arr ki start se nhi.. blki FIFO according jo sbse phle dala usse
	{
		for (int i = 0; i < size; i++) {
			int idx = (i+front)%arr.length;
			System.out.print(arr[idx] + "  ");
		}
		System.out.println();
	}
	
}
