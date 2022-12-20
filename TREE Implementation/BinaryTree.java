package trees.binarytree;

import java.util.Scanner;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;							// start of Tree --> there will be only ONE Root node in entire tree
	Scanner sc = new Scanner(System.in);

	public BinaryTree()
	{
		this.root = CreateTree();
	}

	private Node CreateTree() {
		// TODO Auto-generated method stub
		int item = sc.nextInt();
		Node n = new Node();
		n.data = item;

		boolean hlc = sc.nextBoolean();				// has left cycle?
		if(hlc==true)
			n.left = CreateTree();

		boolean hrc = sc.nextBoolean();				// has left cycle?
		if(hrc==true)
			n.right = CreateTree();

		return n;
	}

	public void Display()
	{
		Display(root);
	}

	private void Display(Node nn)
	{
		if(nn==null)								// Base Case
			return;
		
		String s = "<--" + nn.data + "-->";
		if(nn.left!=null)
		{
			s = nn.left.data + s;
		}
		else
		{
			s = "." + s;
		}
		
		if(nn.right!=null)
		{
			s = s + nn.right.data;
		}
		else
		{
			s = s + ".";
		}
		
		System.out.println(s);
		Display(nn.left);
		Display(nn.right);
	}
	
	// POST ORDER TRANSVERSAL CODE
	public void Post_Order()
	{
		Post_Order_Transversal(root);
		System.out.println();
	}
	
	private void Post_Order_Transversal(Node nn)
	{
		if(nn==null)
			return;
		
//		if(nn.left!=null)
//		{
			Post_Order_Transversal(nn.left);
//		}
		
//		if(nn.right!=null)
//		{
			Post_Order_Transversal(nn.right);
//		}
		
		System.out.print(nn.data + "  ");
	}
	
	// IN ORDER TRANSVERSAL CODE
	public void In_Order()
	{
		In_Order_Transversal(root);
		System.out.println();
	}
	
	private void In_Order_Transversal(Node nn)
	{
		if(nn==null)
			return;
		
		In_Order_Transversal(nn.left);
		System.out.print(nn.data + "  ");
		In_Order_Transversal(nn.right);
		
	}

	// PRE ORDER TRANSVERSAL CODE
	public void Pre_Order()
	{
		Pre_Order_Transversal(root);
		System.out.println();
	}
	
	private void Pre_Order_Transversal(Node nn)
	{
		if(nn==null)
			return;
		
		System.out.print(nn.data + "  ");
		Pre_Order_Transversal(nn.left);
		Pre_Order_Transversal(nn.right);
		
	}
	
	// FIND AN ELEMENT IN THE TREE
	public boolean find(int item)
	{
		return findElement(root, item);
	}
	
	private boolean findElement(Node nn, int item)
	{
		if(nn==null)
			return false;
		
		if(nn.data==item)
			return true;
		
		boolean leftFound =  findElement(nn.left, item);
		boolean rightFound = findElement(nn.right, item);
		
		return leftFound || rightFound;
	}

	// FIND MAXIMUM ELEMENT IN TREE
	public int maximum() {
		// TODO Auto-generated method stub
		return findMax(root);
	}

	private int findMax(Node nn) {
		// TODO Auto-generated method stub
		if(nn==null)
			return Integer.MIN_VALUE;
		
		int leftMax = findMax(nn.left);
		int rightMax = findMax(nn.right);
		
		return Math.max(nn.data, Math.max(leftMax, rightMax));
	}

	//  HEIGHT OF THE TREE
	public int height() {
		// TODO Auto-generated method stub
		return heightOfTree(this.root);
	}

	private int heightOfTree(Node nn) {
		// TODO Auto-generated method stub
		if(nn==null)
			return -1;						// if given to take hieght of single node tree = 1 then return 0
														// if 0 then return -1		
		
		int leftHT = heightOfTree(nn.left);
		int rightHT = heightOfTree(nn.right);
		
		return Math.max(leftHT, rightHT) + 1;			// Plus 1 krege usme khud ki height daalne k liye
	}
	

}
