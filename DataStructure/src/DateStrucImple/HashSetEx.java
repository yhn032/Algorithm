package DateStrucImple;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Set
		����x, �ߺ�x
		HashSet
		Set�������̽��� ������ ��ǥ���� �÷��� Ŭ���� 
		������ �����Ϸ��� LinkedHashSet�� ����ϸ� �ȴ�.
		TreeSet
		���� �˻��� ���Ŀ� ������ �÷��� Ŭ����
		HashSet���� ������ �߰�, ������ �ð��� �� �ҿ��
		
		*/
		
		//������
		/* 
		�⺻ ������
		public HashSet() {
        map = new HashMap<>();
    	}
		
		������ �÷��� c�� ��� ��ü�� �����ϸ鼭 set ����
	    public HashSet(Collection<? extends E> c) {
	        map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
	        addAll(c);
	    }
	
		loadfactor�� ���� ���� ������ ������Ų��.
	    public HashSet(int initialCapacity, float loadFactor) {
	        map = new HashMap<>(initialCapacity, loadFactor);
	    }
	
	  	
		�ʱ� �뷮 �����ؼ� ����
	    public HashSet(int initialCapacity) {
	        map = new HashMap<>(initialCapacity);
	    }
		*/
		
		//�߰� 
		/*
		boolean add(Object o)
		boolean addAll(Collection c) ������
		boolean remove(Object o)
		boolean removeAll(Collection c) �÷���c�� �ִ� ��ü�� ���� ��ü�� ����, ������
		boolean retainAll(Collection c) ���Ǻλ���. �÷���c�� �ִ� ��ü�� ����� ����. ������
		boolean clear() ��� ���� 
		*/
		
		//�˻�
		/*
		boolean contains(Object o)
		boolean containsAll(Collections c) //�÷��� c�� ��� ���ԵǾ� �ִ°�?
		Iterator iterator()
		*/
		
		//��Ÿ 
		/*
		boolean isEmpty() �������
		int size() ����� ��ü��
		Object[] toArray() ��ü�迭 ��ȯ
		Object[] toArray(Object[] a)
		*/
		
		//���� 1
		/*
		//�ߺ������ʹ� set�� �߰� ���� �ʴ´�. 
		//1�� �ϳ��� ���ڿ�, �ϳ��� integer�̹Ƿ� �� �� ������ �˴ϴ�.
		//��������� ������ ���� �ȵɼ��� ������, ���� ������ �Ź� �������� �ʴ´�.
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
		
		Set hs = new HashSet();
		
		for(int i=0; i<objArr.length;i++) {
			//�߰�, ���� �޼ҵ�� ���� ����Ǹ� true, �����ϸ� false�� ��ȯ�Ѵ�,
			System.out.println(objArr[i] + "=" +  hs.add(objArr[i])); //HashSet�� �ִ� objArr�� ��ҵ��� �����Ѵ�.
		}
		
		//HashSet�� ����� ��ҵ��� ����Ѵ�.
		System.out.println(hs);
		
		//HashSet�� ����� ��ҵ��� ����Ѵ�.
		Iterator it = hs.iterator();
		
		//�о�� ��Ұ� �����ִٸ� �ݺ��ض� 
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		*/
		
		
		//���� 2
		Set set = new HashSet();
		
		//set�� ũ�Ⱑ 6���� �������� 1~45�� ������ ���
		for(int i=0; set.size()<6 ; i++) {
			int num = (int)(Math.random()*45)+1;
			set.add(num);
		}
		
		List list = new LinkedList(set);//set�� ������ �ȵǹǷ� set�� �����͸� list�� ���θ��� �ű��.
		Collections.sort(list);//������ ����Ʈ�� �����մϴ�.
		System.out.println(list);
		
		//���� 3
		//HashSet�� ��ü�� �����ϱ� ���� ������ ���� ��ü�� �ִ��� Ȯ��
		//���� ��ü�� ������ �����ϰ�, ������ �������� �ʴ´�.
		//boolean add(Object o)�� ������ ��ü�� equals()�� hashCode()�� ȣ���Ͽ� �ߺ����� Ȯ���Ѵ�.
	}

}
