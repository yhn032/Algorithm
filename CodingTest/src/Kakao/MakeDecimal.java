package Kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeDecimal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int nums[] = { 1, 2, 7, 6, 4 };

		Solution9 s9 = new Solution9();

		int ans = s9.solution9(nums);

		System.out.println(ans);
	}

}

class Solution9 {
	static int cnt = 0;
	static List<Integer> list;

	public int solution9(int[] nums) {
		int answer = -1;
		int sum = 0;
		boolean visit[] = new boolean[nums.length];
		list = new ArrayList<Integer>();
		dfs(nums, visit, 0, sum);

		
		for(int i=0; i<list.size(); i++) {
			int num = list.get(i);
			if(isPrime(num)) {
				cnt++;
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

	private void dfs(int[] nums, boolean[] visit, int depth, int sum) {
		// TODO Auto-generated method stub

		if (depth == 3) {
			if (list.contains(sum)) {
				return;
			} else {
				list.add(sum);
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				sum += nums[i];
				dfs(nums, visit, depth + 1, sum);
				sum -= nums[i];
				visit[i] = false;
			}
		}
	}

}