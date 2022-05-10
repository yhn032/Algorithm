package DateStrucImple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class HashMapEx {
	public static void main(String[] args) {

		HashMap map = new HashMap();
		//���� 1 - > ȸ������
		/*
		 * map.put("myID", "1234"); map.put("asdf", "1111"); map.put("asdf", "1234");
		 * System.out.println(map);
		 * 
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * while (true) { System.out.println("id�� password�� �Է��ϼ���.");
		 * System.out.print("id : "); String id = sc.nextLine().trim();
		 * 
		 * System.out.print("id : "); String pwd = sc.nextLine().trim();
		 * System.out.println();
		 * 
		 * if(!map.containsKey(id)) {
		 * System.out.println("�Է��Ͻ� id�� �������� �ʽ��ϴ�. �ٽ��Է����ּ���."); continue; }
		 * 
		 * if(!map.get(id).equals(pwd)) {
		 * System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ��Է����ּ���."); continue; }else {
		 * System.out.println("���̵�� ��й�ȣ�� ��ġ�մϴ�."); break; } }
		 */
		
		
		//���� 2 -> �������� ���ϱ�
		/*
		 * map.put("���ڹ�", new Integer(90)); map.put("���ڹ�", new Integer(100));
		 * map.put("���ڹ�", new Integer(100)); map.put("���ڹ�", new Integer(80));
		 * map.put("���ڹ�", new Integer(90));
		 * 
		 * //���� ���ͷ����� ���Ұ� Set set = map.entrySet(); Iterator it = set.iterator();
		 * 
		 * while(it.hasNext()) { //Map : �������̽�, Entry : Map�� ���� �������̽�. �ϳ��� ��ü Ÿ���̴�.
		 * Map.Entry e = (Map.Entry)it.next(); //objectŸ���� ��ȯ(�ܿ���)�ϹǷ� ����ȯ
		 * System.out.println("�̸� : " + e.getKey() + ", ���� " + e.getValue()); }
		 * 
		 * set = map.keySet(); System.out.println("������ ��� : " + set);
		 * 
		 * Collection values = map.values(); //��ȯŸ�� Collection it = values.iterator();
		 * 
		 * int total = 0;
		 * 
		 * while(it.hasNext()) { int i = (int) it.next(); //Integer, int �� �� ���� total +=
		 * i; }
		 * 
		 * System.out.println("���� : " + total); System.out.println("��� : " +
		 * (float)total/set.size()); System.out.println("�ְ����� : " +
		 * Collections.max(values)); System.out.println("�������� : " +
		 * Collections.min(values));
		 */
		
		
		
		//���� 3 -> �󵵼� ���ϱ� 
		String data[] = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};
		
		for(int i=0; i< data.length; i++) {
			if(map.containsKey(data[i])) {
				int value = (int)map.get(data[i]);
				map.put(data[i], value + 1);
			} else {
				map.put(data[i], 1);
			}
		}
		
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String str = (String)it.next();
			int value = (int)map.get(str);
			System.out.println(str + " : " + printBar("#", value) + " " + value);
		}
		
		
		
		  Map<Integer, String> Tmap = new TreeMap<>(); 
		  Map<Integer, String> Hmap = new HashMap<>();
		  
		  Tmap.put(3, "val"); //[3,"val"];
		  Tmap.put(5, "val"); //[5,"val"]
		  Tmap.put(7, "val"); 
		  Tmap.put(9,"val"); 
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
		  
		  // Map�� ��ü ��ȸ�ϴ� ���
		  
		/*  map���� iterator�� ����. ���� ���� collection�������̽��� ��ӹ޴� ���� list, queue, set�̴�. �׷���
		  map�� �÷������� �Ⱥ��� ���� ���� map�� iterator�� ��ȸ�� ����, keyset, entryset, valuesó�� ��ȯ����
		  set�� �޼ҵ带 ����ؼ� iterator�� ����ؾ� ��*/
		  
		  
		  
		  //import java.util.Map.Entry; 
		  // 0. System.out.println()
		  System.out.println(Tmap); 
		  System.out.println(Hmap); 
		  // 1. EntrySet()
		  System.out.println("�������� ��Ʈ����(Tmap)"); 
		  for (Entry<Integer, String> entry :Tmap.entrySet()) { 
			  System.out.println("[Key] : " + entry.getKey() +"[value] : " + entry.getValue()); 
		  } 
		  
		  // 2. KeySet()
		  System.out.println("�������� Ű��(Hmap)"); 
		  for(Integer i : Hmap.keySet()) {
			  System.out.println("[Key] : " + i + "[value] : " + Hmap.get(i)); 
		  }
		  
		  // 3.Iteraotor(1ȸ��) 
		  System.out.println("���ͷ����� ��Ʈ����(Tmap)");
		  Iterator<Entry<Integer, String>> entries = Tmap.entrySet().iterator();
		  while(entries.hasNext()) { 
			  Map.Entry<Integer, String> entry = entries.next();
			  System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue()); 
		  }
		  
		  //3-2 System.out.println("���ͷ����� Ű��(Hmap)"); 
		  Iterator<Integer> keys = Hmap.keySet().iterator(); 
		  while(keys.hasNext()) { 
			  int key = keys.next();
			  System.out.println("[Key] : " + key + " [Value] : " + Hmap.get(key));
		  }
		  
		  
		}

	private static String printBar(String string, int value) {
		// TODO Auto-generated method stub
		String str = "";
		for (int i = 0; i < value; i++) {
			str += string;
		}
		return str;
	}

}
