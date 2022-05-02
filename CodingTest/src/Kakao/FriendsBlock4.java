package Kakao;

import java.util.ArrayList;
import java.util.List;

public class FriendsBlock4 {
	static char map[][];
	static int ans_count;
	
	static class Solution7 {
		public int solution7(int m, int n, String[] board) {
		    int answer = 0;
		    map = new char[m][n];
		    //�� �ʱ�ȭ 
		    for(int i=0; i<m; i++){
		        for(int j=0; j<n; j++)
		        {
		            map[i][j] = board[i].charAt(j);   
		        }  
		    }
		    while(updateBlocks(m,n))
		    
		    answer += ans_count;
		        
		    return answer;
		}
	    
		public boolean updateBlocks(int x, int y){
		    boolean flag[][] = new boolean[x][y];
		    int cnt=0;
		    ans_count=0;
		    
		    //�� ��ǥ���� ��, �ϸ� �˻��ϱ⶧���� �迭�� ũ�⸦ 1 �ٿ��� �˻��ϱ�.
		    for(int i=0; i<x-1; i++){
		        for(int j = 0; j<y-1;j++){
		            if(map[i][j] == '0'){
		                continue;
		            } else if(check(i,j)){
		                flag[i][j] = true;
		                flag[i+1][j] = true;
		                flag[i][j+1] = true;
		                flag[i+1][j+1] = true;
		            }
		        }
		    }
		    //�� ���� ���� �ؿ������� flag�� true�� �͸� ������ ����, �װ͸� �����Ͽ� arraylist�� �����Ѵ�.
		    for(int i = 0; i < y; i++) {
				List<Character> temp = new ArrayList<>();
				for(int j = x-1; j >= 0; j--) {
					if(flag[j][i] == true) {
						cnt++;
						continue;
					}
					temp.add(map[j][i]);
				}
				//map �籸���ϱ�, idx k���� ����Ʈ�� ��� ������ ũ�� �����ϰ�, �ƴϸ� 0�� �� ����� ǥ���ϱ�
				for(int j = x-1, k = 0; j >= 0; j--, k++) {
					if(k < temp.size())	map[j][i] = temp.get(k);
					else map[j][i] = '0';
				}
			}
			
			ans_count += cnt;
		    //true���� 4���� ����� ���� ������ �� ���� true�� �ֱ� ������, true���� �ִٴ� ���� ������ �װ��� ����� �����Ѵٴ� ��, true�� �ִٸ� �ݺ��ؼ� map�� ��������� �ϰ�, 0�̶�� ���̻� ������ map�� ���ٴ� ��
		    
			return cnt > 0 ? true : false;
		}
		
		public boolean check(int i, int j) {
			char std = map[i][j];
			//���� ��ġ���� ��, ��, ������ �׸��� ���ٸ�,,,
				if(map[i][j+1] == std && map[i+1][j] == std && map[i+1][j+1] == std) return true;
				return false;
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
