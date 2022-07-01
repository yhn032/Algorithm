package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1388_바닥장식 {
	
	static boolean visit[][];
	static boolean   map[][];
	static int n,m;
	//					상 하  좌 우
	static int dx[] = {-1, 1,  0, 0};
	static int dy[] = { 0, 0, -1, 1};
	static int count = 0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n][m];
		map   = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			char c[] = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				if(c[j] == '-') {
					map[i][j] = true;
				}//|인경우는 기본값 false로 두기
			}
		}
		
		/*
		 * for(boolean b[] : map) { for(boolean bb : b) { System.out.printf("%-5s", bb);
		 * } System.out.println(); }
		 */
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visit[i][j]) {
					dfs(i,j);
					count++;
					
				}
			}
		}
		
		
		System.out.println(count);
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = true;
		
		if(map[x][y]) {//'-'
			for(int i=2; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
				
				if(!visit[xx][yy]&& map[xx][yy] ) {
					visit[xx][yy] = true;
					dfs(xx,yy);
				}
			}
			
		}else {//'|'
			for(int i=0; i<2; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
				
				if(!visit[xx][yy] && !map[xx][yy]) {
					visit[xx][yy] = true;
					dfs(xx,yy);
				}
			}
		}
	}

}


/*
	- 인 경우는 좌우만 탐색 
	| 인 경우는 상하만 탐색
*/
