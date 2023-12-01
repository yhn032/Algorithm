package collections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class temp {

	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
	ù° �ٿ� ȸ���� �� N(1 �� N �� 100,000)�� �־�����. 
	��° �ٺ��� N+1 �ٱ��� �� ȸ���� ������ �־����µ� 
	�̰��� ������ ���̿� �ΰ� ȸ���� ���۽ð��� ������ �ð��� �־�����. 
	���� �ð��� ������ �ð��� 231-1���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.

	���
	ù° �ٿ� �ִ� ����� �� �ִ� ȸ���� �ִ� ������ ����Ѵ�.
*/	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Time [] mytime = new Time[N];
		
		StringTokenizer st;
		
		for (int i = 0; i < mytime.length; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
						
			mytime[i] = new Time( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) );
			
		}
		
		Arrays.sort(mytime);

		int count =1;
		
		//int i = 0;
		int k = 0;
		
		int res = mytime[0].getEnd_time();
		
		//System.out.println(res);
		
		
		while (true) {
			 
			k++;
			
			if( res < mytime[k].getstart_time() ) {
				
				res = mytime[k].getEnd_time();
				
				count++;
				
				if(res == mytime[N-1].getEnd_time()) { // ������ �ð��̶� �񱳰��� ������..
					break;
				}
				
			}
			
			
		} // while end
		
		System.out.println(count);
		
		
	}

	static class Time implements Comparable {

		int start_time;
		int end_time;
		
		public Time(int s_time, int e_time) {
			// TODO Auto-generated constructor stub
			this.start_time = s_time;
			this.end_time   = e_time;
		}
		
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return this.end_time - ((Time)o).end_time;
		}
		
		public String toString(){
			return String.format("%s %s",start_time, end_time);
		}

		public int getEnd_time() {
			return end_time;
		}

		public int getstart_time() {
			return start_time;
		}
				
		
	}
}
