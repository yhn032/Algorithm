package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1018_ü���� {
	static int cnt;
	static char map[][];
	static int min=64;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}
		
		int temp_n = n-7;
		int temp_m = m-7;
		
		//��� ����� �� Ž�� 
		//���� ��ġ���� ���� �¿찡 �ٸ� ���̾�� �Ѵ�. 
		//�ʱ���ġ�� ��ĥ�Ǵ� ���� ���� ü������ �ٸ���.
		//8x8������ ��� �� �������� Ž��
		//�� ���� ���� ������ Ƚ���� �ּڰ��� ���ؼ� �����ϰ�, �� �������� ����� �ּڰ��� ���Ͽ� �� ���� ���� �����Ѵ�.
		for(int i=0; i<temp_n; i++) {
			for(int k=0; k<temp_m; k++) {
				find(i,k);//������ġ���� Ž�� ����
			}
		}
		
		 
		
		
		System.out.println(min);
		/*
		 * for(char[] cc : map) { for(char ccc : cc) { System.out.print(ccc + " "); }
		 * System.out.println(); }
		 */
	}

	private static void find(int x, int y) {
		// TODO Auto-generated method stub
		int end_x = x+8; //Ž���� ü������ �� �ε��� 
		int end_y = y+8;
		//�� �������� ī��Ʈ�ϱ� ���� �������� 0���� �ʱ�ȭ
		int cnt = 0;
		
		char C = map[x][y];// ���۰�
		
		for(int i=x; i<end_x; i++) {
			for(int k=y; k<end_y; k++) {
				if(map[i][k] != C) {//���� ���� �ʴٸ�
					cnt++;
					
				}
				//���� ��ġ���� ������ġ�� ���� �޶�� �ϱ� ������
				//C�� ����� ���� �ٲپ� �־�� �Ѵ�.
				C = (C=='W') ? 'B' : 'W';
			}
			//�� ���� ������ ��ġ�� ���� ���� ù ��ġ�� ���� ���ƾ� �Ѵ�.
			//���� �ٲٸ� �ȵǴµ�, ������ ���� �ٲپ��� ������ �ٽ� �ٲ��༭ �����·� �ؾ� �Ѵ�.
			C = (C=='W') ? 'B' : 'W';
			
		}
		
		//�־��� �迭���� ���۰��� �������� ��ĥ�� ���(cnt)�� ���۰��� �ݴ�� ��ĥ�� ���(64-cnt) �� ���� �ּҰ��� ���Ѵ�.
		cnt = Math.min(cnt, 64-cnt);
		
		
		//���� �ּڰ����� �۴ٸ� �����ϱ�
		min = Math.min(cnt, min);
	}

}
