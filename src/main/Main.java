package main;

public class Main {
	
	public static void main(String[] args) {
		Banco banco = new Banco();
		
		banco.criarAgencia("Ag�ncia de Florian�polis", "Avenida A"); //ag�ncia 0
		
		banco.criarPessoaFisica("Ana", "Rua B", "49 88889991", "ana@ana.com.br", "123123123-45", "solteira"); //cliente 0
		banco.criarPessoaFisica("Jo�o", "Rua C", "49 77779992", "jo�o@jo�o.com.br", "777777777-77", "casado"); //cliente 1
		
		System.out.println();
		
		banco.criarContaCorrente(0, 0, 500.0, false, 0.0); //ag�ncia 0, cliente 0 (ana)
		banco.verSaldo(0);
		banco.depositar(0, 700.0);
		banco.verSaldo(0);
		banco.sacar(0, 50.0);
		banco.verSaldo(0);
		banco.excluirConta(0);
		
		System.out.println();
		
		banco.criarContaPoupanca(0, 1, 500.0, 50, 0.7); //ag�ncia 0, cliente 1 (jo�o)
		banco.sacar(1, 70.0); //sem saldo
		banco.depositar(1, 1500.0);
		banco.verSaldo(1);
		
		System.out.println();
		
		banco.criarAgencia("Ag�ncia de S�o Paulo", "Avenida Y"); //ag�ncia 1
		banco.criarPessoaJuridica("Empresa X", "Rua Z", "49 11112222", "pedro@pedro.com.br", "11111113333333"); //cliente 2
		
		System.out.println();
		
		banco.criarContaCorrente(1, 2, 500.0, true, 100.0); // ag�ncia 1, cliente 2
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
		
		System.out.println();
		
		banco.excluirCliente(0); //cliente 0 (ana)
		banco.excluirAgencia(7); //n�mero inv�lido
		banco.excluirAgencia(1); //ag�ncia 1
	}
}
