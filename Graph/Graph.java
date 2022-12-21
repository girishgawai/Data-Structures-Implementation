package user.created.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	HashMap<Integer, HashMap<Integer, Integer>> map;

	public Graph(int v)
	{
		map = new HashMap<>();
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addEdge(int v1, int v2, int cost)
	{
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}

	public boolean containsEdge(int v1, int v2)
	{
		return map.get(v1).containsKey(v2);
	}

	public boolean containsVertex(int v)
	{
		return map.containsKey(v);
	}

	public int noOfEdge()
	{
		int totalEdges = 0;

		for(int key : map.keySet())
		{
			totalEdges = totalEdges + map.get(key).size();
		}

		// but isse same edges alg-alg vertex pe 2 bar count hue hai.. so uski half krdo jo value hogi whi edges hogi
		//		totalEdges = totalEdges/2;
		return totalEdges/2;
	}

	public void removeEdge(int v1, int v2)
	{
		if(containsEdge(v1, v2))
		{
			map.get(v1).remove(v2);	
			map.get(v2).remove(v1);
		}
	}

	public void removeVertex(int v)
	{
		if(containsVertex(v)) {
			for(int key : map.get(v).keySet())
			{
				map.get(key).remove(v);					// uss vertex se niklne wale sari edges ko v remove krna hoga
			}													// toh unn vertex pe jakr iss vertex ki sare edges v nikal dege

			map.remove(v);								// finally iss vertex ko remove krdia map se
		}
	}

	public void display()
	{
		for(int key : map.keySet())
		{
			System.out.println(key + " --> " + map.get(key));
		}
	}

	public boolean hasPath(int src, int des, HashSet<Integer> visited)
	{
		if(src==des)									// src aur des mil gye mtlb path hai
		{
			return true;
		}

		visited.add(src);									// visit krliya hua vertex ko mark kr dege.. wapis usipe ghumte na rhe isliye
		for(int key : map.get(src).keySet())
		{
			if(!visited.contains(key))							// agr visited nhi hai toh hi call lgayege iss direction vertex me
			{
				boolean ans = hasPath(key, des, visited);
				if(ans==true)								// agr path mila hai toh aage check nhi krege baki vertex/edges pe, got ans
					return true;
			}
		}
		visited.remove(src);			// iss case me backtrack nhi v krte toh chlta.. kyu ki ek hi path chahiye tha vertexes k bich wala

		return false;
	}
	
	public void printPath(int src, int des, HashSet<Integer> visited, String ansPAth)
	{
		if(src==des)
		{
			ansPAth = ansPAth+src;	// jaise hi src ko des mil jayegi path.. print kra dege path ko.. but last wala vertex jisse aaye hai usko add nhi kia isliye phle add krege des ko usme then print krege complete path
			System.out.println(ansPAth);
			return;
		}
		
		visited.add(src);
		for(int key : map.get(src).keySet())
		{
			if(!visited.contains(key))
			{
				printPath(key, des, visited, ansPAth + src);
			}
		}
		visited.remove(src);						// backtrack.. baki ke path se v agr ja skte hoge paths toh unko v print krana hai
		
	}

	/************************** Breadth For Search Algo (BFS) *******************************/ // (ITERATIVE APPROACH)
	// same as level order transervsal of Tree but with some updation steps -- > kya vertex v1 & v2 connected hai?
	
	public boolean BFS(int src, int des)
	{
		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		
		q.add(src);
		
		while(!q.isEmpty())
		{
			// step 1 --> remove one data
			int removed = q.poll();
			
			// step 2 --> agr visited vertex hai .. & usiko wapis remove kia jara hai Queue se.. it means 2 Paths hai
			// means CYCLE detect hori hai Graph me		// 2 alg alg graphs hai jinke v1 v2 kv nhi milege so ek hi graph me ghumre
			if(visited.contains(removed))
			{
				continue;						// agr already visited hai and visited hi wapis apprear hua hai Q me toh ignore krke
			}												// next elements pe jao Q wale process repeat krne next element se
			
			// step 3 --> visited mark krdo Set me
			visited.add(removed);
			
			// step 4 --> self work krlo jo krna hai --> this time meko src == des mil rhe kya check krna hai.. connext hai kya?
			if(removed==des)									// remove kiya hua vertex des tk phoch jaye mtlb src se hi aaya hai na remov wale vertex tk.. toh remove wala pohoch gya des pe mtlb src v phoch jayega
				return true;
			
			// step 5 --> ab iske neighbours ko add krdo agr honge toh (add child if exists)
			// unvisited neighbours ko hi add krna hai only
			for(int key : map.keySet())
			{
				// agr visited nhi hai neighbour toh hi add krege
				if(!visited.contains(key))
					q.add(key);
			}
		}
		
		return false;
	}
	
	
	
}
