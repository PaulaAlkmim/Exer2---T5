package controller;

import java.util.concurrent.Semaphore;

public class P extends Thread {
	
	private int pessoa;
	private Semaphore semaforo;
	
	
	public P (int pessoa, Semaphore semaforo) {
		this.pessoa = pessoa;
		this.semaforo = semaforo;
		
	}
	public void run() {
		pessoaAndando ();
		try {
			semaforo.acquire();
			pessoaPassando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			pessoaPassou();
		}

   }
		
	public void pessoaAndando() {
		int distanciaFinal = 200;
		int deslocamento = (int) ((Math.random() * 3) + 4);
		int tempo = 100;
		int distanciaInicial = 0;
		while (distanciaInicial < distanciaFinal) {
			distanciaInicial = distanciaInicial + deslocamento;
			System.out.println("A pessoa " + pessoa + "andou " + distanciaInicial + "m" );
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("A pessoa" + pessoa + "chegou na porta");
		}
	

	public void pessoaPassando() {
		System.out.println("A pessoa " + pessoa + " está passando");
		int tempoPassando = (int) ((Math.random() * 1001) + 1000);
		try {
			sleep(tempoPassando);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void pessoaPassou() {
		System.out.println("A pessoa "+ pessoa + " passou");
		
	}
		
    
}
