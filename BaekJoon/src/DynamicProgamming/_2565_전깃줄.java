package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2565_������ {
	static int dp[] = new int[501];
	static int arr[] = new int[501];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//����� �������� ���� 
		int n = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a] = b;
		}
		
		//����� �ѹ��� LIS�� ���ϰ� ��ü �����ٿ��� ���� �ּҰ��̴�. ����
		
		for(int i=2; i<arr.length; i++) {
			if(arr[i] == 0) continue;
			LIS(i);
		}
		
		int max = -1;
		for(int i: dp) {
			if(i == 0) continue;
			max = Math.max(max, i);
		}
		System.out.println(n-max);
	}

	private static int LIS(int idx) {
		// TODO Auto-generated method stub
		if(dp[idx] == 0) {
			dp[idx] = 1;
			
			for(int i=idx-1; i>=1; i--) {
				if(arr[i] == 0) continue;
				if(arr[i] < arr[idx]) {
					dp[idx] = Math.max(dp[idx], LIS(i)+1);
				}
			}
			
		}
		
		return dp[idx];
	}
}
