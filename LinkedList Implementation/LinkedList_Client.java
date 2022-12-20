package user.created.linkedlist;

public class LinkedList_Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.addFirst(10);
		ll.addFirst(20);
		ll.addFirst(30);
		ll.display();
		ll.addLast(40);
		ll.display();
		ll.addAtIndex(2, -9);
		ll.display();
		ll.addFirst(200);
		ll.addFirst(300);
		ll.addFirst(201);
		ll.addFirst(301);
		System.out.println(ll.getFirst());
		System.out.println(ll.getLast());
		System.out.println(ll.getAtIndex(2));
		ll.display();
		System.out.println(ll.removeFirst());
		ll.display();
		System.out.println(ll.removeLast());
		ll.display();
		System.out.println(ll.removeAtIndex(2));
		ll.display();
	}

}
