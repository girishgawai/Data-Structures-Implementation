package user.created.hashmap;

public class HashMap_DemoClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Girish", 8);
		map.put("Akanksha", 15);
		map.put("Shreya", 18);
		map.put("Pyali", 20);
		map.put("Rudrakshi", 5);
		map.put("Nishika", 16);
		System.out.println(map);
		
		
		System.out.println(map.containsKey("Girish"));
		System.out.println(map.containsKey("Akanksha"));
		System.out.println(map.containsKey("shreya"));
		
		System.out.println(map.get("Girish"));
		
		System.out.println(map.size());
		
		System.out.println(map.get("Akanksha"));
		System.out.println(map.get("akanksha"));
		
		map.remove("Pyali");
		System.out.println(map);
	}

}
