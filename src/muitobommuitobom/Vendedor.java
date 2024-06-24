package muitobommuitobom;

public class Vendedor extends Empregado{
    double valorMinimoBonus;
    double percentualPremiacao;
    private double vendasMes;
    private double vendasPenultimoMes;
    private boolean informouVendasMes;

    public Vendedor(String nome, muitobommuitobom.TipoPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, muitobommuitobom.Estado estado, String telefone) {
        super(nome, tipoPessoa, documento, endereco, complementoEndereco, bairro, CEP, cidade, estado, telefone);
    }

    void informarVendasDoMes(double valor){

    }
    void reverterInformacaoVendasDoMes(){

    }
    @Override
    public double calcularSalarioLiquido() {
        return super.calcularSalarioLiquido();
    }
}
