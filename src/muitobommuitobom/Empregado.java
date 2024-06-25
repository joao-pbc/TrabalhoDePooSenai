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
        if(codigoSetor<0){
            throw new IllegalArgumentException("O valor deve ser acima de zero");
        }
        if (salarioBruto > 0 && Math.floor(salarioBruto * 100) == salarioBruto * 100) {
            throw new IllegalArgumentException("O valor não está dentro dos paramentros");
        }
        LocalDate dataAtual = LocalDate.now();
        if (dataAdmissao.isBefore(dataAtual)){
            throw new IllegalArgumentException("Data invalida.");
        }
        if(dataDesligamento.isBefore(dataAtual) || dataDesligamento.isAfter(dataAdmissao)){
            throw new IllegalArgumentException("Data invalida.");
        }

    }

    public double calcularSalarioLiquido(double salarioBruto, double percentualImpostos){
        double valor = salarioBruto-percentualImpostos
        return valor;
    }
}