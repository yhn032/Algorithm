package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2343_��Ÿ���� {
	static int blueray[];
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		blueray = new int[N];
		
		int min = 0; 
		int max = 0; 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			blueray[i] = Integer.parseInt(st.nextToken());
			
			//������ �򰥸��� ���� �ִ��� ���ϴ� �����̴�. Ž���� �������� ���ϴ� ���ϻ�
			min = min < blueray[i] ? blueray[i] : min; 
			max += blueray[i];
		}
		
		//����Ž�� ���� 
		while(min < max) {
			
			int mid = (min+max)/2;
			
			if(cntBlue(mid) > M) {
				//��緹���� ũ�Ⱑ mid�� ��, ����� �� �̾� �ּ� ��緹�� ������ M���� ũ�ٸ�, 
				//��緹�̰� �� �ʿ��ϴٴ� ���̴�. -> ��緹���� ũ�⸦ Ű���� -> ���� ã�� ���� mid���� �����ʿ� ���� 
				min = mid+1;
			}else {
				//��緹���� ũ�Ⱑ mid�� ��, ����� �� �ִ� �ּ� ��緹�� ������ M���� �۰ų� ���ٸ�
				//��緹�̰� �� �ʿ��ϴٴ� ���̴�. -> ��緹���� ũ�⸦ �ٿ��� -> ���� ã�� ���� mid���� ���ʿ� ����
				max = mid;
			}
			
		}
		
		System.out.println(min);
	}

	private static int cntBlue(int mid) {
		// TODO Auto-generated method stub
		int sum = 0; 
		int count=0;
		
		for(int i=0; i<N; i++) {
			if(sum + blueray[i] >  mid) { //���ϱ� ���� �˻� ��ģ�ٸ� ��ġ�� �������� ���� ���� �ϳ��� ��緹�̿� ��� �ʱ�ȭ
				count++;
				sum = 0;
			}
			sum += blueray[i];
		}
		
		//�迭�� �ִ� ���� ��� ���ߴµ� sum�� ���� �����ִٸ� �ʰ��Ȱ��̹Ƿ� �ϳ��� ��緹�̰� �� �ʿ��ϴ�. 
		if(sum != 0) count++;
		
		return count;
	}

}


/*
	Ž�� ��� -> ��緹���� ũ�� �� �ּ� 
	��� M���� ��緹���� ũ��(����� ��ȭ���� ũ��)�� ����.
	
	������ ���� �ٲ�� �ȵ� �Ժη� ������ ������ �� ����. �׷��ٸ� Ž���� �ε����� ��� ã��? 
	
	
	������ ���̸� �������� Ž���Ѵ� .
	�ּ� - ���� �� ������ ���� 
	�ִ� - ��� ���� ������ ��
	�� �����ȿ��� ��� ���Ǹ� ������ �� �ְ� �ϴ� ��緹�� ������ �ּڰ��� ã�ƶ�.
	
*/
