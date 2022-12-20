package trees.binarytree;

public class BinaryTree_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();			//n Contructor bnate se hi Tree ko call ho jayega bnana.. Acc to our written code
		
/******************************************************************************************************************************
		INPUT FORMAT OF TREE
		10 true 20 true 40 false false true 50 false false true 30 false true 60 true 70 false false false
		
*******************************************************************************************************************************/
		
		bt.Display();
		System.out.println();
		bt.Post_Order();
		System.out.println();
		
		bt.In_Order();
		System.out.println();
		
		bt.Pre_Order();
		System.out.println();
		
		System.out.println(bt.find(70));
		System.out.println();

		System.out.println(bt.maximum());
		System.out.println();
		
		System.out.println(bt.height());
	}

}
