package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2589_보물섬 {
	
	static boolean map[][];
	static boolean visit[][];
	static int injac[][];
	static int w, h;
	static int dx[] = {-1, 1,  0, 0};
	static int dy[] = { 0, 0, -1, 1};
	static int copy[][];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//가로(h), 세로(w)
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map   = new boolean[w][h];
		injac = new int[w][h];
		
		for(int i=0; i<w; i++) {
			String str = br.readLine();
			for(int j=0; j<h; j++) {
				char c = str.charAt(j);
				if(c == 'L') {//육지인 경우만 true처리 나머지 바다는 false;
					map[i][j] = true;
				}
			}
		}
		
		//일단 탐색을 해서, 육지에다가 이웃한 육지의 수를 적는다. 
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				if(map[i][j]){
					countInjac(i,j);
				}
			}
		}
		
		//최솟값 찾기
		int min = Integer.MAX_VALUE;
		for(int a[] : injac) {
			for(int aa : a) {
				if(aa == 0) continue;
				min = aa < min ? aa : min;
			}
		}
		
		//최솟값을 탐색의 시작 지점으로 설정
		List<pos> list = new ArrayList<>();
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				if(injac[i][j] == min) {
					list.add(new pos(i, j));
				}
			}
		}
		
		int res[] = new int[list.size()];
		
		for(int i=0; i<list.size(); i++) {
			int time = bfs(list.get(i).x, list.get(i).y);
			res[i] = time;
		}
		
		int max = 0;
		for(int i=0; i<res.length; i++) {
			max = max < res[i]? res[i]:max;
		}
		
		System.out.println(max);
		
		/*
		 * System.out.println(min); for(int a[] : injac) { for(int aa : a) {
		 * System.out.print(aa + ""); } System.out.println(); }
		 */
		
	}
	private static void countInjac(int x, int y) {
		// TODO Auto-generated method stub
		int idx = 0 ;
		
		for(int i=0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if(xx < 0 || yy < 0 || xx >= w || yy >= h) continue;
			if(!map[xx][yy]) continue;
			idx++;
		}
		injac[x][y] = idx;
		
	}
	private static int bfs(int x, int y) {
		// TODO Auto-generated method stub
		int time = 0;
		copy = new int[w][h];
		Queue<pos> q = new LinkedList<>();
		visit = new boolean[w][h];
		visit[x][y] = true;
		q.add(new pos(x, y));
		
		int finishX=0;
		int finishY=0;
		
		while(!q.isEmpty()) {
			pos now = q.poll();
			
			for(int i=0; i<4; i++) {
				int xx = now.x + dx[i];
				int yy = now.y + dy[i];
				
				if(xx < 0 || yy < 0 || xx >= w || yy >= h) continue;	//배열의 범위를 벗어나거나
				if(!map[xx][yy]) continue;								//바다이거나
				if(visit[xx][yy]) continue;								//방문했으면 스킵
				
				copy[xx][yy] = copy[now.x][now.y]+1;
				visit[xx][yy] = true;
				q.add(new pos(xx, yy));
				finishX = xx;
				finishY = yy;
			}
			
		}
		
		return copy[finishX][finishY];
	}
	
	static class pos{
		int x, y; 
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

