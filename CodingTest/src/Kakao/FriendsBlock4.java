package Kakao;

import java.util.ArrayList;

public class FriendsBlock4 {
	static class Solution7 {
		public int solution7(int m, int n, String[] board) {
			int answer = 0;
			
			//�������� ũ�⸸ŭ �湮���θ� ������ ���¹迭 ����
			boolean visited[][] = new boolean[m][n];
			char map[][] = new char[m][n];
			int count = 0;//���� �� �ִ� 2x2 ��� ����.
			//�������� 2���� �迭�� �籸��
			for(int i=0; i<m; i++) {
				map[i] = board[i].toCharArray();
			}
			/*
			 * for(char[] s : map) { for(char ss : s) { System.out.print(ss + " "); }
			 * System.out.println(); }
			 */
			//0,0���� Ž���� �����غ��� 
			//�ϳ��� ��Ͽ��� �� �� ���ϸ� ���� ���̱� ������ �ݺ�Ƚ���� �ִ밪�� 1�� ���δ�.
			while(true) {
				count = 0;
				for(int i=0; i<m-1;i++) {
					for(int k=0; k<n-1; k++) {
						char temp = map[i][k];
						//'0'�� �����
						if(temp != '0' && temp == map[i+1][k] && temp == map[i][k+1] && temp == map[i+1][k+1]) {
							visited[i][k] = true;		//������ġ
							visited[i+1][k] = true;		//��ĭ ��
							visited[i][k+1] = true;		//������
							visited[i+1][k+1] = true;	//������ �Ʒ�
							count++;
						}
					}//end -for k
				}//end-for i
				//��� ��忡 ���� boolean ǥ�� ��, �������� default�� false
				if(count == 0) {
					break;
				}
				for(int i =0; i<m; i++) {
					ArrayList<Character> list = new ArrayList<Character>();
					for(int k=n-1; k>=0; k--) {
						if(!visited[i][k]) {
							list.add(map[i][k]);
						} else {
							answer++; //������� ���� ī��Ʈ
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
