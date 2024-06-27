package programmers.Lv1;
/*
 * ������ ��� N�� ����, 
 * N�� � ���� ���� x�� �����̶�� x+1�� ������ �����ϰ�,
 * n�� ���� ���� x�� ������ �ƴ϶�� -1�� ���� 
 */
public class N12934 {

	public static void main(String[] args) {
		System.out.println(solution(144));
	}
	
	public static int getSquare(int num){
		return num * num;
	}
	
	// ���� ������ �Ǻ�
	 public static long solution(long n) {
        long answer = 0;
    
    	int sqrt = (int) Math.sqrt(n); 
    	// int ������ ��ȯ�ϴ� ���, �Ҽ��� ���� �κ��� ������� Math.pow ���� �� n�� �ٸ� ���� ������ ��
        // ����ȯ ���� �ʰ� Math.pow �� �� ���� �߻� ���ɼ� ���� 
    	
        if(Math.pow(sqrt, 2) == n){
        	return (long) Math.pow(sqrt+1, 2);
        } else {
        	return -1;
        }
    }
	
}
