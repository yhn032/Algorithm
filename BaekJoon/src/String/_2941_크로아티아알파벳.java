package String;

/*
	������ ���ڴ� 1���� ī��Ʈ�Ѵ�.
	c=
	c-
	dz=
	d-
	lj
	nj
	s=
	z=
	
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2941_ũ�ξ�Ƽ�ƾ��ĺ� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		//�ݺ�Ƚ�� - ������ ����
		int r = str.length();
		//ũ�ξ�Ƽ�� ���ڸ� ����� ����
		int count = 0;
		
		//i < r-1�ΰ�츸 �˻��ؾ� outofindex�� ������ ����
		for(int i=0; i<r;i++) {
			if(str.charAt(i) == 'c' && i < r-1) {
				if(str.charAt(i+1) == '-' || str.charAt(i+1) == '=') {
					i++;
				}
			}else if(str.charAt(i) == 'd' && i < r-1) {
				if(str.charAt(i+1) == '-') {//d-�ΰ��
					i++;
				}else if(str.charAt(i+1)=='z' && i < r-2) {
					if(str.charAt(i+2) == '=') {//dz=�ΰ��
						i+=2;
					}
					
				}
			}else if((str.charAt(i) == 'l' || str.charAt(i) == 'n') && i < r-1) {
				if(str.charAt(i+1) == 'j') {
					i++;
				}
			}else if((str.charAt(i) == 's' || str.charAt(i) == 'z') && i < r-1) {
				if(str.charAt(i+1) == '=') {
					i++;
				}
			}
			
			count++;
		}
		System.out.println(count);
	}

}