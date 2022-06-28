package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2156_�����ֽý� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int wine[] = new int[n+1];
		int dp[]   = new int[n+1];
		
		
		for(int i=1; i<=n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		//��ƴ�� -> �ʱ갪 �ʱ�ȭ�ϱ�
		dp[1] = wine[1];
		
		if(n > 1) { //n=1�϶�, dp[2]�� ä����� �ϸ� outof index�����߻�
			dp[2] = wine[1] + wine[2];
		}
		
		for(int i=3; i<=n; i++) {
			//n-1���� ����Ǽ��� ã�� �Ǹ�, ��� ����� ���� ���ؼ� 
			//-1�� ����Ǽ��� ���ϸ鼭 ���ӵ� ������ ���� ���ϱ� ������ �ִ� �ι��� ���ӵ� ����� ���� ���ϱ� ���ؼ���
			//n-2�� n-3�� �����ؾ� �Ѵ�.
			dp[i] = Math.max( dp[i-1] , Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1]+ wine[i]));
			
			//i�� ������ �Դ´ٰ� ���� 
			//�ٷ� ������ ������ i-1�� ������ �Դ� ���� �Ʒ� ����� �ִ񰪰� ���ؼ� �ִ��� ã�´�.
			//i-2�� ������ ���ð� i-1�� �ǳʶٴ� ��� vs i-3�� ������ ���ð�, i-2�� ������ ���ð� i�� ������ ���� ��� -> �ִ�
		}
			
		
		System.out.println(dp[n]);
	}

}

/*
	���� ������ ����. 
	���ӵ� ������ ���� �� ����. 
	n <= 2�̶�� �׳� ���� ���ϸ� �ȴ�.
	
	n >= 3�̶�� 
*/
