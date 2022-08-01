package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12865_����ѹ賶 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int W[] = new int[n+1];
		int V[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[][] = new int[n+1][k+1];
		
		for(int i=1; i<=n; i++) {
			
			for(int j=1; j<= k; j++) {// j-> ���� round���� ���밡���� �ִ� ���� 
				
				//i��° ���Ը� �� ���� �� ���� ���
				//���� �޸������̼� ���� �����´�.
				if(W[i] > j) {
					dp[i][j] = dp[i-1][j];
				}
				
				//i��° ���Ը� �� ���� �� �ִ� ��� -> W[i] <= j
				//�ִ� ��ġ�� ��
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
				}
			}
		}
		
		
		System.out.println(dp[n][k]);
	}
}
