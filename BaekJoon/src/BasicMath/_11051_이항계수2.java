package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11051_���װ��2 {
	static int f[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//factorial���� ������ �迭 n >= k
		//1������ 1!,,, n������ n!�� ����
		f = new int[n+1][k+1];
		
		System.out.println(dfs(n, k));
		
	}

	private static int dfs(int n, int k) {
		// TODO Auto-generated method stub
		if(f[n][k] > 0) {//�⺻�� 0�� �ƴ϶�� �޸������̼��� �Ǿ��ٴ� ���̹Ƿ� ����Ȱ� ���
			return f[n][k];
		}else if(n==k || k==0){//�и� 0�̵Ǵ� ���
			return 1;
			
		}
		
		//������ ������ ��ⷯ �й��Ģ�� �Ұ����ϱ� ������ �ٲپ �ؾ��Ѵ�.
		//�Ľ�Į�� ��Ģ;
		//C(n,k) + C(n, k+1) = C(n+1, k+1);
		return f[n][k] = (dfs(n-1,k-1) + dfs(n-1, k))%10007;
	}

}
