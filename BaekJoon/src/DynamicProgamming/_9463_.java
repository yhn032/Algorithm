package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _9463_ {
	
	static int N;
	static int [][]sticker;
	static int [][]DP;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		//�뀒�뒪�듃 耳��씠�뒪留뚰겮 諛섎났
		while(T --> 0) {
			
			//�뿴�쓽 媛쒖닔
			N = Integer.parseInt(br.readLine());
			sticker = new int[2][N];
			
			//�뒪�떚而� �젏�닔 珥덇린�솕
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			DP = new int[N][3];
			//-1濡� �꽭�똿
			for(int []i : DP) Arrays.fill(i, -1);
			
			
			
			int max = detachingSticker(0, 0);
			sb.append(max).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int detachingSticker(int k, int left) {
		// TODO Auto-generated method stub
		if(k==N) return 0;
		if(DP[k][left] != -1) return DP[k][left];
		
		int sum = detachingSticker(k+1, 0);
		if(left != 1) sum = Math.max(sum, sticker[0][k] + detachingSticker(k+1, 1));
		if(left != 2) sum = Math.max(sum ,sticker[1][k] + detachingSticker(k+1, 2));
		
		DP[k][left] = sum;
		
		return sum;
	}
}
