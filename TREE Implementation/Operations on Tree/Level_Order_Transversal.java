package tree.qps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Level_Order_Transversal {
	Scanner sc = new Scanner(System.in);

	public class Node {
		int data;
		Node left;
		Node right;

	}

	private Node root;

	/***************************************************************************************************************************/
	// Level Order Transversal
	public void LevelOrder()
	{
		Queue<Node> q = new LinkedList<>();
		//		LinkedList<Node> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty())
		{
			//			 Remove from FIFO from Queue and
			Node deleted = q.poll();								// q.remove()

			//			 Print the value
			System.out.print(deleted.data + "  ");

			// 			 Add children nodes of removed data/node
			if(deleted.left!=null)
				q.add(deleted.left);

			if(deleted.right!=null)
				q.add(deleted.right);
		}
	}

	//Input
	//	10 true 20 true 40 false false true 50 false false true 30 false true 60 true 70 false false false
	public static void main(String[] args) {
		Level_Order_Transversal lot = new Level_Order_Transversal();
		lot.LevelOrder();
	}


	public Level_Order_Transversal() {
		// TODO Auto-generated constructor stub
		this.root = CreateTree();

	}

	private Node CreateTree() {
		// TODO Auto-generated method stub

		int item = sc.nextInt();
		Node nn = new Node();
		nn.data = item;
		boolean hlc = sc.nextBoolean();
		if (hlc == true) {
			nn.left = CreateTree();// left subStree
		}

		boolean hlr = sc.nextBoolean();
		if (hlr == true) {
			nn.right = CreateTree();// right SubStree
		}
		return nn;

	}
}
