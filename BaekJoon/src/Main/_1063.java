package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1063 {
				      //    R	     L	     T		  B		RB		RT	  LB    	LT			(x,y)�̵� ��
	static int temp[][] = {{1,0}, {-1,0}, {0,-1}, {0,1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//char a = 'B';
		//System.out.printf("%d", 70-a);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//int [][]game_pan = new int[8][8];
		//�� ���� ���� �빮��, 0���� (�������� ���� ������) A 
		//�� ���� ����     , 0���� (�������� ���� ����)	1	
		String king_pos = st.nextToken();
		String stone_pos = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		
		
		//���ɾ� �迭
		String command[] = new String[N];
		
		for(int i=0; i<N;i++) {
			command[i] = br.readLine();
		}
		
		//���ڿ��� int�� �ٲٸ� ascii�ڵ� ���� ���´�,,
		//ŷ�� �࿭ ������ ��ȯ
		int king_pos_x = (king_pos.charAt(0) - 65); //A~H -> 0~7
		int king_pos_y = (8-Math.abs(Integer.parseInt(king_pos.substring(1)))); //   8~1 -> 0~7
		
		//���� �࿭ ������ ��ȯ
		int stone_pos_x = (stone_pos.charAt(0) - 65); //A~H -> 0~7
		int stone_pos_y = (8-Math.abs(Integer.parseInt(stone_pos.substring(1)))); //   8~1 -> 0~7

		
		
		for(String s : command) {
			int idx = move_idx(s);
			boolean flag = false;
			
			//temp[idx]�� �ش��ϴ� ������ ������ �� �ִٸ�,,
			if(check_move(idx, king_pos_x, king_pos_y)) {
				
				//���� ��ġ�� �ű�� ���� ���� �˻� ����
				int tempXX = king_pos_x + temp[idx][0];
				int tempYY = king_pos_y + temp[idx][1];
				
				//���� ���� �� �̵�"��" ���� ���� �ִٸ�,,,
				if(tempXX==stone_pos_x && tempYY == stone_pos_y) {
					//ŷ�� ������ �ź��̵� �̵��ؾ� �ϹǷ�, �ź��̰� �̵��� �� �ִ��� ���� �˻�
					if(check_move(idx, stone_pos_x, stone_pos_y)) {
						//������ ��� ����ϸ� �̵���Ű�� 
						//�� ��ġ�� ŷ �̵�
						king_pos_x = stone_pos_x;
						king_pos_y = stone_pos_y;
						//���� ŷ�� ���� �������� �̵� 
						stone_pos_x += temp[idx][0];
						stone_pos_y += temp[idx][1];
					}
					flag = true;
				} 
				if(!flag)
				{//�̵��� �� �ִµ� ���� ���ٸ�
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
	

	//���� ����
	//1. �ε����� ������ �Ѿ�� command ���� x. �̰� ����. ������ ���õǸ� �ź��̵� ������ �ʿ䰡 ����
	//2. ���� ������ ���� �������� ���� �̵�
	//3. �ź��̰� �ε����� ������ �Ѿ�� ŷ�� �̵��Ұ�

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