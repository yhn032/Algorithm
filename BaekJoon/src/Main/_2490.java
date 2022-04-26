package Main;

import java.util.Scanner;

public class _2490 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		//StringBuilder sb = new StringBuilder();
		
		/* 规过1
		for(int i=0; i<3;i++) {
			int yuut_count = 0;
			st = new StringTokenizer(br.readLine()," ");
			int [] yuut = new int[4];

			for(int k =0; k < 4; k++) {
				yuut[k] = Integer.parseInt(st.nextToken());
				if(yuut[k] == 1) {
					yuut_count++;
				}
			}
			switch(yuut_count) {
				case 0:
					sb.append('D').append('\n');
					break;
				case 1:
					sb.append('C').append('\n');
					break;
				case 2:
					sb.append('B').append('\n');
					break;
				case 3:
					sb.append('A').append('\n');
					break;
				case 4:
					sb.append('E').append('\n');
					break;
			}
		}
		*/
		/*规过 2
		Pattern pat = Pattern.compile("(1)");
		int N = 3;
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		while(N--> 0) {
			int count =0;
			//String yuut = sc.nextLine();
			//String [] arr = yuut.split("[^1]+");

			Matcher mat = pat.matcher(sc.nextLine());
			
			while(mat.find()) {
				count++;
			}
			
			switch(count) {
				case 0: sb.append('D').append('\n'); break;
				case 1: sb.append('C').append('\n'); break;
				case 2: sb.append('B').append('\n'); break;
				case 3: sb.append('A').append('\n'); break;
				case 4: sb.append('E').append('\n'); break;
			}
			
			
		}
		System.out.println(sb);
		*/
		
		//规过 3
		int N = 3;
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		while(N--> 0) {
			String yuut = sc.nextLine();
			String [] arr = yuut.split("[^1]+");
			
			int size = arr.length;
			if(yuut.charAt(0) == '0') {
				size -= 1;
			} 

			//System.out.println(size);
			
			
			switch(size) {
			case 1: sb.append('C').append('\n'); break;
			case 2: sb.append('B').append('\n'); break;
			case 3: sb.append('A').append('\n'); break;
			case 4: sb.append('E').append('\n'); break;
			default: sb.append('D').append('\n'); break;
			}
				
			
		}
		System.out.println(sb);
		sc.close();
		
	}

}
