package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12891_DNA {
	static int checkDNA[];
	static int currentDNA[];
	static int checkSecret;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		//���ڿ��� ũ�� S, �κ� ���ڿ��� ũ�� P
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		//���ǿ� �����ϴ� �������� ������ ������� ����
		int cnt = 0;
		
		//���ڿ� ������ 
		char DNA[] = new char[S];
		
		//��й�ȣ üũ �迭 -> ������ ������ ����ִ� ���� �迭 A C G T
		checkDNA = new int[4];
		
		//���� �κ� ���ڿ��� ���� �迭 -> ���� �κ� ���ڿ��� �̷�� ������ ������ �� ������ ����
		currentDNA = new int[4];
		
		//���� �迭�� ���¹迭�� ���ؼ� ���ǿ� �����ϴ� ������ ������ ���� ����
		checkSecret = 0;
		
		//���ڿ� �����͸� �Է¹޾Ƽ� ���ڿ� �迭�� ����� 
		DNA = br.readLine().toCharArray();

		//���ǹ迭 �ʱ�ȭ�ϱ�
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			checkDNA[i] = Integer.parseInt(st.nextToken());
			
			if(checkDNA[i] == 0) {
				//�������� �־����� ������ 0�����,,, -> ������ üũ�� �ʿ䰡 ����. 0������ ���ƾ� �Ѵٴ� ������ �񱳸� ���� �ʾƵ� �������� �ʴ°�? 
				//�̸� ī��Ʈ ���༭ �񱳸� �ִ��� �ٿ�����.
				checkSecret++;
			}
		}
		
		//���� �ʱ��� P �κ� ���ڿ��� ó���Ѵ�. 
		//���� ���� ���� ó������ ��ԵǴ� �κ� ���ڿ��� ����, ���¹迭�� �ʱ�ȭ ���ִ� �۾�
		for(int i=0; i<P; i++) {
			Add(DNA[i]);
		}
		
		//�ʱ� �����찡 ������ �����Ѵٸ� ī��Ʈ ����
		if(checkSecret == 4) cnt++;
		
		//���������� �����츦 �����̵� �ϴ� �κ�
		//���� �ʱ⿡ ������ ���뿡 ���ؼ��� ������ ��ȿ�� �˻縦 ������ ���������� �� ĭ �̵��Ѵ�.
		for(int i=P; i < S; i++) {
			int j = i-P;
			//�� ĭ ������ �̵��� �� ���� ������ ��ġ -> ���� ���� ����
			Add(DNA[i]);
			
			//�����ؾ��ϴ� ���� -> ���� �������� ��������
			Delete(DNA[j]);
			
			//��������� �����ϰ� ���� Ȯ��
			if(checkSecret == 4) cnt++;
		}
		
		System.out.println(cnt);
	}

	private static void Delete(char c) {
		// TODO Auto-generated method stub
		switch(c) {
		case 'A':
			//���� ���¹迭�� ������ ���̱� ���� ���¹迭�� ���ǹ迭�� ���Ҵٸ�, ������ ������ �������� ���ϰ� �ǹǷ� checksecret���� 1���� ��Ű�� ���¹迭�� �����Ѵ�.
			if(currentDNA[0] == checkDNA[0]) {
				checkSecret--;
			}
			currentDNA[0]--; //���� �迭 �󿡼� A�� ���� ������ ����
			break;
		case 'C':
			if(currentDNA[1] == checkDNA[1]) {
				checkSecret--;
			}
			currentDNA[1]--; 
			break;
			
		case 'G':
			if(currentDNA[2] == checkDNA[2]) {
				checkSecret--;
			}
			currentDNA[2]--; 
			break;
			
		case 'T':
			if(currentDNA[3] == checkDNA[3]) {
				checkSecret--;
			}
			currentDNA[3]--; 
			break;
			
	}
	}

	private static void Add(char c) {
		// TODO Auto-generated method stub
		switch(c) {
			case 'A':
				currentDNA[0]++; //���� �迭 �󿡼� A�� ���� ������ ����
				if(currentDNA[0] == checkDNA[0]) {
					//���¹迭�� ���ǹ迭���� Ŭ������ ++�� ���ָ� ���� ���ε��ö����� ���Ǹ� �����ϸ� ����ؼ� +�ǹǷ�, ó������ ���� �� �� ���� üũ�Ѵ�. 
					//������ �����찡 �����϶�, ���� ���°Ͱ� ���� ���ڿ� ���ؼ��� üũ�ϱ� ������ �ѹ��ڿ� ���� checkSecret���� ������ 1���� ũ�� �ʴ�.
					checkSecret++;
				}
				break;
			case 'C':
				currentDNA[1]++; //���� �迭 �󿡼� A�� ���� ������ ����
				if(currentDNA[1] == checkDNA[1]) {
					checkSecret++;
				}
				break;
				
			case 'G':
				currentDNA[2]++; //���� �迭 �󿡼� A�� ���� ������ ����
				if(currentDNA[2] == checkDNA[2]) {
					checkSecret++;
				}
				break;
				
			case 'T':
				currentDNA[3]++; //���� �迭 �󿡼� A�� ���� ������ ����
				if(currentDNA[3] == checkDNA[3]) {
					checkSecret++;
				}
				break;
				
		}
	}

}


/*
	�����̵� ������� 2���� �����ͷ� ������ ������ ����, ������ ������ä�� �̵��ϸ� ������ �ذ��մϴ�. 
	
	
	P�� S�� �ִ� ���̰� 1,000,000���� �ſ� ũ��. ��ø �ݺ��� ���� �ð��� �ʰ��ȴ�. �ݺ��� ���ο��� �ݺ�Ƚ���� ����ȭ�� ���� �ְ�����
	�ð����⵵�� O(n)���� �ٿ��� �� �ִ� �����̵� �����츦 ����غ��� 
	
	���� ���ڿ��� S�̰�, �κй��ڿ��� P�϶� 
	1. �ΰ��� ������ ������ ���ڿ��� ���̷� ��� �� ũ�⸦ �����Ѵ�.(������)
	2. ũ�⸦ ������ ���·� ������ �̵��ϸ鼭 ������ üũ�Ѵ�.(�����̵�)
	�̷����ϸ� �迭S�� ���̸�ŭ�� Ž���ϸ� �ǹǷ� O(n) �𰡴�
 */