package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11659_구간합1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//구간합 구하는 공식
		//S[i] = S[i-1] + A[i]
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//수의 개수
		int N = Integer.parseInt(st.nextToken());
		//합을 구해야 하는 횟수
		int M = Integer.parseInt(st.nextToken());
		
		//최악의 경우 : 100,000개의 수를 100,000번 더하기 -> 1,000,000,000,000 int형을 넘어서기에 long으로 해야함
		long[] S = new long[N+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i=1 ; i<=N; i++) {
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
			//System.out.print(S[i-1]+ " ");
		}
		
		for(int q=0; q<M;q++) {
			st=new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(S[j] - S[i-1]).append('\n');
		}
		
		System.out.println(sb);
	}

}
