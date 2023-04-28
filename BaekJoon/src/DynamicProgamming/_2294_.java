package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2294_ {
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
		
		for(int [] i : dp) {
			Arrays.fill(i, -1);
		}
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		int min = coin(0, K);
		
		System.out.println(min==INF ? -1 : min);
	}


	private static int coin(int n, int k) {
		// TODO Auto-generated method stub
		if(n==N) return k==0 ? 0 : INF;
		if(dp[n][k] != -1) return dp[n][k];
		
		int res = coin(n+1, k);
		if(k >= cost[n]) res =  Math.min(res, coin(n, k-cost[n])+1);
		
		dp[n][k] = res;
		
		return res;
	}
}
