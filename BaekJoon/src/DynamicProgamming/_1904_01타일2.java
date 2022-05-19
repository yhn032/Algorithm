package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1904_01Ÿ��2 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//(A+B)%C == ((A%C)+(B%C))%C
		
		//Bottom-up ����� ����
		System.out.println(dp(n));
	}
	
	private static int dp(int i) {
		// TODO Auto-generated method stub
			
		if(i == 1) return 1;
		if(i == 2) return 2;
		
		
		int val1 = 1;
		int val2 = 2;
		int sum  = 0;
		
		for(int k=3; k<=i; k++) {
			sum = (val1 + val2)%15746; //n=3�϶����� ä��鼭 up�ϱ� ���� i�� 10�̶�� 3~10���� 8���� �ݺ��ؾ���
			val1 = val2;
			val2 = sum;
		}
		//val1�� ��ȭ�Ŀ��� N[i-2];
		//val2�� ��ȭ�Ŀ��� N[i-1]�̴�. 
		//���� ���� �ݺ� ÷�ڿ��� ��ȭ���� �̿��ؼ� ���� ���ߴٸ� ��ƴ���� ��͸� ������� �ʰ� �ݺ����� �ϱ� ������ val1�� ���� val2�� val2�� sum�� ���� �־������ν� ��������� ���� �ݺ������� ��Ȯ�� ���� ������ 
		//�Ǹ鼭 �ذ�ȴ�.
		
		return sum;
	}

}

/*
	N = 1	1		1
	N = 2	11, 00	2
	N = 3   111, 100, 001	3
	N = 4	0000, 0011, 1001, 1100, 1111	5
	N = 5	11111, 11100, 11001, 10011, 00111, 10000, 00001, 00100	8
	
	
	
	N[i] = N�������� Ÿ���� �־��� ���ǿ� �´� ��� ���� ���� ���
	
	
	�Ǻ���ġ�� ���� ����
	N[i] = N[i-1] + N[i-2]
	
	N[2] = 2
	N[1] = 1
*/
