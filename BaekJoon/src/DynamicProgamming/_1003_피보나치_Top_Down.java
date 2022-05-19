package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1003_피보나치_Top_Down {
	static int dp[][];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		dp = new int[41][2];
		
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		long start = System.currentTimeMillis();
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			fibonachi(n);
			sb.append(dp[n][0]).append(' ').append(dp[n][1]).append('\n');
		}
		
		System.out.println(sb);
		
		long end = System.currentTimeMillis();
		
		System.out.println((end-start)/1000.0);
	}
	private static int[] fibonachi(int n) {
		// TODO Auto-generated method stub
		
		//DP테이블에 값이 저장되어 있으면 바로 가져오고, 아니면 새로 만들어준다.
		if(dp[n][0]==0 && dp[n][1] == 0) { //n이 0이거나 1 이면 0 or 1이 한번은 호출되므로 그 값을 저장했다가 리턴하면 됨
			//Top-Down
			dp[n][0] = fibonachi(n-1)[0] + fibonachi(n-2)[0];
			dp[n][1] = fibonachi(n-1)[1] + fibonachi(n-2)[1];
			
		}
		
		return dp[n];
	}

}
