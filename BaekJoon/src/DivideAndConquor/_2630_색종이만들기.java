package DivideAndConquor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630_색종이만들기 {
	static int map[][];
	static int blue_cnt, white_cnt = 0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<n; k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, n);
		System.out.println(white_cnt);
		System.out.println(blue_cnt);
		
	}
	private static void divide(int x, int y, int size) {
		// TODO Auto-generated method stub
		
		if(isSameColor(x, y, size)) {
			if(map[x][y] == 1) {
				blue_cnt++;
			}else {
				white_cnt++;
			}
			return;
		}
		
		
		if(size > 1) {
			
			int Divide = size/2;
			
			for(int i=x; i<x+size; i+=Divide) {
				for(int k=y; k<y+size; k+=Divide) {
					divide(i, k, Divide);
				}
			}
		}
			
		
	}
	private static boolean isSameColor(int x, int y, int size) {
		// TODO Auto-generated method stub
		
		if(map[x][y] == 1) {//시작값을 기준으로 탐색하는데 다른 값이 나오면 return false
			
			for(int i=x; i<x+size; i++) {
				for(int k=y; k<y+size; k++) {
					if(map[i][k] != 1) return false;
				}
			}
		}else {
			for(int i=x; i<x+size; i++) {
				for(int k=y; k<y+size; k++) {
					if(map[i][k] != 0) return false;
				}
			}
			
		}
		
		//분할이 더 필요한 경우
		return true;
	}

}
