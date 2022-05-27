package numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1929_�Ҽ����ϱ� {
	
	//�Ϲ����� �Ҽ� ���ϱ� ���
	/*
		2�̻��� �ڿ����� �ڱ� �ڽź��� ���� ���� ������ ��, �������� 0�� �ƴ� ���� ã���ϴ�. 
		������ �� ���� �ִ� ������ 1,000,000�̹Ƿ� �ð� �ʰ��� �� �� �ִ�. 
		�ϴ� �񱳸� ���� �ð��ʰ��� ������ ������ Ǯ��ڴ�. 
	*/
	
	//�ð��ʰ��� ���� �Ϲ����� ���
	/*
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		OUT:
		for(int i=M; i<N;i++) {
			for(int k=2; k<i;k++) {
				if(i%k == 0) {
					continue OUT; //�߰����� �ʰ� �������� �Ѿ
				}
			}	
			sb.append(i).append(' ');
		}
		
		System.out.println(sb);
		
	}
	*/
	
	//�ð� ���⵵�� ���� ��� 2
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N+1];
		
		//0������ ������ 1�� ������ �Ҽ��� �ƴϴϱ� ����
		for(int i=2;i<=N;i++) {
			arr[i] = i;
		}
		
		//N�� ������ ������ Ž���ϸ� �ȴ�. 
		//N = a*a��� ������ ��, a�� N�� �����ٺ��� Ŭ �� ����. 
		//���� ��� 16�� �������� �Ҽ��� ���� ��, 16 = 4 * 4�� �̷����� 16���� ���� ���ڴ� �׻� 4���� ���� ����� ���Եȴ�.
		//4���� ū ����� 4���� ���� ���� ����� ���� �� �ֽ��ϴ�.
		for(int i=2;i<=Math.sqrt(N);i++) {
			if(arr[i]==0) continue;
			
			for(int k = i+i; k<=N; k+=i ) {//k�� ����� ����� �̷������� ���� �ݺ����� ���� ����� �ܺ� �ݺ����� ������ ���� �ǳ� �ٸ鼭 �ð����⵵ ���̱� ����
				arr[k] = 0;
			}
		}
		
		/*
		 * for(int i=M;i<=N;i++){ if(arr[i] != 0) { System.out.print(i + " "); } }
		 */
		
		for(int i : arr) {
			if(i==0) continue;
			System.out.print(i + " ");
		}
		
	}
	
	

}
