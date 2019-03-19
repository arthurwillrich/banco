package main;

public class Main {
	
	public static void main(String[] args) {
		Banco banco = new Banco();
		
		banco.criarContaCorrente(500.0, false, 0.0);
		banco.verSaldo(0);
		banco.depositar(0, 700.0);
		banco.verSaldo(0);
		banco.sacar(0, 50.0);
		banco.verSaldo(0);
		banco.excluirConta(0);
		
		System.out.println();
		
		banco.criarContaPoupanca(500.0, 50, 0.7);
		banco.sacar(1, 70.0); //sem saldo
		banco.depositar(1, 1500.0);
		banco.verSaldo(1);
		
		System.out.println();
		
		banco.criarContaCorrente(500.0, true, 100.0);
		banco.depositar(2, 4000.0);
		banco.sacar(2, 550.0);
		banco.verSaldo(2);
		banco.sacar(2, 650.0);
		banco.verSaldo(2);
		
		System.out.println();
		
		banco.gerarExtrato(2);
		
		System.out.println();
		
		banco.verSaldo(2);
		banco.verSaldo(1);
		banco.transferir(2, 1, 1000.0);
		banco.verSaldo(2);
		banco.verSaldo(1);
	}
}
