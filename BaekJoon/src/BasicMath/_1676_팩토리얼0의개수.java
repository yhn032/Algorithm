package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1676_팩토리얼0의개수 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(countZero(n));
	}

	private static int countZero(int n) {
		// TODO Auto-generated method stub
		int cnt_5=0;
		int cnt_2=0;
		
		
		
		for(int i= 1; i<=n; i++) {
			int temp = i;
			
			while(temp%2==0) {
				cnt_2++;
				temp /= 2;
			}
			
			while(temp%5==0) {
				cnt_5++;
				temp /= 5;
			}
		}
		return Math.min(cnt_5, cnt_2);
	}

}


/*
	값에서 0이 나오려면 반드시 2*5의 쌍이 존재해야 한다.
	n~1까지의 수중에서 소인수분해를 했을 때, 2의 개수가 5의 개수보다 많을테니 5의 개수를 구하면 된다.
*/
