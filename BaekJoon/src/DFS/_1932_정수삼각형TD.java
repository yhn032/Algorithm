package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1932_�����ﰢ��TD {
	static int n;
	static int map[][];
	static int dp[][];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated smethod stub
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
		
		System.out.println(dfs(0,0));
		
	}

	private static int dfs(int depth, int idx) {
		// TODO Auto-generated method stub
		if(depth == n-1) return dp[depth][idx];
		
		
		//�޸������̼�
		if(dp[depth][idx] == 0) {//���� Ž������ ���� ���̶�� 
			dp[depth][idx] = Math.max(dfs(depth+1,idx),dfs(depth+1,idx+1)) + map[depth][idx];
		}
		
		return dp[depth][idx];
	}

}
//�ﰢ���� ũ�Ⱑ ũ�⶧���� �޸������̼� �ʼ�!
//ž�ٿ� ������� �����Ѵ�. 
//���� ��ġ���� �� �ڽ� ��忡 �����Ͱ� ���������� ��͸� ���� ���̸� ��������. 
//ã�Ҵٸ� -> �޸��� ���̼� �� ���� �ִٸ� �� ���� �����´�.