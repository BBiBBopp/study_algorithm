package sparta.lv2;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        /*
        // 굳이 이중 포문 쓸 필요 없음, 한 줄에 찍히는 문자열 갯수 똑같음
        for(int j=0; j<b; j++){
            for(int i=0; i<a; i++){
                sb.append("*");
            }
            System.out.println(sb.toString());
            sb.replace(0,a, "");
        }
        */

        for(int i=0; i<a; i++){
            sb.append("*");
        }
        for(int i=0; i<b; i++){
            System.out.println(sb.toString());
        }
    }
}
