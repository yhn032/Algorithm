package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1004_����� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			int ans=0;
			
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			
			//�༺�� ����
			int n = Integer.parseInt(br.readLine());
			
			for(int i=0; i<n;i++) {
				st = new StringTokenizer(br.readLine());
				
				int Cx = Integer.parseInt(st.nextToken());
				int Cy = Integer.parseInt(st.nextToken());
				int Cr = Integer.parseInt(st.nextToken());
				
				//�������� �༺ �ܺ�(true)�� �ִ��� ����(false)�� �ִ��� Ȯ������ ���º���
				boolean check_start = false;
				boolean check_end   = false;
				
				
				//�������� ���� �߽� ������ �Ÿ��� ������ ���� ũ�ٸ� �ܺο� �ִ°Ŵ�.
				if(Math.pow(startX-Cx, 2) + Math.pow(startY-Cy, 2) > Math.pow(Cr, 2)) check_start = true;
				if(Math.pow(endX-Cx, 2) + Math.pow(endY-Cy, 2) > Math.pow(Cr, 2)) check_end = true;
				
				//�������� ������ �߿��� �� �߿� �ϳ��� ���� ���ο� ���� ��, ����/��Ż ����Ǽ� +1
				if(check_end==true && check_start==false) ans++;
				else if(check_end==false && check_start==true) ans++;
				
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
		
	}
}
