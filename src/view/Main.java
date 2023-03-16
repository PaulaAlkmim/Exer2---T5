package view;

import java.util.concurrent.Semaphore;

import controller.P;

public class Main {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		for (int pessoa = 1 ; pessoa <= 4 ; pessoa++) {
			Thread t = new P(pessoa, semaforo);
			t.start();
		}
	}

}