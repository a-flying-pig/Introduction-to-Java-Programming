package chapter29_multithreading;

public class TaskThreadDemo {

	public static void main(String[] args) {
		
		Runnable printA = new PrintChar('a', 100000);
		Runnable printB = new PrintChar('b', 100000);
		Runnable print100 = new PrintNum(100000);
		
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);
		
		thread1.start();
		thread2.start();
		thread3.start();
		//printA.run();
		//printB.run();
		//print100.run();
	}
	
}

class PrintChar implements Runnable {

	private char charToPrint;
	private int times;
	
	public PrintChar(char c, int t) {
		// TODO Auto-generated constructor stub
		charToPrint = c;
		times = t;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < times; i++) {
			System.out.print(charToPrint);
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
	}
	
}

class PrintNum implements Runnable {

	private int lastNum;
	
	public PrintNum(int n) {
		// TODO Auto-generated constructor stub
		lastNum = n;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= lastNum; i++) {
			System.out.print(" " + i);
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
	}
	
}
