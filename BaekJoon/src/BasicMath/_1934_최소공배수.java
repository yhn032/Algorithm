package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1934_�ּҰ���� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//�ִ�����
			int N = eucd(Math.max(a, b), Math.min(a, b));
			
			//�ּҰ����
			int M = a * (b / N);
			
			sb.append(M).append('\n');
		}
		
		
		System.out.println(sb);
			
	}

	private static int eucd(int max, int min) {
		// TODO Auto-generated method stub
		int r = max % min;
		
		if(r == 0) {
			return min;
		} else {
			return eucd(min, r);
		}
	}

}

/*
	��Ŭ���� ȣ���� : �� ���� ���� �־����� ��, �ִ������� ���ϴ� �˰���
	�� ���� �� A, B�� �����ϰ�, A�� B�� ���� �������� C��� �ϰڽ��ϴ�. (A > B)
	�̶�, A�� B�� �ִ������� B�� C�� �ִ������� �����ϴ�.
	
	EX> �� ���� �� 72, 42 �߿��� ū ���� ���� ������ ������ ����
	1. 72 % 42 = 30(C)
	�տ��� ���� ���� �ٽ� �������� ������.
	2. 42 % 30 = 12(C)
	��� �ݺ��մϴ�. 
	3. 30 % 12 = 6
	4. 12 % 6  = 0
	�������� 0�� �Ǿ��� ��, ���� �� 6�� �ִ� ������� �ȴ�. 


	�ּҰ���� : �ִ� ����� * (��1/�ִ�����) * (��2/�ִ�����)


*/