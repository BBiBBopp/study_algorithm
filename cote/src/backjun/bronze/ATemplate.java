package backjun.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ATemplate {
	public static void main (String[] args) throws IOException {
		// scanner�� sysout ���� �ӵ��� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("�Է³���"); 
		bw.flush(); 
		bw.close(); 
		
		// =====================================
		
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		String S = sc.next();
		
		// =====================================
		
		StringBuilder sb = new StringBuilder();
		sb.append("�Է³���");
		
		
		/*
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st = new StringTokenizer(br.readLine());

         while(st.countTokens()!=0)
            bw.write(st.nextToken()+", ");

         bw.flush();

		*/
	}
}
