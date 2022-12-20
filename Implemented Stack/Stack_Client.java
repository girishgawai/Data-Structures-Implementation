package user.created.ds;

public class Stack_Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub\
		Stack s = new Stack();

		System.out.println(s.size());
		System.out.println(s.isEmpty());
		s.push(20);
		s.push(7);

		System.out.println(s.peek());
		System.out.println(s.isEmpty());

		System.out.println(s.size());
		
		s.display();
		
		s.push(2);
		s.push(8);
		s.push(1);

		System.out.println();
		System.out.println(s.size());
		s.display();
		
//		s.push(12);

		System.out.println();
		System.out.println(s.isFull());
		
		s.pop();
		System.out.println(s.size());
		s.display();
		
		s.push(22);
		s.push(3);
		
	}

}
