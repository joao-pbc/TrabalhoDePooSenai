package Modelo;

import java.time.LocalDate;

import Enum.*;

public class Operario extends Empregado{
	
	double valorMinimoGatilho;
    double percentualComissao;

    public void setValorMinimoGatilho(double valorMinimoGatilho) {
        this.valorMinimoGatilho = valorMinimoGatilho;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public void setProducaoMensal(double producaoMensal) {
        this.producaoMensal = producaoMensal;
    }

    public void setInformouProducaoMensal(boolean informouProducaoMensal) {
        this.informouProducaoMensal = informouProducaoMensal;
    }

    double producaoMensal;
    boolean informouProducaoMensal;
    
    public Operario(String nome, TpPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, Estado estado,String DDD, String telefone, int codigoSetor, double salarioBruto, LocalDate dataAdmissao, LocalDate dataDesligamento, double percentualImpostos, double valorMinimoGatilho, double percentualComissao, double producaoMensal, boolean informouProducaoMensal) {
        super(nome, tipoPessoa, documento, endereco, complementoEndereco, bairro, CEP, cidade, estado, DDD, telefone, codigoSetor, salarioBruto, dataAdmissao, dataDesligamento, percentualImpostos);
        this.valorMinimoGatilho = valorMinimoGatilho;
        this.percentualComissao = percentualComissao;
        this.producaoMensal = 0;
        this.informouProducaoMensal = false;
    }

    public Operario() {

    }

    public double getValorMinimoGatilho() {
        return valorMinimoGatilho;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public double getProducaoMensal() {
        return producaoMensal;
    }

    public boolean isInformouProducaoMensal() {
        return informouProducaoMensal;
    }
    
    public void limparProducaoMensal(){
        this.producaoMensal = 0;
        this.informouProducaoMensal = false;
    }

    void informarProducaoMensal(double valor){
        this.producaoMensal = valor;
        this.informouProducaoMensal = true;
    }

    public double calcularSalarioLiquido(){
        if(!informouProducaoMensal){
            throw new IllegalArgumentException("Producao mensal nao informada");
        }
        return super.calcularSalarioLiquido(salarioBruto, percentualImpostos) + (producaoMensal * percentualComissao);
    }
}
