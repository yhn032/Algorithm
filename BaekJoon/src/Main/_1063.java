package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1063 {
				      //    R	     L	     T		  B		RB		RT	  LB    	LT			(x,y)이동 값
	static int temp[][] = {{1,0}, {-1,0}, {0,-1}, {0,1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//char a = 'B';
		//System.out.printf("%d", 70-a);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//int [][]game_pan = new int[8][8];
		//각 열은 영문 대문자, 0번지 (게임판의 가장 왼쪽이) A 
		//각 행은 숫자     , 0번지 (게임판의 가장 밑이)	1	
		String king_pos = st.nextToken();
		String stone_pos = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		
		
		//명령어 배열
		String command[] = new String[N];
		
		for(int i=0; i<N;i++) {
			command[i] = br.readLine();
		}
		
		//문자열은 int로 바꾸면 ascii코드 값이 나온다,,
		//킹의 행열 참조값 변환
		int king_pos_x = (king_pos.charAt(0) - 65); //A~H -> 0~7
		int king_pos_y = (8-Math.abs(Integer.parseInt(king_pos.substring(1)))); //   8~1 -> 0~7
		
		//돌의 행열 참조값 변환
		int stone_pos_x = (stone_pos.charAt(0) - 65); //A~H -> 0~7
		int stone_pos_y = (8-Math.abs(Integer.parseInt(stone_pos.substring(1)))); //   8~1 -> 0~7

		
		
		for(String s : command) {
			int idx = move_idx(s);
			boolean flag = false;
			
			//temp[idx]에 해당하는 명령을 수행할 수 있다면,,
			if(check_move(idx, king_pos_x, king_pos_y)) {
				
				//실제 위치를 옮기기 전에 조건 검사 먼저
				int tempXX = king_pos_x + temp[idx][0];
				int tempYY = king_pos_y + temp[idx][1];
				
				//명령 수행 후 이동"할" 곳에 돌이 있다면,,,
				if(tempXX==stone_pos_x && tempYY == stone_pos_y) {
					//킹이 왔으니 거북이도 이동해야 하므로, 거북이가 이동할 수 있는지 조건 검사
					if(check_move(idx, stone_pos_x, stone_pos_y)) {
						//조건을 모두 통과하면 이동시키기 
						//돌 위치로 킹 이동
						king_pos_x = stone_pos_x;
						king_pos_y = stone_pos_y;
						//돌도 킹과 같은 방향으로 이동 
						stone_pos_x += temp[idx][0];
						stone_pos_y += temp[idx][1];
					}
					flag = true;
				} 
				if(!flag)
				{//이동할 수 있는데 돌이 없다면
					king_pos_x += temp[idx][0];
					king_pos_y += temp[idx][1];
				}
				
			}
			//System.out.println(king_pos_x);
		}//end-for
		String result_king_pos  = String.valueOf((char)(king_pos_x + 65))  + String.valueOf(8-king_pos_y);
		String result_stone_pos = String.valueOf((char)(stone_pos_x + 65)) + String.valueOf(8-stone_pos_y);
		
		System.out.println(result_king_pos);
		System.out.println(result_stone_pos);
	}
	

	//조건 순서
	//1. 인덱스의 범위를 넘어가면 command 실행 x. 이걸 먼저. 명령이 무시되면 거북이도 움직일 필요가 없음
	//2. 돌과 만나면 같은 방향으로 돌도 이동
	//3. 거북이가 인덱스의 범위를 넘어가면 킹도 이동불가

	private static boolean check_move(int idx, int move_x, int move_y) {
		// TODO Auto-generated method stub
		move_x += temp[idx][0];
		move_y += temp[idx][1];
		
		return move_x >=0 && move_x<8 && move_y >=0 && move_y<8;
	}

	private static int move_idx(String s) {
		// TODO Auto-generated method stub
		int idx=0;
		switch(s) {
			case "R":  idx=0; break;
			case "L":  idx=1; break;
			case "T":  idx=2; break;
			case "B":  idx=3; break;
			case "RB": idx=4; break;
			case "RT": idx=5; break;
			case "LB": idx=6; break;
			case "LT": idx=7; break;
		}
		return idx;
	}



}
