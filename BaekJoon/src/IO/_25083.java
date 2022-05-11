package IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25083 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String[] temp = new String[6];
		
		temp[0] = "         ,r'\"7";
		temp[1] = "r`-_   ,'  ,/";
		temp[2] = " \\. \". L_r'";
		temp[3] = "   `~\\/";
		temp[4] = "      |";
		temp[5] = "      |";
		for(int i=0 ;i<6; i++) {
			System.out.println(temp[i]);
		}
	}

}

