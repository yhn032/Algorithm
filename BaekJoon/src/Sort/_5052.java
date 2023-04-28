package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5052 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			int n = Integer.parseInt(br.readLine());
			
			String [] phone_number = new String[n];
			
			for(int i=0; i<n; i++) {
				phone_number[i] = br.readLine();
			}
			
			/*
				전화번호가 오름차순으로 정렬되어 있다고 가정하면, 
				접두어 관계에 있는 경우는 반드시 인접하게 되어 있다. 
				접두어 관계 O -> NO
				접두어 관계 X -> YES
				EX> 
					114
					1145
					1156
				 위의 번호 중 1,2는 접두어 관계에 있다. 
				 즉, 특정 번호 앞 or 뒤로 접두어 관계가 있는지 확인하면 되는데
				 이를 위한 메소드로 String.startWith('문자열') 메소드를 사용하여
				 특정 문자열이 괄호 안에 문자열로 시작하면 true, 아니면 false를 반환한다.
			*/
			Arrays.sort(phone_number);
			
			if(isPrefix(n, phone_number)) {
				sb.append("YES").append('\n');
			}else {
				sb.append("NO").append('\n');
			}
		}
		
		System.out.println(sb.toString());
	}

	private static boolean isPrefix(int n, String[] phone_number) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<n-1;i++) {
			if(phone_number[i+1].startsWith(phone_number[i])) return false;
		}
		return true;
	}
}
