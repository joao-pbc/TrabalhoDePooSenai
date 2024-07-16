package Modelo;

import java.time.LocalDate;

import Enum.*;

public class Administrativo extends Empregado{

    double ajudaCusto;

    public double getAjudaCusto() {
		return this.ajudaCusto;
	}

	public void setAjudaCusto(double ajudaCusto) {
		this.ajudaCusto = ajudaCusto;
	}

	public Administrativo(String nome, TpPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, Estado estado, String DDD, String telefone, int codigoSetor, double salarioBruto, LocalDate dataAdmissao, LocalDate dataDesligamento, double percentualImpostos, double ajudaCusto) {
        super(nome, tipoPessoa, documento, endereco, complementoEndereco, bairro, CEP, cidade, estado, DDD ,telefone, codigoSetor, salarioBruto, dataAdmissao, dataDesligamento, percentualImpostos);
        this.ajudaCusto = ajudaCusto;
    }

    public double calcularSalarioLiquido(double salarioBruto, double percentualImpostos) {
        return super.calcularSalarioLiquido(salarioBruto, percentualImpostos) + ajudaCusto;
    }
}
