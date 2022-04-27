package Kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution4 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        return answer;
    }
}
public class developmentFunction {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int progress[] = {93, 30, 55};
		int speeds[] = {1, 30, 5};
		
		
		//개발 완료까지 남은 날
		int finish_day[] = new int[progress.length];
		
		for(int i=0; i<progress.length;i++) {
			
			//100%까지 남은 기간
			int day_remain = 100 - progress[i];
			
			//나누어 떨어지면
			if(day_remain%speeds[i] == 0) {
				finish_day[i] = day_remain/speeds[i];
			} 
			else {//나누어 떨어지지 않으면 남은 작업량을 위해 하루 더 해야 함
				finish_day[i] = day_remain/speeds[i] + 1;
			}
			//System.out.print(finish_day[i] + " ");
		}
		
		Queue<Integer> list = new LinkedList<>();
		List<Integer> list2 = new ArrayList<>();
		
		//큐에 progresses의 순서대로 삽입한다.
		for(int i=0; i<finish_day.length;i++) {
			list.add(finish_day[i]);
		}
		
		//작업 경과일을 기록할 변수
		int time = 0;
		//
		while(!list.isEmpty()) {
			int count = 0;
			time++;
			//큐가 비어있지 않거나, 작업 경과일이 요구 작업일보다 클경우(100%도달)
			while(!list.isEmpty() && time >= list.peek()) {
				list.poll();
				count++;
				//역조건. 리스트에 0이 아닌 값을 넣기 위함.
				if(!(!list.isEmpty() && time >= list.peek())) {
					list2.add(count);
				}
			}
		}
		int answer[] = new int[list2.size()];
		
		for(int j=0; j<list2.size();j++) {
				
			answer[j] = list2.get(j);
			System.out.print(answer[j] + " ");
			
		}
	}
}
