import java.util.Scanner;

public class CountingThreadConsole {

	static public void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("아무 키나 입력>> ");
		scanner.nextLine(); // 어떤 키라도 입력되기를 기다림
		scanner.close();
		
		Thread th = new Thread(new CountingThread());	
		th.start(); //스레드의 실행을 시작

	}
}

class CountingThread implements Runnable {
	@Override
	public void run() {
		System.out.println("스레드 실행 시작");		
		for(int i=1; i<=10; i++) //1에서 10까지 출력
			System.out.print(i + " ");
		System.out.println();
		System.out.println("스레드 종료");
	}
}
