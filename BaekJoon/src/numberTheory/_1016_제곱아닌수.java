package numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1016_�����ƴѼ� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		//�Ҽ� ��� �������� �������� ���� ���� �����ϱ� 
		boolean[] check = new boolean[(int)(max-min+1)];
		
		for(long i=2; max >= i*i; i++) {//2�� ���������� Max���� �۰ų� ���� ������ �ݺ�
			long pow = i*i;
			long start_idx = min/pow;
			
			if(min%pow != 0) {
				start_idx++;//�������� �ִٸ� 1�� ���ؾ� min���� ū ������ Ž���� ������ �� �ִ�.
			}
			for(long k = start_idx; pow*k <= max; k++) {
				check[(int)((k*pow)-min)] = true;
			}
		}
		
		int cnt = 0;
		for(int i=0; i<=max-min; i++) {
			if(!check[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}

