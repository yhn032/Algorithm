package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1010_�ٸ����� {
	static int dp[][] = new int[30][30];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			
			//�� ���� ����Ʈ
			int n = Integer.parseInt(st.nextToken());
			//�� ���� ����Ʈ
			int m = Integer.parseInt(st.nextToken());
			
			sb.append(bridge(m, n)).append('\n'); 
			
		}
		
		System.out.println(sb);
	}
	

	private static int bridge(int n, int r) {
		// TODO Auto-generated method stub
		if(dp[n][r] > 0) return dp[n][r];
		
		//0! == 1
		if(n == r || r == 0) return dp[n][r] = 1;
		
		
		return dp[n][r] = bridge(n-1,r-1) + bridge(n-1,r);
	}

}


//��͸� ���� �湮 üũ �ϸ� �� �� ������ ���̳����� ����ϳ�?
//M�� �ִ� ���� 30�ε�?
//������ ���� �����ϸ� �ǳ� ;; 
// (��, ��) -> ��ġ�� �ȵǱ� ������ �����ϴ� ������ ����ؾ� �Ѵ�.