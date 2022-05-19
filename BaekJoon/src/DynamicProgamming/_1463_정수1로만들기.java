package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1463_정수1로만들기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int x = Integer.parseInt(br.readLine());
		
		//arr[i]는 i를 1로 만드는데 필요한 최소 연산 횟수를 저장할 배열
		int arr[] = new int[x+1];
		
		arr[1]=0; //1을 1로 만드는데 연산은 불필요.
		
		//점화식을 사용한 bottomup
		for(int i=2 ; i<=x;i++) {
			arr[i] = arr[i-1] + 1;
			if(i % 2 ==0) {
				arr[i] = Math.min(arr[i], arr[i/2]+1);
			}
			if(i % 3 ==0) {
				arr[i] = Math.min(arr[i], arr[i/3]+1);
			}
		}
		System.out.println(arr[x]);
	}

}

