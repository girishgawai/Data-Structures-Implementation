package graph.algos;

public class Graph_BDFS_DFS_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph_BFS_DFS g = new Graph_BFS_DFS(9);
		
//		g.addEdge(1, 4, 6);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 4, 5);
//		g.addEdge(4, 5, 1);
		g.addEdge(5, 6, 4);
		g.addEdge(7, 5, 2);
		g.addEdge(6, 7, 3);
		g.addEdge(8, 9, 1);
		
		System.out.println(g.BFS(1, 6));
		System.out.println(g.DFS(1, 6));
		
		g.BFT();
		System.out.println("********************");
		g.DFT();
		
		System.out.println(g.Cycle_Detection());
		
		System.out.println(g.countComponents());		// no of Graphs
	}

}
