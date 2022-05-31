package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1676_���丮��0�ǰ��� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(countZero(n));
	}

	private static int countZero(int n) {
		// TODO Auto-generated method stub
		int cnt_5=0;
		int cnt_2=0;
		
		
		
		for(int i= 1; i<=n; i++) {
			int temp = i;
			
			while(temp%2==0) {
				cnt_2++;
				temp /= 2;
			}
			
			while(temp%5==0) {
				cnt_5++;
				temp /= 5;
			}
		}
		return Math.min(cnt_5, cnt_2);
	}

}


/*
	������ 0�� �������� �ݵ�� 2*5�� ���� �����ؾ� �Ѵ�.
	n~1������ ���߿��� ���μ����ظ� ���� ��, 2�� ������ 5�� �������� �����״� 5�� ������ ���ϸ� �ȴ�.
*/
