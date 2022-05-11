package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559_temp_중첩반복 {
	static int N, K;
	static int temp[];
	static int gap = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		temp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		//온도 배열 초기화
		for(int i=0; i<N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		//각 구간합에 대해서 sum값을 구하고, 그값을 최댓갑과 비교하여 큰 값을 저장한다. 
		//단 음수만 있을 경우를 대비해서 초기값을 0이 아닌 자료형에서 가장 작은 값으로 설정한다. 
		for(int i=0; i<N-K+1; i++) {
			int sum = 0; 
			for(int j=i; j<i+K; j++) {
				sum += temp[j];
			}
			gap = gap > sum ? gap : sum;
		}
		System.out.println(gap);
	}

}
