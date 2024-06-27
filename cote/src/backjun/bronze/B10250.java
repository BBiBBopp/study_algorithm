package backjun.bronze;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
  Å×½ºÆ® ¼ö
 Ãþ ¼ö , °¢ ÃþÀÇ ¹æ ¼ö, N¹øÂ° ¼Õ´Ô
 
 2 
 6 12 10 
 30 50 72
 */

public class B10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = sc.nextInt();
		int H;
		int W;
		int guest;
		
		try {
			for(int i=0; i<N; i++){
				H = sc.nextInt();
				W = sc.nextInt();
				guest = sc.nextInt();
				
				if(guest <= H){
					bw.write(Integer.toString(guest*100 + 1));
				} else {
					if(guest % H == 0){
						bw.write(Integer.toString((H*100) + (guest/H))); 
					} else {
						bw.write(Integer.toString((guest%H)*100 + ((guest/H) + 1)));
					}
				}
				bw.write("\n");
			}
			
			bw.flush(); 
			bw.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
