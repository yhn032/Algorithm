package numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1929_소수구하기 {
	
	//일반적인 소수 구하기 방법
	/*
		2이상의 자연수를 자기 자신보다 작은 수로 나눴을 때, 나머지가 0이 아닌 수를 찾습니다. 
		문제의 두 수의 최대 범위가 1,000,000이므로 시간 초과가 날 수 있다. 
		일단 비교를 위해 시간초과가 나도록 문제를 풀어보겠다. 
	*/
	
	//시간초과가 나는 일반적인 방법
	/*
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		OUT:
		for(int i=M; i<N;i++) {
			for(int k=2; k<i;k++) {
				if(i%k == 0) {
					continue OUT; //추가하지 않고 다음으로 넘어감
				}
			}	
			sb.append(i).append(' ');
		}
		
		System.out.println(sb);
		
	}
	*/
	
	//시간 복잡도를 줄인 방법 2
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N+1];
		
		//0번지는 버리고 1은 어차피 소수가 아니니까 버림
		for(int i=2;i<=N;i++) {
			arr[i] = i;
		}
		
		//N의 제곱근 까지만 탐색하면 된다. 
		//N = a*a라고 가정할 때, a는 N의 제곱근보다 클 수 없다. 
		//예를 들어 16의 범위까지 소수를 구할 때, 16 = 4 * 4로 이뤄지면 16보다 작은 숫자는 항상 4보다 작은 약수를 갖게된다.
		//4보다 큰 약수는 4보다 작은 수의 배수로 지울 수 있습니다.
		for(int i=2;i<=Math.sqrt(N);i++) {
			if(arr[i]==0) continue;
			
			for(int k = i+i; k<=N; k+=i ) {//k의 배수값 지우기 이런식으로 내부 반복에서 값을 지우고 외부 반복에서 지워진 값을 건너 뛰면서 시간복잡도 줄이기 가능
				arr[k] = 0;
			}
		}
		
		/*
		 * for(int i=M;i<=N;i++){ if(arr[i] != 0) { System.out.print(i + " "); } }
		 */
		
		for(int i : arr) {
			if(i==0) continue;
			System.out.print(i + " ");
		}
		
	}
	
	

}
