package controller;

import java.util.concurrent.Semaphore;

public class ThreadBilheteria extends Thread {

	private static int ingressosdisp = 100;
	private int idcomp;
	private int qntingressos;
	private Semaphore semaforo;
	
	public ThreadBilheteria (int idcomp, int qntingressos, Semaphore semaforo){
	this.idcomp = idcomp;
	this.qntingressos = qntingressos;
	this.semaforo = semaforo;
	}

	@Override

	public void run(){
	loginsistema();
	semaforo.release();
	}
	

	// if do login
	
	int tempologin= 0;

private void loginsistema() {
	tempologin = (int) ((Math.random() * 2000) + 500);
	try{
		sleep(tempologin);
		if (tempologin >= 1.0) {
			System.out.print("TimeOut. Login do comprador #" + idcomp + " interrompido. Não foi possível continuar sua compra.");
		}else {
			System.out.print("Login do comprador #" + idcomp + " efetuado.");
		}
		comprasistema();
}
	catch (InterruptedException e){
		e.printStackTrace();
	}	
}
		
		// if da compra
		
		int tempocompra= 0;

private void comprasistema() {
	tempocompra = (int) ((Math.random() *3000) + 1000);
	try {
		sleep(tempocompra);	
		if (tempocompra >= 2500) {
			System.out.print("TimeOut. Solicitação de compra do comprador #" + idcomp + " interrompida. Não foi possível continuar o processo.");
		}else {
			System.out.print("Solicitação de compra do comprador #" + idcomp + " efetuada.");
	}
		ingressossistema();
}
	catch (InterruptedException e){
		e.printStackTrace();	
}
}

//if dos ingressos

private void ingressossistema() {
		if (ingressosdisp - qntingressos >= 0) {
			ingressosdisp = ingressosdisp - qntingressos;
			System.out.print("O comprador #" + idcomp + " efetuou a compra de " + qntingressos + "ingressos.");
			System.out.print("Restam " + ingressosdisp + "ingressos disponiveis para a compra");
		}else {
			System.out.print("O comprador #" + idcomp + " não pode efetuar sua compra, a quantidade de ingressos disponiveis é inferior ao solicitado.");
			System.out.print("Restam " + ingressosdisp + "ingressos disponiveis para a compra");
		}	
}
}