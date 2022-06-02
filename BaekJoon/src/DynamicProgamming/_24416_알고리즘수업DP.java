package DynamicProgamming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24416_알고리즘수업DP {
	static int cnt_dfs=0;
	static int cnt_dp=0;
	static int dp_table[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int a = dfs(n);
		dp_table = new int[n+1];
		dp_table[1] = 1;
		dp_table[2] = 1;
		int b = dp(n);
		
		System.out.print(cnt_dfs);
		System.out.print(" "+cnt_dp);
	}
	private static int dp(int n) {
		// TODO Auto-generated method stub
		if(dp_table[n] == 0) {
			cnt_dp++;
			dp_table[n] = dp(n-1) + dp(n-2);
		}
		
		return dp_table[n];
	}
	
	private static int dfs(int n) {
		// TODO Auto-generated method stub
		if(n==1 || n==2) {
			cnt_dfs++;
			return 1;
		}
		
		return dfs(n-1) + dfs(n-2);
	}

}

