package Kakao;

import java.util.List;

public class MakeDecimal2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int nums[] = { 1, 2, 3, 4 };

		Solution10 s10 = new Solution10();

		int ans = s10.solution10(nums);

		System.out.println(ans);
	}

}

class Solution10 {
	static int cnt = 0;
	static List<Integer> list;

	public int solution10(int[] nums) {
		int answer = -1;
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				for(int k=j+1; k<nums.length; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					
					if(isPrime(sum)) {
						cnt++;
					}
				}
			}
		}
		

		answer = cnt;
		return answer;
	}

	private boolean isPrime(int num) {
		// TODO Auto-generated method stub

		// 에라토스테네스의 체
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		
		return true;
	}

}