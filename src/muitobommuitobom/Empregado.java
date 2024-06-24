package muitobommuitobom;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Empregado extends Pessoa{
    int codigoSetor;
    LocalDate dataAdmissao;
    LocalDate dataDesligamento;
    double salarioBruto;
    double percentualImpostos;
    double salarioLiquidoCalculado;
    LocalDateTime dataCalculoSalario;

    public Empregado(String nome, muitobommuitobom.TipoPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, muitobommuitobom.Estado estado, String telefone) {
        super(nome, tipoPessoa, documento, endereco, complementoEndereco, bairro, CEP, cidade, estado, telefone);
    }

    public double calcularSalarioLiquido(){
        return 1.0;
    }
}
