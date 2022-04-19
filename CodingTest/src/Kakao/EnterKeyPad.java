package Kakao;

class Solution {
    public static int calcDist(int location, int value){
        //���� 0�̰ų� ���� ��ġ�� 0�̸� Ű���� �ε��� �� 11�� �־��ش�. 
        if(value == 0){
            value = 11;
        }
        if(location == 0){
            location = 11;
        }
        //�޼�, ������ ��ǥ ���ϱ� 
        //location-1�� ���༭ �ε����� 0base�� ����� �ڽ����κ��� �Ÿ��� 1���ͽ����� �ƴ� 0���� �����Ѵ�.
        int locationX = (location-1)/3;
        int locationY = (location-1)%3;
        
        int valueX = (value-1)/3;
        int valueY = (value-1)%3;
        
        int result = Math.abs(locationX - valueX) + Math.abs(locationY-valueY);
        return result;
    }
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int LHandPos=10;
        int RHandPos=12;
        for(int i=0; i<numbers.length; i++){
            //�޼��� �����̴� ���
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "L";
                LHandPos = numbers[i]; 
            }
            //�������� �����̴� ���
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "R";
                RHandPos = numbers[i]; 
            }else {
                //�Ÿ� ����� �ʿ��� ���(Ű�е��� �߰����� ���)
                int leftDist  = calcDist(LHandPos, numbers[i]);
                int rightDist = calcDist(RHandPos, numbers[i]);
                //�޼��� �� ��. ���������� ������ �ϴ� ���
                if(leftDist > rightDist){
                    answer += "R";
                    RHandPos = numbers[i];                   
                }
                //�������� �� ��. �޼����� ������ �ϴ� ���
                else if(leftDist < rightDist){
                    answer += "L";
                    LHandPos = numbers[i];
                }
                //�� �տ������� �Ÿ��� ���� ���
                else{
                    if(hand.equals("right")){
                        answer += "R";
                    	RHandPos = numbers[i];
                    }else{
                        answer += "L";
                    	LHandPos = numbers[i];
                    }
                }
            }
        }
        return answer;
    }
}
public class EnterKeyPad {
	public static void main(String[] args) {
		Solution s = new Solution();
		int numbers[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		System.out.println(s.solution(numbers, hand));
	}
}
