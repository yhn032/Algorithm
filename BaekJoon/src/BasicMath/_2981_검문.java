package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2981_검문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int arr[]  = new int[n];
		int arr2[] = new int[n-1];
		
		//배열 초기화
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		//차이 배열의 최솟값이 최대 공약수
		for(int i=0; i<n-1;i++) {
			arr2[i] = arr[i+1] - arr[i];
		}
		
		//정렬해서 차이값이 가장 큰것과 작은 것의 최대 공약수를 구한다. 제일 작은 값이 최대 공약수임 차이값이 1일수도 있고 1보다 클 수도 있기 때문에
		//각 차이 값의 최대 공약수를 구해야 한다. 
		Arrays.sort(arr2);
		int value = arr2[0];
		
		for(int i=1; i<arr2.length;i++) {
			value = gcd(value, arr2[i]);
		}
		//최대 공약수의 약수를 어떻게 구하지 ?
		//최대 공약수의 약수 구하기
		for(int i=2; i<=value; i++) {
			if(value%i==0) {
				sb.append(i).append(' ');
			}
		}
		
		
		System.out.println(sb);
	}
	
	
	//유클리드 호제법
	//최대공약수 찾기
	private static int gcd(int min, int max) {
		// TODO Auto-generated method stub
		while(min != 0) {
			int r = max % min;
			max = min; 
			min = r;
		}
		return max;
	}

}

/* 
	모든 수를 M으로 나눈 나머지가 같다. 
	M은 반드시 하나 이상 존재한다.
	r==0으로만 만들 수 있다면 M은 공약수이다. -> 가장 큰값 최대 공약수를 구해서 그 놈의 약수를 구하자.
	6 /M + r
	34/M + r
	38/M + r
	
	(38-34)/M, (34-6)/Mㅉ
	38-34와 34-6의 최대공약수보다 M이 클 수 없다.
	4와 28의 최대공약수는 4다. 
	
	5 /M + r
	14/M + r
	17/M + r
	23/M + r
	83/M + r
	
	(83-23)/M, (23-17)/M, (17-14)/M, (14-5)/M
	60, 6, 3, 9의 최대 공약수는 3
*/
