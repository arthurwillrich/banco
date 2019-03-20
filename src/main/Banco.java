package main;

import java.util.ArrayList;

public class Banco {

	public ArrayList<Conta> contas = new ArrayList<Conta>();
	public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public ArrayList<Agencia> agencias = new ArrayList<Agencia>();

	public Banco() {

	}
	
	public void criarAgencia(String nome, String endereco) {
		Agencia agencia = new Agencia();
		agencia.setNumero(this.agencias.size());
		agencia.setNome(nome);
		agencia.setEndereco(endereco);
		this.agencias.add(agencia);
	}
	
	public void excluirAgencia(Integer numero) {
		if (numero == null || numero < 0 || numero > this.agencias.size()) {
			System.out.println("Número da agência inválido.");
			
		} else {
			Agencia agencia = this.agencias.get(numero);
			if (agencia != null){
				for (int i = 0; i < this.contas.size(); i++) {
					if (this.contas.get(i) != null && this.contas.get(i).getAgencia().equals(agencia)) {
						this.contas.set(i, null);
					}
				}
				this.agencias.set(numero, null);
				System.out.println("Agência " + numero + " excluída com sucesso.");
			} else {
				System.out.println("Agência não existe.");
			}
		}
	}
	
	
	public void criarCliente(String nome, String endereco, String telefone, String email) {
		Cliente cliente = new Cliente();
		cliente.setNumero(this.clientes.size());
		cliente.setNome(nome);
		cliente.setEndereco(endereco);
		cliente.setTelefone(telefone);
		cliente.setEmail(email);
		this.clientes.add(cliente);
	}
	
	public void excluirCliente(Integer numero) {
		if (numero == null || numero < 0 || numero > this.clientes.size()) {
			System.out.println("Número de cliente inválido.");
			
		} else {
			Cliente cliente = this.clientes.get(numero);
			if (cliente != null){
				for (int i = 0; i < this.contas.size(); i++) {
					if (this.contas.get(i) != null && this.contas.get(i).getCliente().equals(cliente)) {
						this.contas.set(i, null);
					}
				}
				this.clientes.set(numero, null);
				System.out.println("Cliente " + numero + " excluído com sucesso.");
			} else {
				System.out.println("Cliente não existe.");
			}
		}
	}
	
	public void criarContaCorrente(Integer numeroAgencia, Integer numeroCliente, Double limiteSaque, boolean chequeEspecial, Double limiteCheque) {
		if (numeroAgencia == null || numeroAgencia < 0 || numeroAgencia > this.agencias.size()) {
			System.out.println("Número de agência inválido.");
		} else if (this.clientes.get(numeroAgencia) == null) {
			System.out.println("Agência não existe.");
		} else if (numeroCliente == null || numeroCliente < 0 || numeroCliente > this.clientes.size()) {
			System.out.println("Número de cliente inválido.");
		} else if (this.clientes.get(numeroCliente) == null) {
			System.out.println("Cliente não existe.");
		} else {
			ContaCorrente conta = new ContaCorrente();
			conta.setNumero(this.contas.size());
			this.contas.add(conta);
			conta.setSaldo(0.0);
			conta.setLimiteSaque(limiteSaque);
			conta.setChequeEspecial(chequeEspecial);
			conta.setLimiteCheque(limiteCheque);
			conta.setAgencia(this.agencias.get(numeroAgencia));
			conta.setCliente(this.clientes.get(numeroCliente));
			System.out.println("Conta " + (this.contas.size() - 1) + " criada com sucesso.");
		}
		
	}
	
	public void criarContaPoupanca(Integer numeroAgencia, Integer numeroCliente, Double limiteSaque, Integer variacao, Double rendimento) {
		if (numeroAgencia == null || numeroAgencia < 0 || numeroAgencia > this.agencias.size()) {
			System.out.println("Número de agência inválido.");
		} else if (this.clientes.get(numeroAgencia) == null) {
			System.out.println("Agência não existe.");
		} else if (numeroCliente == null || numeroCliente < 0 || numeroCliente > this.clientes.size()) {
			System.out.println("Número de cliente inválido.");
		} else if (this.clientes.get(numeroCliente) == null) {
			System.out.println("Cliente não existe.");
		} else {
			ContaPoupanca conta = new ContaPoupanca();
			conta.setNumero(this.contas.size());
			this.contas.add(conta);
			conta.setSaldo(0.0);
			conta.setLimiteSaque(limiteSaque);
			conta.setVariacao(variacao);
			conta.setRendimento(rendimento);
			conta.setAgencia(this.agencias.get(numeroAgencia));
			conta.setCliente(this.clientes.get(numeroCliente));
			System.out.println("Conta " + (this.contas.size() - 1) + " criada com sucesso.");
		}
	}
	
	public void excluirConta(Integer numero) {
		if (numero == null || numero < 0 || numero > this.contas.size()) {
			System.out.println("Número inválido.");
			
		} else {
			if (this.contas.get(numero) != null){
				this.contas.set(numero, null);
				System.out.println("Conta " + numero + " excluída com sucesso.");
			} else {
				System.out.println("Conta não existe.");
			}
		}
	}
	
	public void sacar(Integer numero, Double valor) {
		if (numero == null || numero < 0 || numero > this.contas.size()) {
			System.out.println("Número inválido.");
		} else {
			if (this.contas.get(numero) != null){
				if (this.contas.get(numero).sacar(valor)) {
					System.out.println("Saque concluído com sucesso.");
				} else {
					System.out.println("Condições de saque não atendidas.");
				}
			} else {
				System.out.println("Conta não existe.");
			}
		}
	}
	
	public void depositar(Integer numero, Double valor) {
		if (numero == null || numero < 0 || numero > this.contas.size()) {
			System.out.println("Número inválido.");
		} else {
			if (this.contas.get(numero) != null){
				if (this.contas.get(numero).depositar(valor)) {
					System.out.println("Depósito concluído com sucesso.");
				} else {
					System.out.println("Condições de depósito não atendidas.");
				}
			} else {
				System.out.println("Conta não existe.");
			}
		}
	}
	
	public void verSaldo(Integer numero) {
		if (numero == null || numero < 0 || numero > this.contas.size()) {
			System.out.println("Número inválido.");
		} else {
			if (this.contas.get(numero) != null){
				System.out.println("Saldo da conta " + numero + ": " + this.contas.get(numero).getSaldo() + " reais.");
			} else {
				System.out.println("Conta não existe.");
			}
		}
	}
	
	public void gerarExtrato(Integer numero) {
		if (numero == null || numero < 0 || numero > this.contas.size()) {
			System.out.println("Número inválido.");
		} else {
			if (this.contas.get(numero) != null){
				System.out.println("Extrato da conta " + numero + ":");
				System.out.println("Saldo: " + this.contas.get(numero).getSaldo());
				for (Movimentacao m : this.contas.get(numero).movimentacoes) {
					System.out.println(m.descricao);
				}
			} else {
				System.out.println("Conta não existe.");
			}
		}
	}
	
	public void transferir(Integer numero1, Integer numero2, Double valor) {
		if (numero1 == null || numero1 < 0 || numero1 > this.contas.size() || numero2 == null || numero2 < 0 || numero2 > this.contas.size()) {
			System.out.println("Números inválidos.");
		} else {
			if (this.contas.get(numero1) != null && this.contas.get(numero2) != null) {
				if (this.contas.get(numero1).sacar(valor)) {
					this.contas.get(numero2).depositar(valor);
					System.out.println("Valor transferido com sucesso da conta " + numero1 + " para a conta " + numero2 + ".");
				} else {
					System.out.println("O limite de transferência (limite de saque) foi excedido."); 
				}
			} else {
				System.out.println("Alguma(s) das contas não existe(m).");
			}
		}
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Agencia> getAgencias() {
		return agencias;
	}

	public void setAgencias(ArrayList<Agencia> agencias) {
		this.agencias = agencias;
	}
}
