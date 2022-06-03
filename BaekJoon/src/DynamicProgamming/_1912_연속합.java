package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1912_������ {
	static int dp_table[];
	static int arr[];
	static int max;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		arr = new int[n];
		dp_table = new int[n];

		st = new StringTokenizer(br.readLine());
		// dp_table[n] -> n��° ��ұ����� �����հ� n��° ����� ��, �� ���� �ִ��� �����Ѵ�.

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 0��° ������ ���� �������� �����Ƿ� �迭�� �ʱ갪���� �ʱ�ȭ �Ѵ�. �ִ񰪵� ��������
		dp_table[0] = arr[0];
		max = arr[0];
		
		for(int i=1; i<n; i++) {
			dp_table[i] = Math.max(dp_table[i-1] + arr[i], arr[i]);
			
			max = Math.max(max, dp_table[i]);
		}

		System.out.println(max);
	}

	/*
	 * private static int dp(int n) { // TODO Auto-generated method stub
	 * 
	 * if(dp_table[n] == 0) { dp_table[n] = Math.max(dp(n-1) + arr[n], arr[n]);
	 * 
	 * max = Math.max(dp_table[n], max); }
	 * 
	 * return dp_table[n];
	 * 
	 * 
	 * for(int i=0; i<=n ; i++) {
	 * 
	 * } }
	 */

}
