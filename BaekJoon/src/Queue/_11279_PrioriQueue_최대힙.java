package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class _11279_PrioriQueue_최대힙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer   sb = new StringBuffer();
		
		//질문의 개수
		int n = Integer.parseInt(br.readLine());
		
		//우선순위큐를 사용할때는 반드시 우선순위를 부여할 정렬기준을 만들어 줘야 한다. 
		//기본적으로 오름차순 -> 최소힙으로 되어 있기 때문에 최대 힙을 구현하기 위해서는 내림차순으로 정렬해야 한다. 
		Queue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num==0) {//0이라면 가장 큰 값을 출력한다. 
				
				sb.append(pq.size() == 0 ? 0 : pq.poll()).append('\n');
				
			}else {//0이 아니라면 값을 그대로 넣는다.
				pq.add(num);
			}
		}
		
		System.out.println(sb.toString());
	}

}
