package per.owisho.learn.test;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

public class LinkTest {

	public static void main(String[] args) {
		
		Node node1 = new Node();
		node1.data = "1";
		Node node2 = new Node();
		node2.data = "2";
		node1.next = node2;
		Node node3 = new Node();
		node3.data = "3";
		node2.next = node3;
		Node node4 = new Node();
		node4.data = "4";
		node3.next = node4;
		
		Node temp = node1;
		while(temp.next!=null) {
			System.out.println(temp);
			temp = temp.next;
		}
		System.out.println(temp);
		
		reverse(node1);
		
		Node temp1 = node4;
		while(temp1.next!=null) {
			System.out.println(temp1);
			temp1 = temp1.next;
		}
		System.out.println(temp1);
	}
	
	public static void reverse(Node node) {
		
		if(node.next==null) {
			return ;
		}
		reverse(node.next);
		node.next.next = node;
		node.next = null;
		return ;
		
	}
	
	public void forReverse(Node node) {
		
		while(node.next!=null) {
			
		}
		
	}
	
}

class Node{
	
	Node next;
	
	String data;
	
	@Override
	public String toString() {
		return data;
	}
	
}