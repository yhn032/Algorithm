package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1002_���Ǳ��� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t =Integer.parseInt(br.readLine());
		
		/*	1. �� ������ ��� 			 0
		 	2. �����ϴ� ��� 			 1
		 	3. �� ������ ������ ��� 	 2
		 	4. �����ϴ� ���			 1
		 	5. ���ԵǴ� ��� 			 0
		 	6. ��ġ�ϴ� ���			-1
		*/
		while(t-->0) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			//���� ������ �Ÿ� 
			//�Ǽ��� ������ �ε��Ҽ��� ó���� ���ؼ� ��Ȯ���� �ʱ� ������
			//������ ������ ���� ���������� ���� ó�� �ؾ� �մϴ�. 
			
			int d = (int)(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
			
			if(x1==x2 && y1 == y2 && r1==r2) {
				cnt = -1;
			}else if(d > Math.pow(r1+r2, 2) || d < Math.pow(r1-r2,2)) {
				cnt = 0;
			}else if(d == Math.pow(r1+r2,2) || d == Math.pow(r1-r2,2)) {
				cnt = 1;
			}else{
				cnt = 2;
			}
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}

}
