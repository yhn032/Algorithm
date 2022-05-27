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
		//1 ~ N ���ӵ� ���� �� N
		
		//1���� N���� �ΰ��� �����ͷ� �̵��ϱ� ���� �����۾� 
		//count1�� �ϴ� ������ end_idx == N�ΰ�� �ٷ� Ż�⸸ �ϱ� ���ؼ� �̸� ī��Ʈ
		int count = 1;
		int start_idx = 1;
		int end_idx = 1;
		int sum = 1;
		//�ϳ��� �ݺ����� �����Ͱ� ���ÿ� ������ �� �־�� �Ѵ�. 
		
		
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
