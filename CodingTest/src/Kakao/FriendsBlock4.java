package Kakao;

import java.util.ArrayList;

public class FriendsBlock4 {
	static class Solution7 {
		public int solution7(int m, int n, String[] board) {
			int answer = 0;
			
			//게임판의 크기만큼 방문여부를 저장할 상태배열 생성
			boolean visited[][] = new boolean[m][n];
			char map[][] = new char[m][n];
			int count = 0;//지울 수 있는 2x2 블록 개수.
			//게임판을 2차원 배열로 재구성
			for(int i=0; i<m; i++) {
				map[i] = board[i].toCharArray();
			}
			/*
			 * for(char[] s : map) { for(char ss : s) { System.out.print(ss + " "); }
			 * System.out.println(); }
			 */
			//0,0부터 탐색을 시작해보자 
			//하나의 블록에서 좌 하 좌하를 비교할 것이기 때문에 반복횟수의 최대값을 1개 줄인다.
			while(true) {
				count = 0;
				for(int i=0; i<m-1;i++) {
					for(int k=0; k<n-1; k++) {
						char temp = map[i][k];
						//'0'은 빈공간
						if(temp != '0' && temp == map[i+1][k] && temp == map[i][k+1] && temp == map[i+1][k+1]) {
							visited[i][k] = true;		//현재위치
							visited[i+1][k] = true;		//한칸 밑
							visited[i][k+1] = true;		//오른쪽
							visited[i+1][k+1] = true;	//오른쪽 아래
							count++;
						}
					}//end -for k
				}//end-for i
				//모든 노드에 대해 boolean 표시 끝, 나머지는 default값 false
				if(count == 0) {
					break;
				}
				for(int i =0; i<m; i++) {
					ArrayList<Character> list = new ArrayList<Character>();
					for(int k=n-1; k>=0; k--) {
						if(!visited[i][k]) {
							list.add(map[i][k]);
						} else {
							answer++; //빈공간의 영역 카운트
						}
					}
					for(int k=n-1, idx=0; k>=0;k--, idx++) {
						if(idx<list.size()) {
							map[k][i] = list.get(idx);
						} else {
							map[k][i] = '0';
						}
					}
				}
				
			}//end-while
			
			
			return answer;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 4;
		int n = 5;
		String board[] = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		
		Solution7 s7 = new Solution7();
		int answer = s7.solution7(m, n, board);
		
		System.out.println(answer);
	}

}
