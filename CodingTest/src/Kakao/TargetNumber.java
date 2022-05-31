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
		
		//	�迭   depth        sum
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
	������ �ٲ��� �ʰ� ������ ���ϰ� ���� Ÿ�� �ѹ��� ���߾�� -> ��ͤ� DFS
	������ ����� �� ����
	��� ����Ǽ��� Ž���ϴٰ����ǿ� �´� �������� �����ؾ� �ϳ�/? �׷��� 20!�� �ʹ� ����Ǽ��� ����
	
	�迭�� ���� ���ؼ� ���� Ÿ�ٳѹ��� ��ġ�ϴ� ���� ã�ƶ�.
	
*/
