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
		    //맵 초기화 
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
		    
		    //한 좌표에서 우, 하를 검사하기때문에 배열의 크기를 1 줄여서 검사하기.
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
		    //각 열의 가장 밑에서부터 flag가 true인 것만 개수를 세고, 그것만 제외하여 arraylist에 삽입한다.
		    for(int i = 0; i < y; i++) {
				List<Character> temp = new ArrayList<>();
				for(int j = x-1; j >= 0; j--) {
					if(flag[j][i] == true) {
						cnt++;
						continue;
					}
					temp.add(map[j][i]);
				}
				//map 재구성하기, idx k보다 리스트의 요소 개수가 크면 삽입하고, 아니면 0을 찍어서 빈공간 표현하기
				for(int j = x-1, k = 0; j >= 0; j--, k++) {
					if(k < temp.size())	map[j][i] = temp.get(k);
					else map[j][i] = '0';
				}
			}
			
			ans_count += cnt;
		    //true값은 4개의 블록이 같을 때마다 한 번에 true를 주기 때문에, true값이 있다는 것은 동일한 네개의 블록이 존재한다는 뜻, true가 있다면 반복해서 map을 갱신해줘야 하고, 0이라면 더이상 갱신할 map이 없다는 것
		    
			return cnt > 0 ? true : false;
		}
		
		public boolean check(int i, int j) {
			char std = map[i][j];
			//현재 위치에서 우, 하, 우하의 그림이 같다면,,,
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
