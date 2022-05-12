package numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1456_���ǼҼ� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long arr[] = new long[10000001]; 
		//10^14�� ������ �Ҽ��� N������ ���ǼҼ���� �߱⶧����, 10^7�� ���� ���� �Ҽ��� ���Ѵ�.
		//������ �ִ�� ��� ���ؼ� ������ �ּҷ� �ؾ��ϱ� �����̴�.
		for(int i=2;i<arr.length;i++) {
			arr[i] = i;
		}
		
		//�Ҽ����ϱ�
		for(int i=2; i<Math.sqrt(arr.length);i++) {
			if(arr[i] == 0) continue;
			
			for(int k=i+i; k<arr.length; k+=i) {
				arr[k] = 0;
			}
		}
		
		int count = 0;
		for(int i=2; i < arr.length; i++) {
			if(arr[i] != 0) {
				long temp = arr[i];
				
				while(arr[i]*1.0 <= B*1.0/temp) {//�� �Ҽ��� N�������� �ִ������ ���� �ʴ� ������ ���ϴµ� �����÷ο찡 ���⶧���� ���������� �����Ѵ�. 
					if(arr[i]*1.0 >= A*1.0/temp) {
						count++;
					}
					//�������� ���� ���ϴ� ���̹Ƿ� ����ؼ� ���� ���� ������� ��
					temp *= arr[i];
				}
			}
		}
		System.out.println(count);
	}

}
