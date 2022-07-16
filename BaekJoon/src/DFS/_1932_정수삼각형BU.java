package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1932_�����ﰢ��BU {
	static int n;
	static int map[][];
	static int dp[][];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k <= i; k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		//���� �ؿ������� ���� ���ϸ鼭 �ö�;� �ϱ� ������ dp���̺� �ʱ갪�� �ʱ�ȭ ��Ų��. 
		for(int i=0; i<n; i++) {
			dp[n-1][i] = map[n-1][i];
		}
		
		
		for(int i=n-2; i>=0; i--) {
			for(int k=0; k<n-1; k++) {
				dp[i][k] = Math.max(dp[i+1][k], dp[i+1][k+1]) + map[i][k];
			}
		}
		System.out.println(dp[0][0]);
		
	}


}
//�ﰢ���� ũ�Ⱑ ũ�⶧���� �޸������̼� �ʼ�!
//ž�ٿ� ������� �����Ѵ�. 
//���� ��ġ���� �� �ڽ� ��忡 �����Ͱ� ���������� ��͸� ���� ���̸� ��������. 
//ã�Ҵٸ� -> �޸��� ���̼� �� ���� �ִٸ� �� ���� �����´�.