package MapSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1269_대칭차집합 {

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
		
		//교집합
		Set<Integer> inter = new HashSet<Integer>(seta);
		//합집합
		Set<Integer> union = new HashSet<Integer>(seta);
		
		//합집합
		union.addAll(setb);
		//printSet(union);
		
		//교집합
		inter.retainAll(setb);
		//printSet(inter);
		
		//차집합
		Set<Integer> diff = new HashSet<Integer>(union);
		//합집합 - 교집합
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
	차집합 : a1.removeAll(a2)  -> a1에서 a2와 같은 값을 모두 제거한다.
	교집합 : a1.retainAll(a2)  -> a1에서 a2와 같은 값만 남기고 모두 제거한다.
	합집합 : a1.addAll(a2)     -> a1에서 a2와의 합집합을 구한다. 중복값은 1번만
*/
