package collections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class temp {

	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
	첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 
	둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 
	이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 
	시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

	출력
	첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
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
				
				if(res == mytime[N-1].getEnd_time()) { // 마지막 시간이랑 비교값이 같으면..
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
