package DateStrucImple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list1 = new ArrayList<Integer>(10);
		//기본형은 불가. 컴파일러가 오토박싱을 해줘서 객체를 넣어주는 거다. 일반자료형은 못들어옴
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
		
		//일부를 뽑아서 새로운 리스트를 만든다.
		//ArrayList(Collection c)를 응용한 것
		/*풀어쓰면 다음과 같다.
		List sub = list1.subList(1,4); -> sub는 읽기만 가능합니다.
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
		//Collection은 인터페이스, Collections는 util 클래스 
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
		
		//list1이 list2의 모든 요소를 포함하는가?
		System.out.println(list1.containsAll(list2));
		
		
		list2.add(11);
		list2.add(12);
		list2.add(3, 13); //중간 삽입을 지정하면 나머지 요소들이 한 칸씩 뒤로 이동해서 자리를 만들어 줘야 하기 때문에 부담가는 작업
		
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
