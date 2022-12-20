package tree.qps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Level_Order_TreeBulid {
	
	public class Node {
		int val;
		Node left;
		Node right;
	}
	
	private Node root;
	
	public Level_Order_TreeBulid()
	{
		this.root = CreateTree();
	}

	private Node CreateTree() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Node> q = new LinkedList<>();
		
		int item = sc.nextInt();
		Node nn = new Node();
		nn.val = item;
		root = nn;
		
		q.add(nn);
		
		while(!q.isEmpty())
		{
			Node rv = q.poll();				// removed first element in the Queue and storedd address node in rv
			int c1 = sc.nextInt();			// first child --> left
			int c2 = sc.nextInt();			// second child --> right
			
			if(c1!=-1)						// agr phla child exist krta hai toh
			{
				Node node = new Node();
				node.val = c1;
				rv.left=node;
				q.add(node);
			}
			
			if(c2!=-1)						// agr dusra child exist krta hai toh
			{
				Node node = new Node();
				node.val = c2;
				rv.right=node;
				q.add(node);
			}
		}
		
		return root;
	}
	
	public void Display()
	{
		display(root);
	}

	private void display(Node node) {
		if(node==null)
			return;
		
		System.out.print(node .val + " ");
		display(node.left);
		display(node.right);
	}
	
	// Input  -  10 20 30 40 50 -1 60 -1 -1 -1 70 80 90 -1 -1 -1 -1 -1 -1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level_Order_TreeBulid LOTB = new Level_Order_TreeBulid();
		LOTB.Display();
	}

}
