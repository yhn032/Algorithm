package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10250_ACMȣ�� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i< t; i++) {
			st = new StringTokenizer(br.readLine());
			
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			//���� 
			//�������� 0�̸� height��
			//0�̾ƴϸ� ������ ��
			int yy = 0;
			yy = N % height;
			if(yy != 0)
				sb.append(yy);
			else 
				sb.append(height);
				
			
			//ȣ��
			int xx =0;
			if(yy == 0) {
				xx = N / height;
				
			} else {
				xx = N / height+1;
				
			}
			
			String xx_str = String.valueOf(xx);
			if(xx >= 10)
				sb.append(xx_str).append('\n');
			else{
				sb.append("0"+xx_str).append('\n');
			}
			
		}
		
		System.out.println(sb);
		
	}

}
