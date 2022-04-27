package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1021 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//수열의 요소 개수
		int N = Integer.parseInt(st.nextToken());
		//삭제를 원하는 요소의 개수
		int M = Integer.parseInt(st.nextToken());
		int count =0;//2번 3번 과정 count -> 최소의 움직임으로 가야함. 중앙값 기준으로 가까운 위치 비교
		
		Deque<Integer> dq = new LinkedList<Integer>();
		
		for(int i=1; i<=N;i++) {
			dq.offer(i);
		}
		
		int delete[] = new int[M];//삭제할 원소를 담을 배열 
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<M; i++) {
			delete[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			
			while(true) {
				int index = 0;
				Iterator<Integer> it = dq.iterator();
				
				while(it.hasNext()) {
					if(it.next() == delete[i]) {
						break;
					}
					index++;
				}
				if(index == 0) {
					dq.pollFirst();
					break;
				//3번 연산
				} else if(index > dq.size()/2) {
					dq.offerFirst(dq.pollLast());
					count++;
				//2번연산
				} else {
					dq.offerLast(dq.pollFirst());
					count++;
				}
			}//end-무한루프
			
		}
		System.out.println(count);
	}

}
