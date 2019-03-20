package main;

import java.util.ArrayList;

public class Conta {
	
	public Integer numero;
	public Double saldo = 0.0;
	public Double limiteSaque;
	public ArrayList<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();
	public Cliente cliente;
	public Agencia agencia;
	
	public Conta(){
		
	}

	public boolean sacar(Double valor) {
		if (valor != null && valor < this.limiteSaque && valor < this.saldo) {
			this.movimentacoes.add(new Movimentacao(("\nTipo de movimentação: saque\nValor sacado: " + valor + "\nSaldo anterior: " + this.saldo + 
					"\nNovo saldo: " + (this.saldo - valor)), valor, "saque"));
			this.saldo -= valor;
			return true;
		}
		return false;
	}
	
	public boolean depositar(Double valor) {
		if (valor > 0) {
			this.movimentacoes.add(new Movimentacao(("\nTipo de movimentação: depósito\nValor depositado: " + valor + "\nSaldo anterior: " + this.saldo + 
					"\nNovo saldo: " + (this.saldo + valor)), valor, "depósito"));
			this.saldo += valor;
			return true;
		}
		return false;
	}
	
	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public Double getLimiteSaque() {
		return limiteSaque;
	}


	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	public ArrayList<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
}
