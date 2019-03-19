package main;

public class ContaPoupanca extends Conta{
	
	public Integer variacao;
	public Double rendimento;
	
	public ContaPoupanca() {
		
	}

	public Integer getVariacao() {
		return variacao;
	}

	public void setVariacao(Integer variacao) {
		this.variacao = variacao;
	}

	public Double getRendimento() {
		return rendimento;
	}

	public void setRendimento(Double rendimento) {
		this.rendimento = rendimento;
	}
}
