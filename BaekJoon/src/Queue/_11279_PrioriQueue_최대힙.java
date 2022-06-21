package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class _11279_PrioriQueue_�ִ��� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer   sb = new StringBuffer();
		
		//������ ����
		int n = Integer.parseInt(br.readLine());
		
		//�켱����ť�� ����Ҷ��� �ݵ�� �켱������ �ο��� ���ı����� ����� ��� �Ѵ�. 
		//�⺻������ �������� -> �ּ������� �Ǿ� �ֱ� ������ �ִ� ���� �����ϱ� ���ؼ��� ������������ �����ؾ� �Ѵ�. 
		Queue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num==0) {//0�̶�� ���� ū ���� ����Ѵ�. 
				
				sb.append(pq.size() == 0 ? 0 : pq.poll()).append('\n');
				
			}else {//0�� �ƴ϶�� ���� �״�� �ִ´�.
				pq.add(num);
			}
		}
		
		System.out.println(sb.toString());
	}

}
