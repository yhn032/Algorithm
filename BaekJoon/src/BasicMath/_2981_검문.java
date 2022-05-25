package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2981_�˹� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int arr[]  = new int[n];
		int arr2[] = new int[n-1];
		
		//�迭 �ʱ�ȭ
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		//���� �迭�� �ּڰ��� �ִ� �����
		for(int i=0; i<n-1;i++) {
			arr2[i] = arr[i+1] - arr[i];
		}
		
		//�����ؼ� ���̰��� ���� ū�Ͱ� ���� ���� �ִ� ������� ���Ѵ�. ���� ���� ���� �ִ� ������� ���̰��� 1�ϼ��� �ְ� 1���� Ŭ ���� �ֱ� ������
		//�� ���� ���� �ִ� ������� ���ؾ� �Ѵ�. 
		Arrays.sort(arr2);
		int value = arr2[0];
		
		for(int i=1; i<arr2.length;i++) {
			value = gcd(value, arr2[i]);
		}
		//�ִ� ������� ����� ��� ������ ?
		//�ִ� ������� ��� ���ϱ�
		for(int i=2; i<=value; i++) {
			if(value%i==0) {
				sb.append(i).append(' ');
			}
		}
		
		
		System.out.println(sb);
	}
	
	
	//��Ŭ���� ȣ����
	//�ִ����� ã��
	private static int gcd(int min, int max) {
		// TODO Auto-generated method stub
		while(min != 0) {
			int r = max % min;
			max = min; 
			min = r;
		}
		return max;
	}

}

/* 
	��� ���� M���� ���� �������� ����. 
	M�� �ݵ�� �ϳ� �̻� �����Ѵ�.
	r==0���θ� ���� �� �ִٸ� M�� ������̴�. -> ���� ū�� �ִ� ������� ���ؼ� �� ���� ����� ������.
	6 /M + r
	34/M + r
	38/M + r
	
	(38-34)/M, (34-6)/M��
	38-34�� 34-6�� �ִ��������� M�� Ŭ �� ����.
	4�� 28�� �ִ������� 4��. 
	
	5 /M + r
	14/M + r
	17/M + r
	23/M + r
	83/M + r
	
	(83-23)/M, (23-17)/M, (17-14)/M, (14-5)/M
	60, 6, 3, 9�� �ִ� ������� 3
*/
