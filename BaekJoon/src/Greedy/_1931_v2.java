package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class _1931_v2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//전체 회의의 개수
		int N = Integer.parseInt(br.readLine());
		//2차원 배열
		int a[][] = new int[N][2];
		
		//데이터 셋
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start_time = Integer.parseInt(st.nextToken());
			int end_time = Integer.parseInt(st.nextToken());
			//각 행의 0열 시작 시간
			a[i][0] = start_time;
			//각 행의 1열 종료 시간
			a[i][1] = end_time;
		}
		//정렬
		Arrays.sort(a, new Comparator<int []>() {
			//2차원 배열을 1차원배열의 타입으로 저장했으니, 매개변수 o1과 o2는 각 행의 대한 1차원 배열을 나타낸다. 
			//ㄴ> 2차원 배열의 각 행을 자료형으로 넘기는 것이다.
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}else {
					return o1[1] - o2[1];
				}
			}
		});
		
		//배치할 수 있는 전체 회의의 수
		int count = 0;
		//전체적인 흐름의 종료시간
		int end = 0;
		
		for(int i=0; i<N ; i++) {
			//처음은 현재 시점에서 가장 먼저 시작하는 회의를 찾고
			//두 번째부터는 갱신된 이전회의의 종료시간보다 큰 시작시간을 찾는다.
			if(a[i][0] >= end) {
				count++;
				end = a[i][1];
			}
		}
		System.out.println(count);
	}

}
