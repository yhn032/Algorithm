package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14500_테트로미노 {
	private static int max = 0;
	private static int n,m;
	private static int[][] map;
	private static boolean [][]visited;
	static int dx[] = { -1, 1,  0, 0};
	static int dy[] = {  0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}//end-for-j
		}//end-for-i
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visited[i][j] = true;
				dfs(1, i, j, map[i][j]);
				visited[i][j] = false;
			}
		}
		
		System.out.println(max);
		
	}
	private static void dfs(int depth, int x, int y, int sum) {
		// TODO Auto-generated method stub
		if(depth == 4) {
			max = sum > max ? sum : max;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if(xx < 0 || yy < 0 || xx >= n || yy >=m) continue;
			if(visited[xx][yy]) continue;
			
			if(depth == 2) {
				// ㅗ 모양 테트로미노를 위해 2개의 정사각형이 있는 경우에는 한 가지 경우의 수를 더 한다.
				visited[xx][yy] = true;
				dfs(depth+1, x, y, sum + map[xx][yy]);
				visited[xx][yy] = false;
				
			}
			
			visited[xx][yy] = true;
			dfs(depth+1, xx, yy, sum + map[xx][yy]);
			visited[xx][yy] = false;
			
		}
		
	}

}

/*
	1. ----
	
	2. --
	   -- 
	   
	3. -
	   -
	   --
	   
	4. -
	   --
	    -
	    
	5. ---
	    -
	1~4 -> dfs 
	5 따로 완전 탐색
	최댓값 비교
	
	
	회전 & 대칭에 따라 달라지는 모양이 1가지인 경우
	-> 2

	회전 & 대칭에 따라 달라지는 모양이 2가지인 경우
	-> 1, 4
	
	회전 & 대칭에 따라 달라지는 모양이 4가지인 경우
	-> 3, 5
	
*/
