package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559_temp_��ø�ݺ� {
	static int N, K;
	static int temp[];
	static int gap = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		temp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		//�µ� �迭 �ʱ�ȭ
		for(int i=0; i<N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		//�� �����տ� ���ؼ� sum���� ���ϰ�, �װ��� �ִ񰩰� ���Ͽ� ū ���� �����Ѵ�. 
		//�� ������ ���� ��츦 ����ؼ� �ʱⰪ�� 0�� �ƴ� �ڷ������� ���� ���� ������ �����Ѵ�. 
		for(int i=0; i<N-K+1; i++) {
			int sum = 0; 
			for(int j=i; j<i+K; j++) {
				sum += temp[j];
			}
			gap = gap > sum ? gap : sum;
		}
		System.out.println(gap);
	}

}
