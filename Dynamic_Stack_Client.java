package user.created.dynamic_stack;

public class Dynamic_Stack_Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Dynamic_Stack ds = new Dynamic_Stack();
		
		ds.display();
		System.out.println(ds.isEmpty());
		ds.push(12);
		ds.push(20);
		System.out.println(ds.pop());
		System.out.println(ds.peek());
		ds.push(50);
		System.out.println(ds.size());
		System.out.println(ds.isFull());
		
		ds.display();
	}

}
