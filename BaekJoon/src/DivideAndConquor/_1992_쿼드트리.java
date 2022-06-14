package DivideAndConquor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1992_쿼드트리 {
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
		
		dfs(x,y, step);								//왼쪽     위 : 현재위치
		dfs(x,y+step, step);						//오른쪽   위 : 
		dfs(x+step,y, step);						//왼쪽   아래 : 
		dfs(x+step,y+step, step);					//오른쪽 아래 : 
		
		sb.append(')');
	}
	
	//압축 가능 여부
	private static boolean isCompress(int x, int y, int size) {
		// TODO Auto-generated method stub
		int val = map[x][y];
		
		//시작값과 비교해서 다르면 불가능 
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(val != map[i][j]) {
					return false;
				}
			}
		}
		
		//모두 같으면 압축 가능 
		return true;
	}

}
