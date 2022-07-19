package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16928_뱀과사다리 {
	static int map[]   = new int[101];//1번~100번 노드; 0번은 버림
	static boolean visit[] = new boolean[101];//1번~100번 노드; 0번은 버림
	static int ans[]   = new int[101];//1번~100번 노드; 0번은 버림
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int sadari = Integer.parseInt(st.nextToken());
		int snake  = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<sadari + snake; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map[start] = end;
		}
		
		bfs();
		

	}
	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		ans[1]= 0;
		visit[1] = true;
		q.add(1); //시작점 1번 노드
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == 100) {
				System.out.println(ans[cur]);
				return;
			}
			
			for(int i=1; i<=6; i++) {
				int next = cur + i;
				
				//if(next >100) continue;
				//if(visit[next]) continue;
				
				if(next <= 100 && !visit[next]) {
					
					visit[next] = true;
					
					if(map[next] !=0 ) {//사다리 또는 뱀이라면
						if(!visit[map[next]]) {
							visit[map[next]] = true;
							ans[map[next]] = ans[cur]+1;
							q.add(map[next]);//배열에 저장된 값으로 이동
							
						}
					}else {
						q.add(next);
						ans[next] = ans[cur] + 1;
					}
					
					
					
					/*
						if(map[next]!=0 && !visit[map[next]]) -> 뱀과 사다리가 있고(1), 방문하지 않은 경우(1)
						위 조건문의 반례는 다음과 같다
						1. 뱀과 사다리가 있지만(1) 방문한 경우(0) 					-> 이전에 방문했을 때 체크한 값을 또 +1하므로 잘못된 결과 도출
						2. 뱀과 사다리가 없지만(0) 방문안 한 경우(1)				-> 어차피 이동 시킬 수 없기 때문에 그냥 +1
						3. 뱀과 사다리가 없지만(0) 방문 한 경우(0)					-> 어차피 이동 시킬 수 없기 때문에 그냥 +1
						
						위의 반례들을 else문 하나로 묶어 줄수 없다... 
						else문을  사용해서 위의 세가지 반례의 경우에는 count만 1증가시켰는데, 이렇게 하면 각기 다른 반례에 대해
						공통된 처리를 했기때문에 정확한 답이 안나올 수 밖에 없다.
						결과적으로 1번 반례에 대해 잡아주지 못하는 조건문이었다. 조건문을 설정할 때 좀더 꼼꼼하게 보도록 하자.
						
						if(map[next]!=0) -> 뱀과 사다리가 있는 경우 
						위 조건문의 반례는 하나뿐이다. 
						1. 뱀과 사다리가 없는 경우 -> 그냥 count만 증가시킨다. 
					*/
				}
			}
		}
	}

}

