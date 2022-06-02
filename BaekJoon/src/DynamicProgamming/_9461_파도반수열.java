package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9461_파도반수열 {
	static long [] dp_table;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		dp_table = new long[101];
		
		dp_table[1] = 1;
		dp_table[2] = 1;
		dp_table[3] = 1;
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append(dp(n)).append('\n');
		}
		System.out.println(sb);
		
	}
	//a[n] = a[n-2] + a[n-3]
	private static long dp(int n) {
		// TODO Auto-generated method stub
		if(dp_table[n] == 0) {
			dp_table[n] =  dp(n-2) + dp(n-3);
		}
		return dp_table[n];
	}

}

