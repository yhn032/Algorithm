package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2579_��ܿ�����TD {
	static int []step;
	static Integer []dp;
	static int n;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		step = new int[n+1];
		dp = new Integer[n+1];

		for(int i=1; i<=n; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		
		//ù ��° ����� �� �ʱ�ȭ
		dp[0] = 0;//�������� ���� ����
		dp[1] = step[1];
		
		if(n>=2) {
			dp[2] = step[1] + step[2]; 
		}
		
		System.out.println(dfs(n));
	}
	private static int dfs(int depth) {
		// TODO Auto-generated method stub
		
		//���ӵ� ������ ����� ���� �� ����. 
		//������ ����� �ݵ�� ��ƾ� �ϹǷ�, ������ ����� ��Ҵٴ� ���� �Ͽ� 
		//��������ܺ��� top-down����
		//���� ��ܿ��� �ö�� ��� ����, 2��� �Ʒ����� �ö�� ������ �߿��� �ִ��� ���ؾ� �Ѵ� .
		//�ٵ� �̸� ���� depth-1�� depth-2�� ��͸� ȣ���ϸ� ��� ��ܿ� ���� �޸������̼��� �ϱ� ������ 
		//���ӵ� ������ ����� ��� ������ �ȵȴٴ� ���ǿ� ���� �ȴ�. 
		//��� ȣ�� �ؾ� �Ѵ� ... 
		
		
		
		if(dp[depth] == null) {
			dp[depth] = step[depth] + Math.max(dfs(depth-3)+step[depth-1],dfs(depth-2));
		}
		
		return dp[depth];
	}

}
