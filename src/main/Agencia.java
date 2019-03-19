package main;

import java.util.ArrayList;

public class Agencia {
	
	private Integer numero;
	private String nome;
	private String endereco;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public Agencia() {
		
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}
}
