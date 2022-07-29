package Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeepDistance {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String [][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
							  {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
							  {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
							  {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
							  {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		
		Solution11 s11 = new Solution11();
		
		int ans[];
		ans = s11.solution11(places);
		
		for(int i : ans) {
			System.out.print(i + " ");
		}
	}
}


class Solution11 {
	static int[] dx = {-1, 1,  0, 0};
    static int[] dy = { 0, 0, -1, 1};
    static boolean visit[][];
    static char map[][];
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution11(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        
        
        for(int k = 0; k<5; k++){
            visit    = new boolean[5][5];
            map        = new char[5][5];

            for(int i=0; i<5; i++){
                map[i] = places[k][i].toCharArray();
            }
            
            OUT:
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(map[i][j] == 'P'){
                        if(!bfs(i, j)){
                            answer[k] = 0;
                            break OUT;
                        }
                    }
                }
            }
            
            
        }
        
        return answer;
    }
    
    private boolean bfs(int x, int y) {
		// TODO Auto-generated method stub
    	Queue<Node> q = new LinkedList<>();
    	visit[x][y] = true;
        q.add(new Node(x, y));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int i=0; i<4;i++){
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];
                
                if(xx < 0 || yy < 0 || xx >= 5 || yy >= 5) continue;
                if(map[xx][yy] == 'X' || visit[xx][yy]) continue;
                
                int dist = Math.abs(xx-x)+Math.abs(y-yy);
                if(map[xx][yy] == 'P' && dist <= 2){
                    return false;
                }
                visit[xx][yy] = true;
                q.add(new Node(xx, yy));
            }
        }
        
        return true;
       
	}

	
}

