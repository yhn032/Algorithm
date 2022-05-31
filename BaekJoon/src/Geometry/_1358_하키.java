package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1358_��Ű {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//�ʺ�w, ����h, x, y, ������ ��p	������ r�� h�� ����
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int r = h/2;//h�� �ݵ�� ¦���̴�.
		
		//��Ű ���ο� �ִ� ������ ī��Ʈ���� ����
		int count = 0;
		
		
		for(int i =0; i<p; i++) {
			
			//���ο� ������ true, �ܺο� ������ false
			boolean isInner = false;
			
			st = new StringTokenizer(br.readLine());
			
			//������ ��ǥ
			int pX = Integer.parseInt(st.nextToken());
			int pY = Integer.parseInt(st.nextToken());
			
			//1. ���� �ݿ��� �߽ɺ��� ���ʿ� ���� ��
			if(pX < x) {
				
				//���� �ݿ��� �߽ɰ� ���� ������ �Ÿ��� ������ ���� �۰ų� ������ -> ���ο� �ְų� ��迡 ����
				if(Math.pow(pX-x, 2) + Math.pow(pY-(y+r), 2) <= Math.pow(r, 2)) {
					isInner = true;
				}
			}
			
			//2. ��� ���簢���� ������ ���� ��
			else if(pX >= x && pX <= x+w && pY <= y+h && pY >= y) {
				
				isInner = true;
				
			}
			//3. ������ �ݿ��� �߽ɺ��� �����ʿ� ���� ��
			else if(pX > x+w) {
				
				if(Math.pow(pX-(x+w), 2) + Math.pow(pY-(y+r), 2) <= Math.pow(r, 2)) {
					isInner = true;
				}
				
			}
			
			if(isInner) {
				count++;
			}
			
			
		}
		
		System.out.println(count);
	}

}
