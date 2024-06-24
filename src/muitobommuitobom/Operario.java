package muitobommuitobom;

public class Operario extends Empregado{
    double valorMinimoGatilho;
    double percentualComissao;
    double producaoMensal;
    boolean informouProducaoMensal;

    public Operario(String nome, muitobommuitobom.TipoPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, muitobommuitobom.Estado estado, String telefone) {
        super(nome, tipoPessoa, documento, endereco, complementoEndereco, bairro, CEP, cidade, estado, telefone);
    }

    void informarProducaoMensal(double valor){

    }
    void limparProducaoMensal(){

    }
    public double calcularSalarioLiquido(){
        return super.calcularSalarioLiquido();
    }
}
