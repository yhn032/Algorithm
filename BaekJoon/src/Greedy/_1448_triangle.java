package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _1448_triangle {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//가장 긴변의 길이가 나머지 두변의 합보다 작아야 한다.
		//가장 큰 삼각형을 구하고 싶다.
		//변의 길이를 내림차순으로 정렬하자 가장 큰변을 기준으로 나머지 두변이 이 값보다 큰지 확인
		//위의 삼각형의 결정조건을 만족하는 것 중에서 최대값을 구하자
		
		List<Integer> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		});
		
		Integer a1;
		Integer a2;
		Integer a3;
		int max = 0;
		for(int i=0; i<N-2;i++) {
			a1 = list.get(i);
			a2 = list.get(i+1);
			a3 = list.get(i+2);
			
			//내림차순으로 정렬했을때 가장 큰 3개로 해결이 되지 않으면, 어차피 그 밑에는 더 작은수가 있기때문에
			//두 수의 합이 가장 큰수보다 클 수 없다. 결국에 가장큰 세개로 구성했을때, 구성이 되면 그것이 최댓값이다. 
			//20 14 8 7 5 3
			//위와 같은 데이터가 있을 때, 20 14 8로도 삼각형이 구성되고, 20 14 7로도 삼각형이 구성되지만 세변의 길이가 최대인 경우이므로 전자가 정답
			if(a2+a3 > a1) {
				max = max > (a1+a2+a3) ? max : (a1+a2+a3);
			}
		}
		if(max == 0) {
			System.out.println(-1);
		} else {
			System.out.println(max);
		}
		
		for(int i : list) {
			System.out.println(i);
		}
		
	}

}

