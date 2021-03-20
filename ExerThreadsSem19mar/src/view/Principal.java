package view;

import java.util.concurrent.Semaphore;

import controller.ThreadBilheteria;

public class Principal {
	
	public static void main(String[] args) {
	
		int idcomp;
		int qntingresso;
		
		Semaphore semaforo = new Semaphore(1);
		for (idcomp = 0; idcomp < 300; idcomp++) {
			qntingresso = (int) ((Math.random() * 4) + 1);
			ThreadBilheteria threadCDI = new ThreadBilheteria (idcomp, qntingresso, semaforo);
			threadCDI.start();
		}
	}
}