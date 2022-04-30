package DateStrucImple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list1 = new ArrayList<Integer>(10);
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
	}

}
