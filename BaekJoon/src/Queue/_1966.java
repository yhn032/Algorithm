package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		
		//테스트 데이터 개수
		int N = Integer.parseInt(st1.nextToken());
		//내가 궁금한 문서의 위치
		int M = Integer.parseInt(st1.nextToken());
		//출력횟수를 카운트 해줄 변수
		int count = 0;
		
		Deque<Integer> q = new LinkedList<Integer>();
		
		StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
		
		for(int i=0 ; i<N; i++) {
			q.offer(Integer.parseInt(st2.nextToken()));
		}
		//잠시 보류,,, 
		
		
	}
}
