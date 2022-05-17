package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11501_�ֽ� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t;i++) {
			
			int days = Integer.parseInt(br.readLine());
			long money[] = new long[days];
			
			//�ְ� �ʱ�ȭ�ϱ�
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<days; k++) {
				money[k] = Long.parseLong(st.nextToken());
			}
			
			
			//�ְ�
			long max = 0;
			long plus = 0;
			for(int j=days-1; j>=0; j--) {
				if(money[j] > max) {
					//�ְ� ���� -> 3.�ƹ��͵� �� �Ѵ�.
					max = money[j];
				}else {//�ְ����� �����ϸ� ��� �Ǵ�. -> �ü����͸�ŭ ���ϴ� ���� �����̴�. 
					plus += (max-money[j]);
				}
			}
			
			sb.append(plus).append('\n');
		}
		System.out.println(sb);
	}

}
//3 5 9
/*
	max 9 
	9-5 +   4 
	9-3 +   6
*/
