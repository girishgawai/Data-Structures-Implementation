package trie.ds;

import java.util.HashMap;

public class Tries_Contacts_HackerRank {
	
	private class Node {
		int data;
		HashMap<Character, Node> children = new HashMap<>();
		boolean isTerminal = false;
		int count = 0;
	}
	
	private Node root;
	
	public Tries_Contacts_HackerRank()
	{
		Node nn = new Node();
		nn.data = '*';
		this.root = nn;
	}
	
	public void insert(String word)
	{
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			if(node.children.containsKey(ch))
			{
				node = node.children.get(ch);
				node.count++;
			}
			else
			{
				Node nn = new Node();
				nn.data = ch;
				node.children.put(ch, nn);
				node = nn;
				node.count = 1;
			}
		}
		
		node.isTerminal = true;
	}
	
	public boolean search(String word)
	{
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if(node.children.containsKey(ch))
			{
				node = node.children.get(ch);
			}
			else
			{
				return false;
			}
		}
		
		return node.isTerminal;
	}
	
	public boolean startsWith(String prefix)
	{
		Node node = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if(node.children.containsKey(ch))
			{
				node = node.children.get(ch);
			}
			else
			{
				return false;
			}
		}
		
		return true;
	}

	public int countstartsWith(String prefix)
	{
		Node node = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if(node.children.containsKey(ch))
			{
				node = node.children.get(ch);
			}
			else
			{
				return 0;
			}
		}
		
		return node.count;
	}

}
