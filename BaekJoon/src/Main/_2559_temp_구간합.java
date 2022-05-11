package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559_temp_구간합 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		//온도 데이터의 개수 
		int N = Integer.parseInt(st.nextToken());
		
		//연속적으로 구해야 하는 값
		int K = Integer.parseInt(st.nextToken());
		
		//연산횟수 일반화 -> N - K + 1
		
		st = new StringTokenizer(br.readLine());
		int A[] = new int[N+1];
		for(int i=1; i<N+1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			//System.out.print(A[i] + " ");
		}
		//System.out.println();
		int S[] = new int[N+1];
		//S[n] 원본배열 A의 1~n까지의 합. S[0] = 0; 
		for(int i = 1; i< N+1; i++) {
			S[i] = S[i-1] + A[i];
			//System.out.print(S[i] + " ");
		}
		
		//구간합을 구해서 새로운 배열에 리스트업 하기
		//K=2라면 
		//	1-2, 2-3, 3-4, 4-5, 5-6, 6-7, 7-8, 8-9, 9-10
		//K=5라면 
		/*
			1-5, 2-6, 3-7, 4-8, 5-9, 6-10 이 합을 구해서 배열에 넣을건데 K를 어떻게 적절히 활용할거냐? 
			
			S[n] -> 1부터 n까지의 합
			
		*/
		//반복횟수가 N-K+1이므로 하나 더 크게 생성(0번지 버림)
		int SS[] = new int[N-K+2];
		
		for(int i=1; i<=N-K+1; i++) {
			//원본 배열의 1~5까지 합을 구하기 
			//SS[1] = S[K]-S[0];
			//2-6까지 합을 구하기 
			//SS[6] - SS[1]
			SS[i] = S[i+K-1] - S[i-1];
		}
		
		//온도가 음수만으로 구성된 경우를 대비
		int max = SS[1];
		for(int i=1; i<SS.length; i++) {
			max = max < SS[i] ? SS[i] : max;
		}
		System.out.println(max);
		
 	}

}

