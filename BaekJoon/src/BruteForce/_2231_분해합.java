package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2231_������ {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1<= n <= 1,000,000
		int n = Integer.parseInt(br.readLine());
		
		
		int sum=0;
		for(int i=1; i<=n; i++) {
			String str = String.valueOf(i);
			
			if(i < 10) { //���ڸ����� ������ ���� x
				int a = str.charAt(0)-'0';
				if(a+i == n) {
					sum = i;
					break;
				}
			}else if(i<100){ //�� �ڸ� ��
				int a = str.charAt(1)-'0';
				int b = str.charAt(0)-'0';
				if(a+b+i == n) {
					sum = i;
					break;
				}
			}else if(i<1000) { //���ڸ���
				int a = str.charAt(2)-'0';
				int b = str.charAt(1)-'0';
				int c = str.charAt(0)-'0';
				if(a+b+c+i == n) {
					sum = i;
					break;
				}
			}else if(i<10000) { //���ڸ���
				int a = str.charAt(3)-'0';
				int b = str.charAt(2)-'0';
				int c = str.charAt(1)-'0';
				int d = str.charAt(0)-'0';
				if(a+b+c+d+i == n) {
					sum = i;
					break;
				}
			}else if(i<100000) { //�ټ��ڸ���
				int a = str.charAt(4)-'0';
				int b = str.charAt(3)-'0';
				int c = str.charAt(2)-'0';
				int d = str.charAt(1)-'0';
				int e = str.charAt(0)-'0';
				if(a+b+c+d+e+i == n) {
					sum = i;
					break;
				}
			}else if(i<1000000) { //�����ڸ���
				int a = str.charAt(5)-'0';
				int b = str.charAt(4)-'0';
				int c = str.charAt(3)-'0';
				int d = str.charAt(2)-'0';
				int e = str.charAt(1)-'0';
				int f = str.charAt(0)-'0';
				if(a+b+c+d+e+f+i == n) {
					sum = i;
					break;
				}
			}
		}
		System.out.println(sum == 0 ? 0 : sum);
	}

}

/*
	245�� �������� 245 + 2 + 4 + 5 = 256
	256�� �����ڴ� 245
	
	���� Ž��
	� ���� �����ڰ� �������� �ְ�, ������ ���� �� ����
	���� ���� �����ڸ� ���ض�. �����ڰ� ���� ��� 0�� ���
*/
