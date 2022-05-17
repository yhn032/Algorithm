package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _11003_최솟값찾기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		Deque<Node4> dq = new LinkedList<>();
		for(int i=0; i< N; i++) {
			//새로운 값이 들어올 때마다, 정렬을 하지말고 크기 비교를 하면서 현재 값보다 큰 값을 덱에서 제거하면서 시건복잡도 줄이기 
			
			int now = Integer.parseInt(st.nextToken());
			
			//덱이 비어있지 않거나 덱의 가장 마지막값(최대값이) 새로 들어오려는 값보다 크다면 마지막에 있는 값을 덱에서 삭제한다.
			//반복문을 사용해서 모두 삭제하는 이유는, 새로 들어오는 값보다 작은 값은 남기고 큰값은 모두 지우면서 오름차순 정렬효과를 보기 위함이다.
			while(!dq.isEmpty()&& dq.getLast().value > now) {
				dq.removeLast();
			}
			
			dq.addLast(new Node4(now, i));
			
			//윈도우의 크기에서 벗어난 인덱스도 제거한다. 
			if(dq.getFirst().index <= i-L) {
				dq.removeFirst();
			}
			
			//덱의 가장 앞 부분이 최솟값이다.
			sb.append(dq.getFirst().value).append(' ');
		}
		
		System.out.println(sb);
		
	}

	static class Node4 {
		int value;
		int index;
		
		Node4(int value, int index){
			this.value = value;
			this.index = index;
		}
	}
}


