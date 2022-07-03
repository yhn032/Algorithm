package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _10026_적록색약 {
	static int[] dx = {-1, 1,  0, 0};
	static int[] dy = { 0, 0, -1, 1};
	static int n, area, area2;
	static char [][] map;
	static boolean visit[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		//map초기화
		map = new char[n][n];
		String temp;
		for(int i=0; i<n; i++) {
			temp = br.readLine();
			map[i] = temp.toCharArray();
		}
		
		/*
		 * for(char c[] : map) { for(char cc : c) { System.out.print(cc + " "); }
		 * System.out.println(); }
		 */
		//정상
		visit = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int k=0; k<n; k++) {
				if(!visit[i][k]) {
					bfs(i, k);
				}
			}
		}
		sb.append(area).append(' ');
		
		
		area = 0;
		visit = new boolean[n][n];
		//모든 G를 R로 바꾸기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n;j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		//적록색약
		for(int i=0; i<n; i++) {
			for(int k=0; k<n; k++) {
				if(!visit[i][k]) {//나머지는 특수 탐색
					bfs(i, k);
				}
			}
		}
		sb.append(area);
	
		
		System.out.println(sb);
		
	}
	
	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		area++;
		char c;
		Queue<noode> q = new LinkedList<noode>();
		//방문배열
		visit[x][y] = true;
		q.add(new noode(x, y));
		
		while(!q.isEmpty()) {
			noode now = q.poll();
			c = map[now.x][now.y];
			for(int i=0; i<4; i++) {
				int xx = now.x + dx[i];
				int yy = now.y + dy[i];
				
				if(xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
				if(map[xx][yy] != c || visit[xx][yy]) continue;
				
				visit[xx][yy] = true;
				q.add(new noode(xx, yy));
			}
		}
	}
}
class noode{
	int x, y;
	public noode(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
