package muitobommuitobom;

public class Administrativo extends Empregado{

    double ajudaCusto;

    public Administrativo(String nome, muitobommuitobom.TipoPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, muitobommuitobom.Estado estado, String telefone) {
        super(nome, tipoPessoa, documento, endereco, complementoEndereco, bairro, CEP, cidade, estado, telefone);
    }

    @Override
    public double calcularSalarioLiquido(){
        return super.calcularSalarioLiquido();
    }
}
