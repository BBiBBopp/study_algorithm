package programmers.Lv1;
/*
 * 임의의 양수 N에 대해, 
 * N이 어떤 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고,
 * n이 양의 정수 x의 제곱이 아니라면 -1을 리턴 
 */
public class N12934 {

	public static void main(String[] args) {
		System.out.println(solution(144));
	}
	
	public static int getSquare(int num){
		return num * num;
	}
	
	// 정수 제곱근 판별
	 public static long solution(long n) {
        long answer = 0;
    
    	int sqrt = (int) Math.sqrt(n); 
    	// int 형으로 변환하는 경우, 소수점 이하 부분이 사라지고 Math.pow 연산 시 n과 다른 값이 나오게 됨
        // 형변환 하지 않고 Math.pow 비교 시 오류 발생 가능성 있음 
    	
        if(Math.pow(sqrt, 2) == n){
        	return (long) Math.pow(sqrt+1, 2);
        } else {
        	return -1;
        }
    }
	
}
