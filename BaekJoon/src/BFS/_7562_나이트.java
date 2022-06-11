package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562_나이트 {
	static int [][] map;
	static boolean [][] visit;
	static int [][] ans;
	static int e_x, e_y, n;
	
	static int dx[] = {-2, -1, 1, 2,  2,  1, -1, -2};
	static int dy[] = { 1,  2, 2, 1, -1, -2, -2, -1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			//체스판의 크기
			n = Integer.parseInt(br.readLine());
			map = new int [n][n];
			visit = new boolean[n][n];
			ans = new int[n][n];
			
			
			//현재 킹의 위치 
			st = new StringTokenizer(br.readLine());
			int k_x = Integer.parseInt(st.nextToken());
			int k_y = Integer.parseInt(st.nextToken());
			
			//목적지 위치
			st = new StringTokenizer(br.readLine());
			e_x = Integer.parseInt(st.nextToken());
			e_y = Integer.parseInt(st.nextToken());
			
			if(k_x==e_x && k_y == e_y) {
				sb.append(0).append('\n');
				continue;
			}
			
			
			bfs(k_x, k_y);
		}
		
		System.out.println(sb);
	}
	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		int count = 0;
		ans[x][y] = count;
		Queue<int []> q = new LinkedList<int[]>();
		visit[x][y] = true;
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			
			
			for(int i=0; i<8; i++) {
				int xx = cur[0] + dx[i];
				int yy = cur[1] + dy[i];
				
				if(xx==e_x && yy == e_y) {
					sb.append(ans[cur[0]][cur[1]]+1).append('\n');
					return;
				}
				
				if(xx >= 0 && yy >=0 && xx < n && yy <n) {
					if(!visit[xx][yy] && ans[xx][yy] == 0) {
						
						visit[xx][yy] = true;
						ans[xx][yy] = ans[cur[0]][cur[1]]+1;
						q.add(new int[] {xx, yy});
					}
				}
			}
		}
	}

}
