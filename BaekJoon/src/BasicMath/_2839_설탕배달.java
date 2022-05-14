package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2839_설탕배달 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int min = 5000;
		
		//5kg 봉지의 개수
		int five=0; 
		//3kg 봉지의 개수
		int three=0;
		
		while(5*five <= n) {
			
			if(5*five==n) { //n이 5의 배수인 경우
				min = five;
			}
			
			//3kg 봉지의 개수
			three = 0;
			
			int temp = n - (5*five);
			if(temp % 3 != 0) {//5와 3으로 구성할 수 없는 무게인 경우
				five++;
				continue;
			} else {
				three = (temp/3);
			}
			
			min = min  > (five+three) ? five+three : min;
			/*
			 * System.out.println(five + "회째 경우의 수"); System.out.println("5kg : " + five);
			 * System.out.println("3kg : " + three);
			 */
			
			
			five++;
		}
		System.out.println(min != 5000 ? min : -1);
	}

}
