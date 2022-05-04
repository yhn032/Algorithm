package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11724_edgecount {
	static int N;
	static int M;
	static int graph[][];
	static boolean checked[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			//시작점
			int tmp1 = Integer.parseInt(st.nextToken());
			//끝점
			int tmp2 = Integer.parseInt(st.nextToken());
			
			graph[tmp1][tmp2] = 1;
			graph[tmp2][tmp1] = 1;
		}
		
		checked = new boolean[N+1];
		
		int count = 0;
		
		//각 정점의 방문여부 확인해서 방문하지 않은 노드는 탐색한다. 탐색이 가능하다는 것은 간선이 연결되어 있다는 것
		for(int i=1; i<N+1; i++) {
			if(!checked[i]) {
				dfs(i);
				count++;
			}
		}
		/*
		 * for(int[] s : graph) { for(int ss : s) { System.out.print(ss + " "); }
		 * System.out.println(); }
		 */
		
		System.out.println(count);
	}
	private static void dfs(int i) {
		// TODO Auto-generated method stub
		checked[i] = true;
		for(int k=1; k<=N; k++) {
			if(graph[i][k] == 1 && !checked[k]) {
				dfs(k);
			}
		}
	}

}
