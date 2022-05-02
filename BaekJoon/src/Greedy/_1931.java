package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class A {
	int start_time = 0;
	int end_time = 0;
	
	
	public A(int start_time, int end_time) {
		// TODO Auto-generated constructor stub
		this.start_time = start_time;
		this.end_time = end_time;
	}
}

public class _1931 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//��ü ȸ���� ����
		int N = Integer.parseInt(br.readLine());
		//��ü �迭
		A a[] = new A[N];
		
		//������ ��
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start_time = Integer.parseInt(st.nextToken());
			int end_time = Integer.parseInt(st.nextToken());
			a[i] = new A(start_time, end_time);
		}
		//����
		Arrays.sort(a, new Comparator<A>() {
			public int compare(A a1, A a2) {
				if(a1.end_time == a2.end_time) {
					return a1.start_time - a2.start_time;
				}else {
					return a1.end_time - a2.end_time;
				}
			//Greedy(Ž��) 	-> �� ������ �������� ���� ������ ���� ã�Ƴ����� ����
			}
		});
		//��ġ�� �� �ִ� ��ü ȸ���� ��
		int count = 0;
		//��ü���� �帧�� ����ð�
		int end = 0;
		
		for(int i=0; i<N ; i++) {
			//ó���� ���� �������� ���� ���� �����ϴ� ȸ�Ǹ� ã��
			//�� ��°���ʹ� ���ŵ� ����ȸ���� ����ð����� ū ���۽ð��� ã�´�.
			if(a[i].start_time >= end) {
				count++;
				end = a[i].end_time;
			}
		}
		System.out.println(count);
	}

}
