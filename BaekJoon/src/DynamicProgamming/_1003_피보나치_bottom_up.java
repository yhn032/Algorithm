package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1003_피보나치_bottom_up {
	static int dp[][];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		dp = new int[41][2];
		
		for(int i=0; i<41; i++) {
			for(int j=0; j<2; j++) {
				dp[i][j] = -1;
			}
		}
		
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		long start = System.currentTimeMillis();
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			
			if(dp[n][0] == -1 && dp[n][1] == -1) {//값이 있으면 바로 추가, 없으면 DP테이블 만들어주기
				
				for(int i=2; i<=n; i++) {
					dp[i][0] = dp[i-1][0] + dp[i-2][0];
					dp[i][1] = dp[i-1][1] + dp[i-2][1];
				}
			}
			
			sb.append(dp[n][0]).append(' ').append(dp[n][1]).append('\n');
			
		}
		
		System.out.println(sb);
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0);
	}

}
