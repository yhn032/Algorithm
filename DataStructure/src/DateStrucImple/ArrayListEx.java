package DateStrucImple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArrayListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list1 = new ArrayList<Integer>(10);
		//�ʱ⿡ ����Ʈ�� ������ ���������� ������ default������ 10�� ũ�Ⱑ �����ȴ٤�.
		//�⺻���� �Ұ�. �����Ϸ��� ����ڽ��� ���༭ ��ü�� �־��ִ� �Ŵ�. �Ϲ��ڷ����� ������
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(1));
		list1.add(new Integer(2));
		list1.add(new Integer(3));
		/*
		list1.add(5)
		list1.add(4)
		list1.add(2)
		list1.add(1)
		list1.add(2)
		list1.add(3)
		*/
		
		//�Ϻθ� �̾Ƽ� ���ο� ����Ʈ�� �����.
		//ArrayList(Collection c)�� ������ ��
		/*Ǯ��� ������ ����.
		List sub = list1.subList(1,4); -> sub�� �б⸸ �����մϴ�.
		ArrayList list2 = new ArrayList(sub);
		*/
		ArrayList<Integer> list2 = new ArrayList<Integer>(list1.subList(1, 1 + 3));
		//List sub = list2.subList(1, 2);
		//sub.add(1);
		/*
		 * for(Object s : sub) { System.out.print(s); }
		 */
		
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		for(int s : list2) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		//Collection�� �������̽�, Collections�� util Ŭ���� 
		Collections.sort(list1);
		Collections.sort(list2);
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		for(int s : list2) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		//list1�� list2�� ��� ��Ҹ� �����ϴ°�?
		System.out.println(list1.containsAll(list2));
		
		
		list2.add(11);
		list2.add(12);
		list2.add(3, 13); //�߰� ������ �����ϸ� ������ ��ҵ��� �� ĭ�� �ڷ� �̵��ؼ� �ڸ��� ����� ��� �ϱ� ������ �δ㰡�� �۾�
		
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		for(int s : list2) {
			System.out.print(s + " ");
		}
		
		list2.set(3, 20);
		
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		for(int s : list2) {
			System.out.print(s + " ");
		}
		
		
		list1.add(0, 111);
		
		System.out.println();
		System.out.print("list1:");
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		System.out.print("list2:");
		for(int s : list2) {
			System.out.print(s + " ");
		}
		System.out.println();
		//indexOf()�� ������ ��ü�� ��ġ�� �˷��ش�. 
		System.out.println("index = " + list1.indexOf(111));
		
		//����
		//index 1�� �ִ� ������ ��ü�� ��ġ�� �˷��ش�.
		list1.remove(1);
		
		System.out.println();
		System.out.print("list1:");
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		System.out.print("list2:");
		for(int s : list2) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		
		
		/*
		���� ��� ����Ʈ�� "1"�� 1�� ����� ��� remove�� ����� �� ������
		list1.remove(1)�� ����ϸ� boolean remove(Object obj)�� ȣ��Ǿ� �� 1�� ������ �� ������
		Object remove(int index)�� ȣ��Ǿ� �������� �ε����� 1�� ���� �����ȴ�. �̴� �ڵ��ڽ��� �Ǵ°��� �����ϰ� ����� ����̴�. 
		���� ���� ���ϴ´�� �ε�����1�ΰ��� �ƴ϶� �ǵ����Ͱ� 1�� ���� �����Ϸ��� ������ ���� �޼ҵ带 �����ؾ� �Ѵ�. 
		list1.remove(new Integer(1));
		
		*/
		
		
		//list1���� list2�� ��ġ�� �κи� ����� �������� �����Ѵ�. 
		//System.out.println(list1.retainAll(list2));
		
		System.out.println();
		System.out.print("list1:");
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		System.out.print("list2:");
		for(int s : list2) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		
		//list2���� list1�� ���Ե� ��ü���� �����Ѵ�. 
		/*
			1. get(i)�� list2���� ��ü�� �ϳ��� ������.
			2. contains()�� ���� ��ü�� list1�� �ִ��� Ȯ���Ѵ�. 
			3. remove(i)�� �ش� ��ü�� list2���� ����
		*/
		for(int i=list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		
		System.out.println();
		System.out.print("list1:");
		for(int s : list1) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		System.out.print("list2:");
		for(int s : list2) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		//ArrayList�� ����� ��ü�� ���� ���� 
		/*
		 * 
			�߰��� �����ִ� ��ü�� �����ϴ� ���
			1. ������ �����ͺ��� �ε������� �ڿ� �ִ� ��ü���� �� ĭ�� �̵��ϸ鼭 �����ϰ��� �ϴ� ���� ���� ����. 
			2. �����Ͱ� ��� �� ĭ�� �̵������Ƿ� ���� ���������� �����ϱ� �� ��ü�� �����ְԵǴµ� �̰��� �����ؾ��Ѵ�.(nulló���ϱ�)
			3. �����Ͱ� �����Ǿ� �������� ������ �پ����Ƿ� size�� ���� ���ҽ�Ų��.
			cf)�� ���� ������ index�� �ִ� ���� �����ϴ� ��� 1�� ������ �ݺ��ϸ鼭 ���� �������� �ʾƵ� �˴ϴ�.
			�߰����� ���� �����ϰų� ������ ������ ��, 1���� ���� ������ �ݺ��ϴ� ���� �δ㽺���� ��������̹Ƿ� �ǵ����̸� 1�� ��������� �ּ�ȭ �ϵ��� �ؾ��Ѵ�. 
			���� �ε��� 0�������� ����� �� ���������� �ʰ�, ���ɵ� ������
			
			�߰��� ���� �����ϴ� ��� (�������� �ݴ�)
			1. �����ϰ����ϴ� �ε����������� ���� �������� ��ĭ�� �̵���Ų��.
			2. �����Ͱ� ��� �� ĭ�� �ڷ� �̵������Ƿ� �����ϰ��� �ϴ� ��ġ���� ���� �� ���������Ͱ� �����ְ� �Ǵµ� �� ��ġ�� �����ϰ��� �ϴ� ���� �ִ´�. 
			3. size�� 1������Ų��.
		*/
		
		
		
		
		//Iterator
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		for(int i=0; i<list.size(); i++) {
			Object obj = list.get(i);
			System.out.println(obj);
		}
		//1ȸ���̴�. �� ���� ������ �о����� �ٽ� it��ü�� ���;� �Ѵ�.
		//�ڷᱸ���� ����� �� �� ������, �׶����� �ݺ��� ������ �������� �ʾƵ���.
		
		//�������̽� ���������� ��ĳ�����ؼ� �����ϸ� ����
		/*
		 	���� ��� ������ ������ �ڵ� ���� �߰��� �ڷᱸ���� �ٲ�� �� �� �� �ִ�. 
		 	�̷���, ����Ŭ������ ���������� ��ӹ��� �������̽��� �����ڷ������� ����ϸ�, 
		 	�������� �޼ҵ常 ����ϱ� ������, �ڷᱸ���� ������ ����. 
		 	�׸��Ͽ� �ڷᱸ���� ����������, ���������� ����ϴ� �޼ҵ常 �������߱⶧����, 
		 	�ڵ带 ������ �ʿ䰡 ����. (�׳� ó������ �����ڷ����� ���� Ŭ������ ��ٸ�, Ȥ�ó� 
		 	�ڷᱸ���� �ٲپ��� ��, �ٲٱ� ���� Ŭ���������� ����� �� �ִ� �޼ҵ�� ������ ����� ������ �����ؾ� �Ѵ�.)
		 	
		 	������, �������� �޼ҵ�θ� ����ؾ� �Ѵٴ� ������ ����
		 	
		 	map���� iterator�� ����. 
		 	���� ���� collection�������̽��� ��ӹ޴� ���� list, queue, set�̴�. 
		 	�׷��� map�� �÷������� �Ⱥ��� ����
		 	���� map�� iterator�� ��ȸ�� ����, keyset, entryset, valuesó�� 
		 	��ȯ���� set�� �޼ҵ带 ����ؼ� iterator�� ����ؾ� ��
		*/
		
		/*
		 * Map map = new HashMap();
		 * 
		 * Iterator it1 = map.entrySet().iterator();
		 */
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		/*
		 * map.put("1", 0); map.put("1", 1); map.put("2", 2); map.put("3", 3);
		 */
		
		map.put("1", map.getOrDefault("1", 0)+1);
		map.put("1", map.getOrDefault("1", 0)+1);
		map.put("2", map.getOrDefault("2", 0)+1);
		map.put("3", map.getOrDefault("3", 0)+1);
		
		for(String s : map.keySet()) {
			System.out.print(map.get(s) + " ");
		}
		
		
		
		
		
		
	}
}
