package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class A {
	int start_time = 0;
	int end_time = 0;
	
	
	public A(int start_time, int end_time) {
		// TODO Auto-generated constructor stub
		this.start_time = start_time;
		this.end_time = end_time;
	}
}

public class _1931 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//전체 회의의 개수
		int N = Integer.parseInt(br.readLine());
		//객체 배열
		A a[] = new A[N];
		
		//데이터 셋
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start_time = Integer.parseInt(st.nextToken());
			int end_time = Integer.parseInt(st.nextToken());
			a[i] = new A(start_time, end_time);
		}
		//정렬
		Arrays.sort(a, new Comparator<A>() {
			public int compare(A a1, A a2) {
				if(a1.end_time == a2.end_time) {
					return a1.start_time - a2.start_time;
				}else {
					return a1.end_time - a2.end_time;
				}
			//Greedy(탐욕) 	-> 매 선택의 순간에서 가장 최적의 답을 찾아나가는 과정
			}
		});
		//배치할 수 있는 전체 회의의 수
		int count = 0;
		//전체적인 흐름의 종료시간
		int end = 0;
		
		for(int i=0; i<N ; i++) {
			//처음은 현재 시점에서 가장 먼저 시작하는 회의를 찾고
			//두 번째부터는 갱신된 이전회의의 종료시간보다 큰 시작시간을 찾는다.
			if(a[i].start_time >= end) {
				count++;
				end = a[i].end_time;
			}
		}
		System.out.println(count);
	}

}
