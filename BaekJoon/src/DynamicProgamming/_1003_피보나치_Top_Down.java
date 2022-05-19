package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1003_�Ǻ���ġ_Top_Down {
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
		
		//DP���̺� ���� ����Ǿ� ������ �ٷ� ��������, �ƴϸ� ���� ������ش�.
		if(dp[n][0]==0 && dp[n][1] == 0) { //n�� 0�̰ų� 1 �̸� 0 or 1�� �ѹ��� ȣ��ǹǷ� �� ���� �����ߴٰ� �����ϸ� ��
			//Top-Down
			dp[n][0] = fibonachi(n-1)[0] + fibonachi(n-2)[0];
			dp[n][1] = fibonachi(n-1)[1] + fibonachi(n-2)[1];
			
		}
		
		return dp[n];
	}

}
