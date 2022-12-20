package priority_queue;

import java.util.ArrayList;
									/* Min Heap */
public class Heap {
	
	private ArrayList<Integer> list = new ArrayList<>();
	
	public void add(int item)
	{
		list.add(item);
		upheapify(list.size()-1);
	}

	private void upheapify(int ci) {
		// TODO Auto-generated method stub
		int pi = (ci-1)/2;
		if(list.get(pi)>list.get(ci))
		{
			swap(pi,ci);
			upheapify(pi);
		}
	}

	private void swap(int pi, int ci) {
		// TODO Auto-generated method stub
		int pith = list.get(pi);
		int cith = list.get(ci);
		list.set(pi, cith);
		list.set(ci, pith);
	}
	
	public int getMin()
	{
		return list.get(0);
	}
	
	public void display()
	{
		System.out.println(list);
	}
	
	public int remove()
	{
		swap(0,list.size()-1);
		int delete = list.remove(list.size()-1);
		downheapify(0);
		return delete;
	}

	private void downheapify(int pi) {
		// TODO Auto-generated method stub
		int lfi = (2*pi) + 1;
		int rti = (2*pi) + 2;
		
		int mini = pi;
		if(lfi<list.size() && list.get(mini)>list.get(lfi))
			mini = lfi;
		
		if(rti<list.size() && list.get(mini)>list.get(rti))
			mini = rti;
		
		if(mini!=pi)
		{
			swap(pi, mini);
			downheapify(mini);
		}
		
		
	}

}
