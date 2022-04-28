package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13305 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//������ ���� 
		int N = Integer.parseInt(br.readLine());
		
		//������ ���� 
		long []way = new long[N-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1;i++) {
			way[i] = Long.parseLong(st.nextToken());
		}
		
		//�⸧�� ���� 
		long []oil = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			oil[i] = Long.parseLong(st.nextToken());
		}
		//��Ѱ������� �ʿ��� ��ŭ��, �Ѱ����� ����
		//ó�����ÿ����� �ݵ�� ������ �ؾ��Ѵ�. 
		//�������� ������ ���ú��� �⸧���� �� ���� �ִٸ� �� ������ �� �� �ִ� �⸧�� ����
		//���� ������ ������ �� �ڽź��� �⸧���� �� ���� �ִٸ� �� ������ �� �� �ִ� �⸧�� ���� 
		//���� �� ������ �����ϴٰ� �� �̻� ������ ������ ���� ���������� ���´ٸ� �״�� ����
		
		/*
			N 4
			R 2 3 1
			O 5 2 4 1
		*/
		
		
		long total_oil_price = 0;
		long min_oil_cost = oil[0];
		
		for(int i=0; i<oil.length-1;i++) {
			if(min_oil_cost > oil[i]) {//�����ּҰ����� ������ �⸧���� ã���� ���� �ִ� ������ �⸧�� �����Ͽ� �װ����� �̵��ض� 
				min_oil_cost = oil[i];
			}
			total_oil_price += min_oil_cost * way[i];
		}
		
		System.out.println(total_oil_price);
	}

}
