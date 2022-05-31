package Kakao;

public class TargetNumber {
	
	public static void main(String[] args) {
		int [] numbers = {4, 1, 2, 1};
		
		Solution8 s8 = new Solution8();
		
		int target=4;
		
		int answer=0;
		
		answer = s8.solution8(numbers, target);
		
		System.out.println(answer);
	}
}

class Solution8{
	static int count;
	public int solution8(int [] numbers, int target) {
		int answer = 0;
		
		//	배열   depth        sum
		dfs(numbers, 0, target, 0);
		
		answer = count;
		
		
        return answer;
	}

	private void dfs(int[] numbers, int depth, int target, int sum) {
		// TODO Auto-generated method stub
		
		//base case 
		if(depth == numbers.length) {
			
			if(sum == target) {
				count++;
			}
			
		}//recursive-case
		else {
			
			dfs(numbers, depth+1, target, sum + numbers[depth]);
			dfs(numbers, depth+1, target, sum - numbers[depth]);
			
		}
		
		
	}
}

/*
	순서를 바꾸지 않고 적절히 더하고 빼서 타겟 넘버를 맞추어라 -> 재귀ㅣ DFS
	정렬을 사용할 수 없음
	모든 경우의수를 탐색하다가조건에 맞는 내용으로 종료해야 하나/? 그러면 20!로 너무 경우의수가 많음
	
	배열의 값을 더해서 합이 타겟넘버와 일치하는 값을 찾아라.
	
*/
