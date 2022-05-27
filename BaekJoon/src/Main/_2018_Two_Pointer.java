package Main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2018_Two_Pointer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[5];
		Arrays.fill(arr, 1);
		// 0 1 2 3 4
		// 1 1 1 1 1
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		//1 ~ N 연속된 수의 합 N
		
		//1부터 N까지 두개의 포인터로 이동하기 위한 사전작업 
		//count1을 하는 이유는 end_idx == N인경우 바로 탈출만 하기 위해서 미리 카운트
		int count = 1;
		int start_idx = 1;
		int end_idx = 1;
		int sum = 1;
		//하나의 반복에서 포인터가 동시에 움직일 수 있어야 한다. 
		
		
		//N = 5
		//1 2 3 4 5
	//  s         0
	//	e         0
		
		
	//	s 0   
	//	e         0
		
		while(end_idx != N) {
			
			if(sum == N) {
				count++;
				end_idx++;
				sum += end_idx;
			} else if(sum > N) {
				sum -= start_idx;
				start_idx++;
			} else { //sum < N
				end_idx++;
				sum += end_idx;
			}
		}
		
		System.out.println(count);
		
	}

}
