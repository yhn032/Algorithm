package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1300_K��°�� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//�迭�� ũ�� n*n 
		int n = Integer.parseInt(br.readLine());
		
		//1���� �迭���� k��°��
		int k = Integer.parseInt(br.readLine());
		
		
		//B[K] = x�� �����ϴ� K�� ã�� ���� 
		//B[K] -> x���� �۰ų� ���� ���� K�� �ִ�. 
		
		long min = 1;//i*j�� �ּڰ��� 1
		long max = k;//x���� �۰ų� ���� ���� k������ ���� �� ����
		
		while(min < max) {
			long mid = (min+max)/2;
			int count=0; //x���� �۰ų� ���� ������ k�� ���߿��� �ִ븦 ���ض� �ȴ�. 
			
			//�� ���� ���Ұ����� n���� ������ ����. n*n�迭�̱� �����̴�.
			
			for(int i=1; i<=n; i++) {
				count += Math.min(mid/i, n);
			}
			
			//������ ��x(mid)���� ���� ���� B[K]���� ���ٸ�
			if(k <= count) {
				max = mid;
			}else {
				min = mid+1;
			}
					
			
		}
		System.out.println(min);
	}

}
