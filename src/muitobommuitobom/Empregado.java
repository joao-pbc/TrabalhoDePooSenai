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

    public int getCodigoSetor() {
        return codigoSetor;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public LocalDate getDataDesligamento() {
        return dataDesligamento;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getPercentualImpostos() {
        return percentualImpostos;
    }

    public double getSalarioLiquidoCalculado() {
        return salarioLiquidoCalculado;
    }

    public LocalDateTime getDataCalculoSalario() {
        return dataCalculoSalario;
    }

    LocalDateTime dataCalculoSalario;

    public Empregado(){

    }

    public Empregado(String nome, muitobommuitobom.TipoPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, muitobommuitobom.Estado estado, String telefone, int codigoSetor, double salarioBruto, LocalDate dataAdmissao, LocalDate dataDesligamento, double percentualImpostos) {
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
        this.dataAdmissao = dataAdmissao;
        this.dataDesligamento = dataDesligamento;
        this.codigoSetor = codigoSetor;
        this.salarioBruto = salarioBruto;
        this.percentualImpostos = percentualImpostos;
        this.salarioLiquidoCalculado = calcularSalarioLiquido(salarioBruto, percentualImpostos);
    }

    public double calcularSalarioLiquido(double salarioBruto, double percentualImpostos){
        this.dataCalculoSalario = LocalDateTime.now();
        return salarioBruto-(salarioBruto * percentualImpostos);
    }
}