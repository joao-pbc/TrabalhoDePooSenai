package muitobommuitobom;

import java.time.LocalDate;

public class Operario extends Empregado{

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

    double valorMinimoGatilho;
    double percentualComissao;
    double producaoMensal;
    boolean informouProducaoMensal;

    public Operario(){

    }

    public Operario(String nome, muitobommuitobom.TipoPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, muitobommuitobom.Estado estado, String telefone, int codigoSetor, double salarioBruto, LocalDate dataAdmissao, LocalDate dataDesligamento, double percentualImpostos, double valorMinimoGatilho, double percentualComissao, double producaoMensal, boolean informouProducaoMensal) {
        super(nome, tipoPessoa, documento, endereco, complementoEndereco, bairro, CEP, cidade, estado, telefone, codigoSetor, salarioBruto, dataAdmissao, dataDesligamento, percentualImpostos);
        this.valorMinimoGatilho = valorMinimoGatilho;
        this.percentualComissao = percentualComissao;
        this.producaoMensal = 0;
        this.informouProducaoMensal = false;
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
