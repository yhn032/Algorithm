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
		
		
		//���� �Ϸ���� ���� ��
		int finish_day[] = new int[progress.length];
		
		for(int i=0; i<progress.length;i++) {
			
			//100%���� ���� �Ⱓ
			int day_remain = 100 - progress[i];
			
			//������ ��������
			if(day_remain%speeds[i] == 0) {
				finish_day[i] = day_remain/speeds[i];
			} 
			else {//������ �������� ������ ���� �۾����� ���� �Ϸ� �� �ؾ� ��
				finish_day[i] = day_remain/speeds[i] + 1;
			}
			//System.out.print(finish_day[i] + " ");
		}
		
		Queue<Integer> list = new LinkedList<>();
		List<Integer> list2 = new ArrayList<>();
		
		//ť�� progresses�� ������� �����Ѵ�.
		for(int i=0; i<finish_day.length;i++) {
			list.add(finish_day[i]);
		}
		
		//�۾� ������� ����� ����
		int time = 0;
		//
		while(!list.isEmpty()) {
			int count = 0;
			time++;
			//ť�� ������� �ʰų�, �۾� ������� �䱸 �۾��Ϻ��� Ŭ���(100%����)
			while(!list.isEmpty() && time >= list.peek()) {
				list.poll();
				count++;
				//������. ����Ʈ�� 0�� �ƴ� ���� �ֱ� ����.
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