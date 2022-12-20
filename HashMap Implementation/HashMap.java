package user.created.hashmap;

import java.util.ArrayList;

public class HashMap<K, V> {
	public class Node {
		K key;
		V value;
		Node next;
	}
	
	private ArrayList<Node> bucket;
	
	private int size = 0;
	
	public HashMap()
	{
		this(4);									// yeh this use krne se yeh constructor niche wale intgr parametised cons call krega
	}
	
	public HashMap(int n)
	{
		bucket = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			bucket.add(null);
		}
	}
	
	public void put(K key, V value)
	{
		int idx = hashFun(key);			// kis index pe ki node adds pe dalna hai woh dhund ne k liye key ki ascii val % size of bucket
		Node temp = bucket.get(idx);		// jis index pe dalna hai uss index ka node adrs
		
		// maybe update krna pd jaye agr woh key already prsent ho
		while(temp!=null)
		{
			if(temp.key.equals(key))		// agr key mil gyi already exisiting toh value update/put kro and fun terminate
			{
				temp.value = value;
				return;
			}
			
			temp = temp.next;
		}
		size++;
		
		// agr woh key hai hi nhi usme toh nya node bna kr key value add krdege uss indx pe adrs daldege fir uss node ka
		temp = bucket.get(idx);
		Node nn = new Node();
		nn.key = key;
		nn.value = value;
		nn.next = temp;
		bucket.set(idx, nn);
		
		// ab element key-val pair add ho gye and incase ab bucket ho gyi full
		// toh ab hm nyi bucket bnayege bdi size ki agr FULL hue toh hi  --> rehashing krke
		double thf = 2.0;				// bucket me kitne elements rhe skte hai ek k niche ek-- threshold freq
		double lf = (1.0 *size)/bucket.size();			// load factor--> av bucket bucket me kitne elements hai
															// lf total elements(keys) present in bucket / bucket ki size([] list size)
		if(lf>thf)
			reHashing();							// agr lf>thf limit se jaada key ho gyi bucket me bucket full toh rehashing krege
	}

	private void reHashing() {
		// TODO Auto-generated method stub
		// means new bucekt bnayege double size ki usme phle wali key-value pair dalege ascii val ke acc
		ArrayList<Node> nba = new ArrayList<>();
		for (int i = 0; i < 2 * bucket.size(); i++) {
			nba.add(null);
		}
		
		ArrayList<Node> oba = bucket;
		bucket = nba;
		
		for (Node temp : nba) {
			while(temp!=null)
			{
				put(temp.key, temp.value);
				temp = temp.next;
			}
		}
		
	}

	public int hashFun(K key)
	{
		int bn = key.hashCode() % bucket.size();					// key ascii val%bucket ki size==> uss index pe dalege key ko
		if(bn<0)
			bn += bucket.size();				// agr negative index aye toh usko +ve krne k liye
		
		return bn;
	}
	
	public boolean containsKey(K key)
	{
		int idx = hashFun(key);
		Node temp = bucket.get(idx);
		while(temp!=null)
		{
			if(temp.key.equals(key))
				return true;
			
			temp = temp.next;
		}
		
		return false;
	}
	
	public V get(K key)
	{
		int idx = hashFun(key);
		Node temp = bucket.get(idx);
		while(temp!=null)
		{
			if(temp.key.equals(key))
				return temp.value;
			
			temp = temp.next;
		}
		
		return null;
	}
	
	public V remove(K key)
	{
		int idx = hashFun(key);
		Node curr = bucket.get(idx);
		Node prev = null;
		while(curr!=null)
		{
			if(curr.key.equals(key))
				break;
			
			prev = curr;
			curr = curr.next;
		}
		
		if(prev==null)							// agr prev null hai mtlb jisko key ko udana hai woh start pe hi hai
		{
			bucket.set(idx, curr.next);
			curr.next = null;
			size--;
			return curr.value;
		}
		else if(curr!=null)						// means curr khi bichme hai jha pe usko key mil gyi toh bichme se key pair remove krege
		{
			prev.next = curr.next;
			curr.next = null;
			size--;
			
			return curr.value;
		}
		else
		{
			return null;							// ya toh key mili hi nhi
		}
			
	}
	
	public int size()
	{
		return size;
	}
	
	@Override
	public String toString()
	{
		String s = "{";
		for(Node temp: bucket)
		{
			while(temp!=null)
			{
				s= s + temp.key + " = " + temp.value + ", ";
				temp = temp.next;
			}
		}
		s = s+"}";
		
		return s;
	}

}
