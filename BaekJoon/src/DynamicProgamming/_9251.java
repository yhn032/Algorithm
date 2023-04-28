package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _9251 {
	
	static char[] str1, str2;
	static Integer[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		
		dp = new Integer[str1.length][str2.length];
		
		System.out.println(LCS(str1.length-1, str2.length-1));
	}

	private static Integer LCS(int x, int y) {
		// TODO Auto-generated method stub
		if(x == -1 || y == -1) return 0;
		
		if(dp[x][y] == null) {
			dp[x][y] = 0;
			
			if(str1[x] == str2[y]) {
				dp[x][y] = LCS(x-1, y-1) + 1;
			} else {
				dp[x][y] = Math.max(LCS(x-1, y), LCS(x, y-1));
			}
		}
		return dp[x][y];
	}
}
