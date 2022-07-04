package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3665_최종순위_위상정렬 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//테케의 수
		int t = Integer.parseInt(br.readLine());
		
		
		for(int k=0; k<t; k++) {
			
			//팀의 수
			int n = Integer.parseInt(br.readLine());
			
			//1. 인접리스트 생성
			List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(int i=0 ; i<=n; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			//2. 진입차수 배열 & 인접리스트 초기화
			int []inDegree = new int[n+1];
			int []ans	   = new int[n+1];
			
			//작년 순위를 기록한다. 
			int lastYear[] = new int[n+1];
			st = new StringTokenizer(br.readLine());
			//idx	0	1	2	3	4	5
			//값 	0	5	4	3	2	1 
			for(int i=1; i<=n; i++) {
				lastYear[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i=1; i< n; i++) {//n-1번 반복
				int big = lastYear[i];
				for(int j=i+1; j<=n; j++) {
					list.get(big).add(lastYear[j]);
					inDegree[lastYear[j]]++;
				}
				
			}
			
			//변경된 순위에 대한 경로를 역방향으로 설정해주기 
			int change = Integer.parseInt(br.readLine());
			for(int i=0; i<change; i++) {
				st = new StringTokenizer(br.readLine());
				int one = Integer.parseInt(st.nextToken());
				int two = Integer.parseInt(st.nextToken());
				
				if(list.get(one).contains(two)) {
					list.get(one).remove((Integer)two);
					list.get(two).add(one);
					inDegree[one]++;
					inDegree[two]--;
					
				}else {
					//캐스팅하지 않으면 자동 박싱이 되지 않고, 인덱스를 참조해서 삭제해버린다. 
					list.get(two).remove((Integer)one);
					inDegree[one]--;
					//역방향 간선 추가 
					list.get(one).add(two);
					inDegree[two]++;
				}
				
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			int cnt = 0;
			for(int i=1; i<=n; i++) {
				if(inDegree[i] == 0) {
					cnt++;
					q.add(i);
				}
			}
			
			if(cnt > 1) {
				//두 개의 이상의 원소가 큐에 들어간다면, 정확한 순위를 매길 수 없다는 뜻으로 ?를출력한다.
				sb.append("?").append('\n');
				continue;
			}
			
			//사이클의 존재 여부 파악하기 
			//큐에 값이 없으면 시작 노드가 없다는 뜻이고, 모든 노드의 진입차수가 0이라는 것 즉, 사이클이 있는것이다. 
			int result = 0;
			boolean isCycle = false;
			for(int i=1; i<=n; i++) {
				if(q.isEmpty()) {
					sb.append("IMPOSSIBLE").append('\n');
					isCycle = true;
					break;
				}
				
				int a = q.poll();
				result++;
				sb.append(a).append(' ');
				
				for(int to : list.get(a)) {//a에게 방향을 받는 모든 노드 진입차슈 -1
					inDegree[to]--;
					if(inDegree[to] == 0) q.add(to);
				}
			}
			sb.append('\n');
		
		}//end-for-k
		System.out.println(sb.toString());
				
	}
}
