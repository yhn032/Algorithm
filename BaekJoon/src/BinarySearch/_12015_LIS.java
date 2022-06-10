package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12015_LIS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int []arr = new int[n];
		int []lis = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//초기값은 그대로 넣어주고, 값을 비교하면서 추가한다. 
		//들어오려는 값이 가장 큰 값보다 크다면 추가 
		//들어오려는 값이 가장 큰 값보다 작다면 들어오려는 갑과 가장 가까운 값과 대치
		
		lis[0] = arr[0];
		int lengthLIS=1;
		
		for(int i=1; i<n; i++) {
			
			//초깃값을 그대로 넣었으니 그 다음 부터 시작 
			//key는 최장증가수열에 들어오고자 하는 값이다. 
			int key = arr[i];
			
			
			//lis의 가장 마지막값. 보다 들어오고자 하는 값이 더 크다면 추가""
			if(lis[lengthLIS-1] < key) {
				lengthLIS++;
				lis[lengthLIS-1] = key;
			}else {
				//key값과 차이가 최소가 되도록하는 값 -> lower bound찾기 
				
				int min = 0;
				int max = lengthLIS;
				while(min < max) {
					int mid = (min+max)/2;
					
					if(lis[mid] < key) {
						min = mid+1;
					}else {
						max = mid;
					}
				}
				
				lis[min] = key; //값 대치하기
			}
		}
		
		
		System.out.println(lengthLIS);
		
	}

}
//추가가 아닌 대치. 
//상호 간의 값의 차이를 최소화 시켜야만 더 다양한 수가 빼곡하게 들어와서 증가하는 부분수열의 요소를 늘릴 수 있더. -> 길이