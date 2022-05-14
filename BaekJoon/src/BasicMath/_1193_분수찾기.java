package BasicMath;

import java.util.Scanner;

public class _1193_분수찾기 {
	static int x,y, n;
	static int where;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		// X가 최대인경우 4472개의 줄까지 만들어진다.

		//X가 몇 번째 줄에 있냐?
		int i = 1;
		while (true) {
			if (n <= hap(i)) {
				where = i;
				break;
			}
			i++;

		}
		int start = hap(where-1);
		int end = hap(where);
		
		find_select_index(start, end);
		
		System.out.println((x+1) + "/" + (y+1));

	}

	private static void find_select_index(int start, int end) {
		// TODO Auto-generated method stub
		int dx;
		int dy;
		
		if(where % 2 == 0) {//짝수라면
			dx = 0;
			dy = where-1;
			
			for(int i=(start+1); i<= end; i++) {
				if(i == n) {
					x = dx;
					y = dy;
					return;
				}
				dx += 1;
				dy -= 1;
				
			}
			
		}else {//홀수라면
			dx = where-1;
			dy = 0;
			
			for(int i=(start+1); i<= end; i++) {
				if(i == n) {
					x = dx;
					y = dy;
					return;
				}
				dx -= 1;
				dy += 1;
				
			}
		}
	}

	private static int hap(int n) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}

		return sum;
	}
}

/*
 * 탐색 순서를 살펴보자 (배열의 인덱스를 기준으로 좌표의 쌍으로 표현하겠다.)
 * 
 * 2x + 1y + 1 = i
 * 
 * 01번 : (0,0) 1/1 02번 : (0,1) 1/2 03번 : (1,0) 2/1 04번 : (2,0) 3/1 05번 : (1,1)
 * 2/2 06번 : (0,2) 1/3 07번 : (0,3) 1/4 08번 : (1,2) 2/3 09번 : (2,1) 3/2 10번 :
 * (3,0) 4/1 11번 : (4,0) 5/1 12번 : (3,1) 4/2 13번 : (2,2) 3/3 14번 : (1,3) 2/4 15번
 * : (0,4) 1/5
 * 
 * 
 * 반복 과정 진행[사고 방식 1 -> x와 y의 관계를 통해서 몇 번째인지 구할 수 있을 까?] x += 1, y -=1 if x = 0이면
 * y만 1증가시키고 기본 반복 진행//얘가 먼저 조건 등장해야함 초기 출발위치가 오른쪽으로 가기 때문 if y = 0이면 x만 1증가시키고
 * 기본 반복 진행
 * 
 * X번째 분수를 찾을 때, X번째 분수가 위치한 좌표만 찾으면 그 안에 저장된 분수를 구할 수 있다. -> 배열을 안만들어도 될 것도
 * 같은데? 답은 X번째 분수가 저장된 좌표가 x,y라고 할 때, x+1/y+1
 * 
 * [사고방식 2] 1번째 대각선 줄 - 1개 2번째 대각선 줄 - 2개 3번째 대각선 줄 - 3개 4번째 대각선 줄 - 4개 5번째 대각선
 * 줄 - 5개 ... n번째 대각선 줄 - n개
 * 
 * 홀수 번째 줄은 대각선의 오른쪽 위에서, 짝수 번째 줄은 대각선의 왼쪽 위에서 방 번호가 시작한다.
 * 
 * ex -> X = 14라면 15(1~5까지의 합)보다 작음 && 10(1~4까지의 합보다 큼) -> 5번째 대각선 줄에 존재한다. 홀수번째
 * 이므로 대각선의 왼쪽 아래서부터 시작한다. 시작 번지수는 5번째 대각선의 첫번째 이므로 -> (5-1,0) 시작 번지수는 4번째 대각선의
 * 첫번째이므로 -> (0, 4-1)
 * 
 * 일반화 홀수인경우 시작 번지수는 (n-1,0) 짝수인 경우 시작 번지수는 (0,n-1)
 * 
 * 1. X번째 수가 몇 번째 줄인지를 찾는다. 2. 몇 번째 줄인지 찾았다면 시작 번지를 기준으로 X가 몇번째인지 찾는다. 3. 좌표를
 * 구했다면 답은 나온셈이다.
 */
