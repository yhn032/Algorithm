package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559_temp_������ {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		//�µ� �������� ���� 
		int N = Integer.parseInt(st.nextToken());
		
		//���������� ���ؾ� �ϴ� ��
		int K = Integer.parseInt(st.nextToken());
		
		//����Ƚ�� �Ϲ�ȭ -> N - K + 1
		
		st = new StringTokenizer(br.readLine());
		int A[] = new int[N+1];
		for(int i=1; i<N+1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			//System.out.print(A[i] + " ");
		}
		//System.out.println();
		int S[] = new int[N+1];
		//S[n] �����迭 A�� 1~n������ ��. S[0] = 0; 
		for(int i = 1; i< N+1; i++) {
			S[i] = S[i-1] + A[i];
			//System.out.print(S[i] + " ");
		}
		
		//�������� ���ؼ� ���ο� �迭�� ����Ʈ�� �ϱ�
		//K=2��� 
		//	1-2, 2-3, 3-4, 4-5, 5-6, 6-7, 7-8, 8-9, 9-10
		//K=5��� 
		/*
			1-5, 2-6, 3-7, 4-8, 5-9, 6-10 �� ���� ���ؼ� �迭�� �����ǵ� K�� ��� ������ Ȱ���Ұų�? 
			
			S[n] -> 1���� n������ ��
			
		*/
		//�ݺ�Ƚ���� N-K+1�̹Ƿ� �ϳ� �� ũ�� ����(0���� ����)
		int SS[] = new int[N-K+2];
		
		for(int i=1; i<=N-K+1; i++) {
			//���� �迭�� 1~5���� ���� ���ϱ� 
			//SS[1] = S[K]-S[0];
			//2-6���� ���� ���ϱ� 
			//SS[6] - SS[1]
			SS[i] = S[i+K-1] - S[i-1];
		}
		
		//�µ��� ���������� ������ ��츦 ���
		int max = SS[1];
		for(int i=1; i<SS.length; i++) {
			max = max < SS[i] ? SS[i] : max;
		}
		System.out.println(max);
		
 	}

}

