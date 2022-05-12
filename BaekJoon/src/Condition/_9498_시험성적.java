package Condition;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _9498_시험성적 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		if(n<=100 && n >=90) {
			sb.append('A');
		}else if(n<=89 && n >= 80) {
			sb.append('B');
		}else if(n<=79 && n >= 70) {
			sb.append('C');
		}else if(n<=69 && n >= 60) {
			sb.append('D');
		}else {
			sb.append('F');
		}
		
		System.out.println(sb);
	}

}
