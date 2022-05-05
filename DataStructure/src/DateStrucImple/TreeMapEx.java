package DateStrucImple;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapEx {
	public static void main(String[] args) {
		TreeMap<Integer, String> Tmap = new TreeMap<>();
		HashMap<Integer, String> Hmap = new HashMap<>();

		Tmap.put(3, "val");
		Tmap.put(5, "val");
		Tmap.put(7, "val");
		Tmap.put(9, "val");
		Tmap.put(12, "val");
		Tmap.put(141, "val");
		Tmap.put(167, "val");
		Tmap.put(1242, "val");
		Tmap.put(12983, "val");

		Hmap.put(3, "val");
		Hmap.put(5, "val");
		Hmap.put(7, "val");
		Hmap.put(9, "val");
		Hmap.put(12, "val");
		Hmap.put(141, "val");
		Hmap.put(167, "val");
		Hmap.put(1242, "val");
		Hmap.put(12983, "val");

		System.out.println("TreeMap = " + Tmap.keySet().toString());
		System.out.println("HashMap = " + Hmap.keySet().toString());

		// Map을 전체 순회하는 방법
		//import java.util.Map.Entry;
		// 0. System.out.println()
		System.out.println(Tmap);
		System.out.println(Hmap);
		// 1. EntrySet()
		for (Entry<Integer, String> entry : Tmap.entrySet()) {
			System.out.println("[Key] : " + entry.getKey() + "[value] : " + entry.getValue());
		}
		// 2. KeySet()
		for(Integer i : Tmap.keySet()) {
			System.out.println("[Key] : " + i + "[value] : " + Tmap.get(i));
		}
		// 3. Iteraotor(1회성)
	}

}
