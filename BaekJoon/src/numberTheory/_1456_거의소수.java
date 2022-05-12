package numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1456_거의소수 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long arr[] = new long[10000001]; 
		//10^14의 제곱근 소수의 N제곱이 거의소수라고 했기때문에, 10^7의 범위 내에 소수를 구한다.
		//범위를 최대로 잡기 위해선 제곱을 최소로 해야하기 때문이다.
		for(int i=2;i<arr.length;i++) {
			arr[i] = i;
		}
		
		//소수구하기
		for(int i=2; i<Math.sqrt(arr.length);i++) {
			if(arr[i] == 0) continue;
			
			for(int k=i+i; k<arr.length; k+=i) {
				arr[k] = 0;
			}
		}
		
		int count = 0;
		for(int i=2; i < arr.length; i++) {
			if(arr[i] != 0) {
				long temp = arr[i];
				
				while(arr[i]*1.0 <= B*1.0/temp) {//각 소수의 N제곱값이 최대범위를 넘지 않는 개수를 구하는데 오버플로우가 나기때문에 이항정리를 응용한다. 
					if(arr[i]*1.0 >= A*1.0/temp) {
						count++;
					}
					//제곱승의 값을 구하는 것이므로 계속해서 값을 누적 곱해줘야 함
					temp *= arr[i];
				}
			}
		}
		System.out.println(count);
	}

}
