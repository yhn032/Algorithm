package MapSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1269_��Ī������ {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		
		Set<Integer> seta = new HashSet<Integer>();
		Set<Integer> setb = new HashSet<Integer>();
		
		
		
		
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<a; i++) {
			seta.add(Integer.parseInt(st.nextToken()));
		}
		//printSet(seta);
		
		
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<b; i++) {
			setb.add(Integer.parseInt(st.nextToken()));
		}
		//printSet(setb);
		
		//������
		Set<Integer> inter = new HashSet<Integer>(seta);
		//������
		Set<Integer> union = new HashSet<Integer>(seta);
		
		//������
		union.addAll(setb);
		//printSet(union);
		
		//������
		inter.retainAll(setb);
		//printSet(inter);
		
		//������
		Set<Integer> diff = new HashSet<Integer>(union);
		//������ - ������
		diff.removeAll(inter);
		//printSet(diff);
		
		System.out.println(diff.size());
		
	}
	
	public static void printSet(Set<Integer> s){
		for(Object i : s) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}


/*
	������ : a1.removeAll(a2)  -> a1���� a2�� ���� ���� ��� �����Ѵ�.
	������ : a1.retainAll(a2)  -> a1���� a2�� ���� ���� ����� ��� �����Ѵ�.
	������ : a1.addAll(a2)     -> a1���� a2���� �������� ���Ѵ�. �ߺ����� 1����
*/
