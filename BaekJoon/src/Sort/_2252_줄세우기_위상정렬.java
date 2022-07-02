package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2252_줄세우기_위상정렬 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//1. 인접리스트 생성 및 초기화
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		//2. 진입 차수 배열 생성 및 초기화 
		int inDegree[] = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list.get(A).add(B);
			inDegree[B]++; //A->B이므로 B의 진입차수를 1 증가시킨다. 
		}
		
		//3. 위상 정렬 큐를 만들어서 본격적으로 정렬 시작하기 
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(inDegree[i] == 0) {
				q.add(i);
			}
		}
		
		//위상 정렬큐에 값이 없을 때까지 반복한다. 
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(' ');
			for(int node : list.get(now)) {//4. 노드 now가 가리키는 노드들의 진입차수를 1씩 감소시킨다.
				inDegree[node]--;
				
				if(inDegree[node] == 0) {//5. 감소의 결과가 0이라면 또한 큐에 추가한다. 
					q.add(node);
					
				}
			}
		}
		
		System.out.println(sb);
		
	}
}
