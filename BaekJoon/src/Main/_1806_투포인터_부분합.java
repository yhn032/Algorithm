package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1806_투포인터_부분합 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//이중 반복불가 -> 두개의 포인터를 사용해서 한번의 반복을 해야함
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int start_idx = 0;
		int end_idx = 0;
		int sum = arr[0];
		
		int min = 100000000;
		
		//종료 조건을 명확하게 명시했어야 했다. 
		/*
			end_idx가 끝에 도달했는데, 현재 부분합이 S보다 작다면 더이상의 경우의 수가 없으니 그냥 종료하면 됨
			end_idx가 끝에 도달했는데, 현재 부분합이 S보다 크거나 같다면 최소의 길이를 구할때까지 start_idx를 늘려가면서 길이를 최소화 시킨다.
			그러다가 어느 시점에서 최소길이를 구하면 그 다음 start_idx에서는 sum이 S보다 작아지는 타이밍이 올텐데, 첫줄에 말한대로 종료하면 된다. 
			
			
		*/
		while(start_idx <= N-1) {
			if(sum < S) {
				if(end_idx==N-1) {
					end_idx = N-1;
					break;
					/*
					 * int temp = end_idx - start_idx+1; min = temp < min ? temp : min; sum -=
					 * arr[start_idx]; start_idx++;
					 */
				} else {
					end_idx++;
					sum += arr[end_idx];
				}
			} else { //sum >= S
				//end_idx를 계속 증가시켜봤자 조건은 만족하지만 길이가 늘어나므로, 최솟값을 구하려는 시점에서 그닥 필요치 않음
				//처음으로 조건을 만족하는 인덱스에서 길이를 구하고 최솟값과 비교한다.
				//부분합의 길이를 구하자 
				int temp = end_idx - start_idx+1;
				min = temp < min ? temp : min;
				sum -= arr[start_idx];
				start_idx++;
			}
		}
		if(min == 100000000) {
			System.out.println(0);
		} else {
			System.out.println(min);
			
		}
		
		
		br.close();
	}

}
