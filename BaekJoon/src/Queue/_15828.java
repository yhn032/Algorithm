package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _15828 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		//숫자는 put
		//0은 빼
		//-1은 종료
		//큐가 꽉차면 패킷 버려
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		while(true) {
			int packet = Integer.parseInt(br.readLine());
			
			if(packet == -1 ) break;
			
			else if(packet == 0 ) q.poll();
			
			else if(q.size() >= n ) continue;
			
			else q.add(packet);
		}
		
		if(q.isEmpty()) System.out.println("empty");
		else {
			System.out.println(q.toString().substring(1, q.toString().length()-1).replaceAll(",", ""));
		}
	}
}
