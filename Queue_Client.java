package user.created.ds;

public class Queue_Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		q.EnQueue(10);
		q.EnQueue(20);
		q.EnQueue(30);
		q.EnQueue(40);
		
		System.out.println(q.getFront());
		System.out.println(q.DeQueue());
		System.out.println(q.DeQueue());
		System.out.println(q.getFront());
		
		q.EnQueue(-20);
		q.EnQueue(-30);
		q.EnQueue(-40);
		q.display();
//		q.EnQueue(32);
		System.out.println(q.size());
	}

}
