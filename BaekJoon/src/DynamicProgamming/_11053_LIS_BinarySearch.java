package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class _11053_LIS_BinarySearch {
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
		
		//dp�迭���� ���� ���� �迭�� �����Ѵ�.
		dp[0] = arr[0];
		int lengthLIS=1;//�ʱⰪ�� �����Ƿ� 1���� ����
		
		for(int i=1; i<n; i++) {
			
			//�ʱ갪�� �־����� ���� �ʿ䰡 ����.
			//key�� dp�� �־ ���� �ȵ����� �Ǵ��ϰ����� ��
			int key = arr[i];
			
			if(dp[lengthLIS-1] < key) {
				//�������� �ϴ� ���� ���� �������� ���� ������ ũ�ٸ�,, �߰��ض�
				lengthLIS++;
				dp[lengthLIS-1] = key;
			}else { 
				//�������� �ϴ� ���� ���� �������� ���� ������ �۴ٸ� 
				//dp�� �ִ� ���߿��� �������� �ϴ� ������ ���̰� �ּ��� ���� ã�Ƽ� ���� �ٲ۴�.�׷��� ���� ������� ���� �� ���̿� �� �ٸ� ���� �����鼭 ���̸� �ø� �� �ִ�.
				//�̺�Ž������ lowerbound�� ã�´�. 
				
				int min = 0; 
				int max = lengthLIS;
				
				while(min < max) {
					int mid = (min+max)/2;
					
					if(dp[mid] < key) {
						min = mid+1;
					}else {
						max = mid;
					}
				}
				
				dp[min] = key;
				
			}
		}
		
		System.out.println(lengthLIS);
		
	}

}
