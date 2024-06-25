package muitobommuitobom;

public class Vendedor extends Empregado{
    double valorMinimoBonus;
    double percentualPremiacao;
    private double vendasMes;
    private double vendasUltimoMes;
    private double vendasPenultimoMes;
    private boolean informouVendasMes;

    public Vendedor(String nome, muitobommuitobom.TipoPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, muitobommuitobom.Estado estado, String telefone, double valorMinimoBonus, double percentualPremiacao) {
        super(nome, tipoPessoa, documento, endereco, complementoEndereco, bairro, CEP, cidade, estado, telefone);
        this.informouVendasMes = false;
        this.vendasMes = 0;
        this.vendasPenultimoMes = 0;
        this.vendasUltimoMes = 0;
        this.valorMinimoBonus = valorMinimoBonus;
        this.percentualPremiacao = percentualPremiacao;
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
