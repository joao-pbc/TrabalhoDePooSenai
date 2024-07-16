package Modelo;

import java.time.LocalDate;

import Enum.Estado;
import Enum.TpPessoa;

public class Vendedor extends Empregado {
	
    private double vendasMes;
    private double vendasUltimoMes;
    private double vendasPenultimoMes;
    private boolean informouVendasMes;
    private double valorMinimoBonus;
    private double percentualPremiacao;

    
    public Vendedor(String nome, TpPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, Estado estado,String DDD, String telefone, int codigoSetor, double salarioBruto, LocalDate dataAdmissao, LocalDate dataDesligamento, double percentualImpostos, double valorMinimoBonus, double percentualPremiacao){
        super(nome, tipoPessoa, documento, endereco, complementoEndereco, bairro, CEP, cidade, estado,DDD, telefone, codigoSetor, salarioBruto, dataAdmissao, dataDesligamento, percentualImpostos);

        if (valorMinimoBonus < 0 || Math.floor(valorMinimoBonus * 100) != valorMinimoBonus * 100) {
            throw new IllegalArgumentException("O valor não está dentro dos parâmetros: " + valorMinimoBonus);
        }
        if (percentualPremiacao < 0 || Math.floor(percentualPremiacao * 100) == percentualPremiacao * 100) {
            throw new IllegalArgumentException("O valor não está dentro dos paramentros");
        }
        setVendasMes(1.234);
        if (vendasMes < 0 || Math.floor(vendasMes * 100) == vendasMes * 100) {
            throw new IllegalArgumentException("O valor não está dentro dos paramentros");
        }
        setVendasPenultimoMes(1.234);
        if (vendasPenultimoMes < 0 || Math.floor(vendasPenultimoMes * 100) == vendasPenultimoMes * 100) {
            throw new IllegalArgumentException("O valor não está dentro dos paramentros");
        }
        if (salarioBruto > 0 && Math.floor(salarioBruto * 100) == salarioBruto * 100) {
            throw new IllegalArgumentException("O valor não está dentro dos paramentros");
        }
        this.valorMinimoBonus = valorMinimoBonus;
        this.percentualPremiacao = percentualPremiacao;
        this.informouVendasMes = false;
        this.vendasMes = 0;
        this.vendasUltimoMes = 0;
        this.vendasPenultimoMes = 0;
    }
    
    public double getVendasMes() {
        return vendasMes;
    }

    public double getVendasUltimoMes() {
        return vendasUltimoMes;
    }

    public double getVendasPenultimoMes() {
        return vendasPenultimoMes;
    }

    public boolean isInformouVendasMes() {
        return informouVendasMes;
    }

    public void setVendasMes(double vendasMes) {
        this.vendasMes = vendasMes;
    }

    public void setVendasUltimoMes(double vendasUltimoMes) {
        this.vendasUltimoMes = vendasUltimoMes;
    }

    public void setVendasPenultimoMes(double vendasPenultimoMes) {
        this.vendasPenultimoMes = vendasPenultimoMes;
    }

    public void setInformouVendasMes(boolean informouVendasMes) {
        this.informouVendasMes = informouVendasMes;
    }

    public double getValorMinimoBonus() {
        return valorMinimoBonus;
    }

    public void setValorMinimoBonus(double valorMinimoBonus) {
        this.valorMinimoBonus = valorMinimoBonus;
    }

    public double getPercentualPremiacao() {
        return percentualPremiacao;
    }

    public void setPercentualPremiacao(double percentualPremiacao) {
        this.percentualPremiacao = percentualPremiacao;
    }

    public void InformarVendasDoMes(double valor){
        this.vendasPenultimoMes = vendasUltimoMes;
        this.vendasUltimoMes = vendasMes;
        this.vendasMes = valor;
        if ((vendasPenultimoMes+vendasUltimoMes+vendasMes)/3>((getValorMinimoBonus()*0.01)-(getValorMinimoBonus()))){
            this.informouVendasMes = true;
        }
    }

    private double CalculaBonificacao(){
        double media = (vendasMes+vendasUltimoMes+vendasPenultimoMes)/3;
        if(media>(getValorMinimoBonus()*0.20)+getValorMinimoBonus()){
            return media*0.03;
        } else if(media>(getValorMinimoBonus()*0.35)+getValorMinimoBonus()){
            return media*0.05;
        } else if(media>(getValorMinimoBonus()*0.50)+getValorMinimoBonus()){
            return media*0.075;
        }
        return 0;
    }

    public double CalculaSalarioLiquido(double salarioBruto, double percentualImpostos){
        if(!informouVendasMes){
            throw new RuntimeException("Erro: Vendas do mês não foram informadas.");
        } else{
            return (CalculaBonificacao()*salarioBruto)-(salarioBruto * percentualImpostos);
        }
    }
}
