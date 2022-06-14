package DivideAndConquor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1992_����Ʈ�� {
	static int n;
	static int map[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n;j++) {
				map[i][j] = str.charAt(j)-'0'; 
			}
		}
		
		dfs(0,0,n);
		System.out.println(sb);
		
	}
	private static void dfs(int x, int y, int size) {
		// TODO Auto-generated method stub
		if(isCompress(x,y,size)) {
			sb.append(map[x][y]);
			return;
		}
		
		int step = size/2;
		
		sb.append('(');
		
		dfs(x,y, step);								//����     �� : ������ġ
		dfs(x,y+step, step);						//������   �� : 
		dfs(x+step,y, step);						//����   �Ʒ� : 
		dfs(x+step,y+step, step);					//������ �Ʒ� : 
		
		sb.append(')');
	}
	
	//���� ���� ����
	private static boolean isCompress(int x, int y, int size) {
		// TODO Auto-generated method stub
		int val = map[x][y];
		
		//���۰��� ���ؼ� �ٸ��� �Ұ��� 
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(val != map[i][j]) {
					return false;
				}
			}
		}
		
		//��� ������ ���� ���� 
		return true;
	}

}
