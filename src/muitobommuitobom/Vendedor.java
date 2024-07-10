package muitobommuitobom;

import java.time.LocalDate;

public class Vendedor extends Empregado{
    double valorMinimoBonus;
    double percentualPremiacao;
    private double vendasMes;
    private double vendasUltimoMes;
    private double vendasPenultimoMes;
    private boolean informouVendasMes;

    public Vendedor(String nome, muitobommuitobom.TipoPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, muitobommuitobom.Estado estado, String telefone, int codigoSetor, double salarioBruto, LocalDate dataAdmissao, LocalDate dataDesligamento, double percentualImpostos, double valorMinimoBonus, double percentualPremiacao, double vendasMes, double vendasUltimoMes, double vendasPenultimoMes, boolean informouVendasMes) {
        super(nome, tipoPessoa, documento, endereco, complementoEndereco, bairro, CEP, cidade, estado, telefone, codigoSetor, salarioBruto, dataAdmissao, dataDesligamento, percentualImpostos);
        this.valorMinimoBonus = valorMinimoBonus;
        this.percentualPremiacao = percentualPremiacao;
        this.vendasMes = vendasMes;
        this.vendasUltimoMes = vendasUltimoMes;
        this.vendasPenultimoMes = vendasPenultimoMes;
        this.informouVendasMes = informouVendasMes;
    }

    void informarVendasDoMes(double valor){

    }
    void reverterInformacaoVendasDoMes(){

    }

    public double calcularSalarioLiquido(){
        return super.calcularSalarioLiquido(salarioBruto, percentualImpostos) + (producaoMensal * percentualComissao);
    }

}
