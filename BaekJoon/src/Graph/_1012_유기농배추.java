package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1012_유기농배추 {
	static boolean visit[][];
	//					상 하  좌 우
	static int dx[] = {-1, 1,  0, 0};
	static int dy[] = { 0, 0, -1, 1};
	static int[][] baat;
	static int width, height;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			st = new StringTokenizer(br.readLine());
			
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			baat = new int[height][width];
			visit = new boolean[height][width];
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				baat[x][y] = 1;
			}
			
			
			int count=0; 
			
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					if(baat[i][j] == 1 && !visit[i][j]) {
						count++;
						bfs(i, j);
					}
				}
			}
			
			sb.append(count).append('\n');
		}
		
		System.out.println(sb);
		
	}

	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		Queue<int []> q = new LinkedList<int[]>();
		visit[x][y] = true;
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			
			//상하좌우로 이동
			for(int i=0; i<4; i++) {
				int xx = cur[0] + dx[i];
				int yy = cur[1] + dy[i];
				
				if(xx >=0 && yy >=0 && xx <height && yy <width) {
					if(baat[xx][yy] == 1 && !visit[xx][yy]) {
						visit[xx][yy] = true;
						q.add(new int[] {xx, yy});
					}
				}
			}
		}
	}

}
