package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2294_bottomup {
	static int N, K;
	static int INF = 20000000;
	static int dp[][];
	static int cost[];
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		cost = new int[N+1];
		dp = new int[N+1][K+1];
		//점화식은 동일하지만 
		//dp[n][k] => n번동전까지 사용하여 k를 만드는 최소 경우의 수
		for(int [] i : dp) {
			Arrays.fill(i, INF);
		}
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		
		for(int i=0; i<N; i++) {
			dp[i][0] = 0;
			for(int j=0; j<=K; j++) {
				//
				dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
				int temp = j + cost[i];
				if(temp <= K) dp[i][temp] = Math.min(dp[i][temp], dp[i][j]+1);
			}
		}
		
		if(dp[N-1][K] == INF) System.out.println(-1);
		else System.out.println(dp[N-1][K]);
		
		//System.out.println(min==INF ? -1 : min);
	}
}
