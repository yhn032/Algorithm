package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class _11053_LIS_BinarySearch {
	static int dp[];
	static int arr[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n];
		
		//dp배열에는 최장 증가 배열을 저장한다.
		dp[0] = arr[0];
		int lengthLIS=1;//초기값이 있으므로 1부터 시작
		
		for(int i=1; i<n; i++) {
			
			//초깃값은 넣었으니 비교할 필요가 없다.
			//key는 dp에 넣어도 될지 안될지를 판단하고자할 수
			int key = arr[i];
			
			if(dp[lengthLIS-1] < key) {
				//들어오고자 하는 값이 가장 마지막에 들어온 값보다 크다면,, 추가해라
				lengthLIS++;
				dp[lengthLIS-1] = key;
			}else { 
				//들어오고자 하는 값이 가장 마지막에 들어온 값보다 작다면 
				//dp에 있는 값중에서 들어오고자 하는 값과의 차이가 최소인 값을 찾아서 값을 바꾼다.그래야 같은 방식으로 수와 수 사이에 또 다른 수가 들어오면서 길이를 늘릴 수 있다.
				//이분탐색으로 lowerbound를 찾는다. 
				
				int min = 0; 
				int max = lengthLIS;
				
				while(min < max) {
					int mid = (min+max)/2;
					
					if(dp[mid] < key) {
						min = mid+1;
					}else {
						max = mid;
					}
				}
				
				dp[min] = key;
				
			}
		}
		
		System.out.println(lengthLIS);
		
	}

}
