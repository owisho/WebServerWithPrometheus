package per.owisho.learn.test;
public class Print {

	public static void main(String[] args) {
		print(6);
	}
	
	public static void print(int n) {
		for(int i = 1;i<=n;i++) {
			printspace(n-i);
			printI(i);
		}
		for(int i=n-1;i>=1;i--) {
			printspace(n-i);
			printI(i);
		}
	}
	
	public static void printspace(int n) {
		for(int i=0;i<n;i++) {
			System.out.print(" ");
		}
	}
	
	public static void printI(int i) {
		for(int m=1;m<=(2*i-1);m++) {
			if(m%2==1) {
				System.out.print(i);
			}else {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	
}
