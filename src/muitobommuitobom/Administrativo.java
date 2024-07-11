package muitobommuitobom;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Administrativo extends Empregado{

    public double getAjudaCusto() {
        return ajudaCusto;
    }

    double ajudaCusto;

    public Administrativo(){}

    public Administrativo(String nome, muitobommuitobom.TipoPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, muitobommuitobom.Estado estado, String telefone, int codigoSetor, double salarioBruto, LocalDate dataAdmissao, LocalDate dataDesligamento, double percentualImpostos, double ajudaCusto) {
        super(nome, tipoPessoa, documento, endereco, complementoEndereco, bairro, CEP, cidade, estado, telefone, codigoSetor, salarioBruto, dataAdmissao, dataDesligamento, percentualImpostos);
        this.ajudaCusto = ajudaCusto;
    }

    public double calcularSalarioLiquido(double salarioBruto, double percentualImpostos) {
        return super.calcularSalarioLiquido(salarioBruto, percentualImpostos) + ajudaCusto;
    }
}
