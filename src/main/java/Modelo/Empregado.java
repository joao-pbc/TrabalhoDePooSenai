package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import Enum.*;

public abstract class Empregado extends Pessoa{
    int codigoSetor;
    LocalDate dataAdmissao;
    LocalDate dataDesligamento;
    double salarioBruto;
    double percentualImpostos;
    double salarioLiquidoCalculado;
    LocalDateTime dataCalculoSalario;

	public Empregado(String nome, TpPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, Estado estado, String DDD, String telefone, int codigoSetor, double salarioBruto, LocalDate dataAdmissao, LocalDate dataDesligamento, double percentualImpostos) {
        super(nome, tipoPessoa, documento, endereco, complementoEndereco, bairro, CEP, cidade, estado, DDD, telefone);
        
        if(codigoSetor<0){
            throw new IllegalArgumentException("O valor deve ser acima de zero");
        }
        
        //if (salarioBruto > 0 && Math.floor(salarioBruto * 100) == salarioBruto * 100) {
        //    throw new IllegalArgumentException("O valor não está dentro dos paramentros");
        //}
        
        LocalDate dataAtual = LocalDate.now();
        
        if (dataAdmissao.isBefore(dataAtual)){
            throw new IllegalArgumentException("Data invalida.");
        }
        
        if(dataDesligamento.isBefore(dataAtual) || dataDesligamento.isAfter(dataAdmissao)){
            throw new IllegalArgumentException("Data invalida.");
        }
        
        this.dataAdmissao = dataAdmissao;
        this.dataDesligamento = dataDesligamento;
        this.codigoSetor = codigoSetor;
        this.salarioBruto = salarioBruto;
        this.percentualImpostos = percentualImpostos;
        this.salarioLiquidoCalculado = calcularSalarioLiquido(salarioBruto, percentualImpostos);
    }

    public int getCodigoSetor() {
		return this.codigoSetor;
	}

	public void setCodigoSetor(int codigoSetor) {
		this.codigoSetor = codigoSetor;
	}

	public LocalDate getDataAdmissao() {
		return this.dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDate getDataDesligamento() {
		return this.dataDesligamento;
	}

	public void setDataDesligamento(LocalDate dataDesligamento) {
		this.dataDesligamento = dataDesligamento;
	}

	public double getSalarioBruto() {
		return this.salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public double getPercentualImpostos() {
		return this.percentualImpostos;
	}

	public void setPercentualImpostos(double percentualImpostos) {
		this.percentualImpostos = percentualImpostos;
	}

	public double getSalarioLiquidoCalculado() {
		return this.salarioLiquidoCalculado;
	}

	public void setSalarioLiquidoCalculado(double salarioLiquidoCalculado) {
		this.salarioLiquidoCalculado = salarioLiquidoCalculado;
	}

	public LocalDateTime getDataCalculoSalario() {
		return this.dataCalculoSalario;
	}

	public void setDataCalculoSalario(LocalDateTime dataCalculoSalario) {
		this.dataCalculoSalario = dataCalculoSalario;
	}

	public double calcularSalarioLiquido(double salarioBruto, double percentualImpostos){
        this.dataCalculoSalario = LocalDateTime.now();
        return salarioBruto-(salarioBruto * percentualImpostos);
    }
}
