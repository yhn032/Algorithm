package DateStrucImple;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * TreeSet ���� Ž�� Ʈ���� ���� - ���� Ž��, ���Ŀ� ���� ���� Ʈ���� ��� ��尡 �ִ� 2���� ���� ��带 ���� �� ��Ұ� ����
		 * ���·� ����(linkedlist�� ����)
		 * 
		 * ����Ž�� Ʈ�� �θ𺸴� ���� ���� ����, ū ���� �����ʿ� ���� ���� - �����Ͱ� ������ ����(Ʈ���� Ŀ������) �߰�, ������ �ð��� ��
		 * �ɸ�(root���� ���� ���ϱ� ������ �� Ƚ�� ����)
		 * 
		 * class TreeNode { TreeNode left;//���� �ڽ� Object element;//������ TreeNode
		 * right;//������ �ڽ� }
		 * 
		 * 
		 * �������� ������� - boolean add(Object o) set�� �ߺ��� ������� �ʱ⶧���� �����͸� �����ϱ� ���� �ߺ� �˻縦
		 * �����մϴ�. 
		 * hashset - equals, hashcode�� �� treeset - compare�� ȣ���ؼ� ��
		 * 
		 * 
		 * Ʈ���¸��� �ֿ� �����ڿ� �޼��� TreeSet() �⺻ ������ 
		 * TreeSet(Collection c) �־��� �÷��� c�� �����ϴ� treeset���� 
		 * TreeSet(Comparator comp) �־��� ���� �������� �����ϴ� treeset�� ����
		 * 
		 * Object first() ���ĵ� �������� ù ��° ��ü�� ��ȯ(���� ������, ���Ͽ��ʾƷ�) 
		 * Object last() ���ĵ� �������� ������ ��ü�� ��ȯ(���� ū��, ���� ������ �Ʒ�) 
		 * Object ceiling(Object o) ������ ��üo�� ���� ��ü�� ��ȯ, ������ ū ���� ���� ��ü �� ���� ����� ��ü�� ��ȯ, ������ null(���ų� ū��) 
		 * Object floor(Object o) ������ ��üo�� ���� ��ü�� ��ȯ, ������ ���� ���� ���� ��ü �� ���� ����� ��ü�� ��ȯ, ������ null(���ų� ������) 
		 * Object higher(Object o) ������ ��üo���� ū ���� ���� ��ü�� ���� ����� ���� ��ü�� ��ȯ, ������ null(ū��) 
		 * Object lower(Object o) ������ ��üo���� ���� ���� ���� ��ü�� ���� ����� ���� ��ü�� ��ȯ, ������ null(������)
		 * 
		 * SortedSet subSet(Object fromElement, Object toElement) �����˻�, from�� to������ �����
		 * ��ȯ�Ѵ�. �������� to�� ���Ե��� �ʴ´�!! SortedSet headSet(Object toElement) ������ ��ü���� ���� ����
		 * ��ȯ SortedSet tailSet(Object fromElement) ������ ��ü���� ū ���� ��ȯ
		 */


		// Set set = new HashSet(); -> �� ���� �ȵ�, ���� �쿬�� ��ġ�� ������ �� ���� ����. �����Ϸ��� list��
		// �ڷᱸ���� ��ȯ���ְ�, collections.sort���. set�� ���� ����� �ȵǼ� ����Ʈ�� �ٲ㼭 �ϴ� ����

		/*
		 * for(int i=0; set.size() < 6; i++) { 
		 * 	int num = (int)(Math.random()*45) + 1;
		 * 	set.add(num); 
		 * �ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
		 * //�Ϲ����� wrapperŬ�������� Ŭ���� ��ü���� �񱳱����� ���� ��� �ϰ� �ֱ� ������ �񱳱����̱⺻������
		 * ������ ������, //����� ���� ��ü�� �񱳱����� ���� ������־�� �մϴ�. }
		 * 
		 * 
		 * set.add(new Test()); set.add(new Test()); set.add(new Test()); set.add(new
		 * Test());
		 * 
		 * System.out.println(set);
		 */

		/*
		 * String from = "b"; String to = "d";
		 * 
		 * 
		 * set.add("abc"); set.add("alien"); set.add("bat"); set.add("car");
		 * set.add("Car"); set.add("disc"); set.add("dance"); set.add("dZZZZ");
		 * set.add("dzzzz"); set.add("elephant"); set.add("elevator"); set.add("fan");
		 * set.add("flower");
		 * 
		 * 
		 * System.out.println(set); System.out.println("range search : from " + from +
		 * " to " + to); System.out.println("result1 : " + set.subSet(from, to));
		 * System.out.println("result2 : " + set.subSet(from, "dzzz"));
		 */

		/*
		 * int[] score = { 80, 95, 90, 50, 35, 45, 65, 10, 100 };
		 * {1, 2, 3, 4, 5, 6, 7}
		 * for (int i = 0; i < score.length; i++) { set.add(new Integer(score[i])); }
		 * 
		 * System.out.println("50���� ���� �� : " + set.headSet(new Integer(50)));
		 * System.out.println("50���� ū �� : " + set.tailSet(new Integer(50)));
		 */
		
		TreeSet set = new TreeSet(new TestComp()); // ���� �˻�, ���ĵ�
		/*
		 * for(int i=0; set.size() < 6; i++) { int num = (int)(Math.random()*45) + 1;
		 * set.add(new Test()); }
		 */
		
		set.add(new Test());
		set.add(new Test());
		set.add(new Test());
		set.add(new Test());
		
		System.out.println(set);
		

	}
}

class Test{}

class TestComp implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
//�� �� �ϳ�???
//1. treesetŸ������ ������ ��ü�� ���� ������ ���� �ִ��� -> TestComp
//2. Ʈ���¿� ����Ǵ� ��ü ��ü�� ���ı����� �����ϰ� �ִ��� - > class Test implements Comparable {}

/*
 * class Test {} // �񱳱����� ����. -> �񱳱����� ����� ��� �� class TestComp implements
 * Comparator{
 * 
 * @Override public int compare(Object o1, Object o2) { return 0; // TODO
 * Auto-generatedmethod stub return 1;
 * 
 * //�⺻������ ������ ������ ��, o1 - o2�� ������ �ϴµ�, ���� 0�̶�� ���� ���� ���̶�� �� ���� 1�̰ų� -1�϶��� ���߿�
 * //�ϳ��� �� ũ�ų� �۴ٴ� ���̴� �̸��� ���� �ٸ��ٴ� �Ŵ�. ���������� �⺻�̰�, 0�϶��� ��ȯx, ����� ��ȯ, ������ ��ȯx
 * //������������ �����Ϸ��� �⺻�� o1-o2 ��� o2-o1�� �ϸ� �˴ϴ�.
 * 
 * }
 * 
 * }
 */
