package main;

public class ContaCorrente extends Conta {
	
	private boolean chequeEspecial = false;
	private Double limiteCheque;
	
	public ContaCorrente(){
		
	}
	
	public boolean sacar(Double valor) {
		if ((this.chequeEspecial && (valor < (this.limiteSaque + this.limiteCheque) && valor < this.saldo))
				|| (valor < this.limiteSaque && valor < this.saldo)) {
			this.movimentacoes.add(new Movimentacao(("\nTipo de movimentação: saque\nValor sacado: " + valor + "\nSaldo anterior: " 
				+ this.saldo + "\nNovo saldo: " + (this.saldo - valor)), valor, "saque"));
			this.saldo -= valor;
			return true;
		}
		return false;
	}

	public boolean isChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(boolean chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}

	public Double getLimiteCheque() {
		return limiteCheque;
	}

	public void setLimiteCheque(Double limiteCheque) {
		this.limiteCheque = limiteCheque;
	}
}
