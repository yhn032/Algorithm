package DivideAndConquor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1780_종이의수 {
	static int[][] map;
	static int zero, plus, minus;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st;
		StringBuilder sb = new StringBuilder();
		
		//색종이의 크기 n*n, n->3^k
		int n = Integer.parseInt(br.readLine());
		
		//맵초기화
		map = new int[n][n];
		for(int i=0;i <n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<n;k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		colorPaper(0, 0, n);
		
		sb.append(minus).append('\n');
		sb.append(zero).append('\n');
		sb.append(plus).append('\n');
		
		System.out.println(sb);
	}
	private static void colorPaper(int x, int y, int size) {
		// TODO Auto-generated method stub
		
		if(isSame(x, y, size)) {
			switch (map[x][y]) {
				case -1: minus++; break;
				case  0: zero++; break;
				case  1: plus++; break;
			}
			return;
		}
		
		int step = size/3;
		
		for(int i=x; i<x+size; i+=step) {
			for(int j=y; j<y+size; j+=step) {
				colorPaper(i, j, step);
			}
		}
		
		
		
	}
	private static boolean isSame(int x, int y, int size) {
		// TODO Auto-generated method stub
		int ans = map[x][y];
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(map[i][j] != ans) return false;
			}
		}
		
		return true;
	}
}
