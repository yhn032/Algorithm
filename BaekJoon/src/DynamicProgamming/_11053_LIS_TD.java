package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11053_LIS_TD {
	static int dp[];
	static int arr[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n];
		
		//dp�迭���� �ε��������� ���� ���� �κм����� "����"�� ����
		dp[0] = 1;
		
		//��� ������ ���ؼ� Ž���� �����ؾ� ������ ���ҿ� ���� �����ϴ� �κм����� ���� �� �ִ�.
		for(int i=0; i<n; i++) {
			LIS(i);
		}
		
		int max = 0;
		//�ִ� ���� ã�� 
		for(int i : dp) {
			max = Math.max(max, i);
		}
		System.out.println(max);
	}

	private static int LIS(int n) {
		// TODO Auto-generated method stub
		//���� Ž������ ���� �ε��� ��ġ���
		if(dp[n] == 0) {
			dp[n] = 1; //1�� �ʱ�ȭ (������ �����ϴ� ������ ���ٸ� �� �ڽ� �ϳ��� �κ� ������ �ȴ�. ex 20, 30, 10 �̷��� �־��ٸ� dp[0]=1, dp[1] = 2, dp[2]= 1)
			
			//n���� ���� index�� Ž���Ѵ�. 
			for(int i = n-1; i >=0; i--){
				if(arr[i] < arr[n]) {
					dp[n] = Math.max(dp[n], LIS(i) + 1);
				}
			}
		}
		
		return dp[n];
	}

}
