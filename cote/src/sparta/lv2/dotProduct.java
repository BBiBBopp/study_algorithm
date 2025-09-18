package sparta.lv2;
/*
 *  < 내적 >
 * 길이가 같은 두 1차원 정수 배열 a,b가 매개변수일 때,
 * a,b의 내적 : a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1]
 */
public class dotProduct {
    public static int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i = 0; i < a.length; i++){
            answer += a[i] * b[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2});
    }
}
