package backjun.bronze;

import java.util.HashMap;
import java.util.Scanner;

public class B1991 {
	public static void main(String[] args) {
		/*
		 	7
			A B C
			B D .
			C E F
			E . .
			F . G
			D . .
			G . .
		 */
		
		// 전위 순회(pre)한 결과 : ABDCEFG  (루트) (왼쪽 자식) (오른쪽 자식)
		// 중위 순회(in)한 결과 : DBAECFG  (왼쪽 자식) (루트) (오른쪽 자식)
		// 후위 순회(post)한 결과 : DBEGFCA  (왼쪽 자식) (오른쪽 자식) (루트)
	
		// root 
		// left 
		// right 
		
		// 1번째 left 가져와 > 2번째 root > 2번째 left 가져와 

		Scanner sc = new Scanner(System.in);
		
		HashMap<String, char[]> map = new HashMap<String, char[]>();

		
		
		

	}
	
	public static void preorder(Node node){
		System.out.println(node.root);
		
		if(node.left != '.'){
			
		}
		
	}
	
	public static void inorder(Node node){
		
	}
	
	public static void postorder(Node node){
		
	}

}

class Node {
	char root;
	char right;
	char left;
	
	public Node(char root, char right, char left) {
		super();
		this.root = root;
		this.right = right;
		this.left = left;
	}
}
