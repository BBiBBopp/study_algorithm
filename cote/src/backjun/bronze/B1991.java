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
		
		// ���� ��ȸ(pre)�� ��� : ABDCEFG  (��Ʈ) (���� �ڽ�) (������ �ڽ�)
		// ���� ��ȸ(in)�� ��� : DBAECFG  (���� �ڽ�) (��Ʈ) (������ �ڽ�)
		// ���� ��ȸ(post)�� ��� : DBEGFCA  (���� �ڽ�) (������ �ڽ�) (��Ʈ)
	
		// root 
		// left 
		// right 
		
		// 1��° left ������ > 2��° root > 2��° left ������ 

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
