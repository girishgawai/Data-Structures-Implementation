package trees.binarytree;

public class Binary_Search_Tree_BST {
	
	private class Node {
		int val;
		Node left;
		Node right;
	}
	
	private Node root;
	
	public Binary_Search_Tree_BST(int[] in)
	{
		this.root = Create_Tree(in,0,in.length-1);
	}

	private Node Create_Tree(int[] in, int si, int ei) {
		// TODO Auto-generated method stub
		if(si>ei)
			return null;
		
		
		int mid = (si+ei)/2;
		Node nn = new Node();
		nn.val = in[mid];
		
		nn.left = Create_Tree(in, si, mid-1);
		nn.right = Create_Tree(in, mid+1, ei);
		
		
		return nn;
	}
	
	public void display()
	{
		Display(this.root);		
		System.out.println();
	}

	private void Display(Node nn) {
		// TODO Auto-generated method stub
		if(nn==null)
			return;
		
		String str = "<--"+nn.val+"-->";
		if(nn.left!=null)
			str = nn.left.val+str;
		else
			str = "."+str;
		if(nn.right!=null)
			str= str+nn.right.val;
		else
			str = str+".";
		
		System.out.println(str);
		
		Display(nn.left);
		Display(nn.right);		
	}
	
	public int max()
	{
		return maximum(root);
	}
	
	
	private int maximum(Node nn) {
		// TODO Auto-generated method stub
		if(nn==null)
			return Integer.MIN_VALUE;
		
		int right = maximum(nn.right);
		return Math.max(right, nn.val);
	}

	public static void main(String[] args) {
		int[] in = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		Binary_Search_Tree_BST bst = new Binary_Search_Tree_BST(in);
		bst.display();
		
		int max = bst.max();
		System.out.println(max);
	}
	
}
