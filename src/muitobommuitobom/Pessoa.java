package muitobommuitobom;

import java.util.regex.Pattern;

import static muitobommuitobom.TipoPessoa.PESSOA_FISICA;
import static muitobommuitobom.TipoPessoa.PESSOA_JURIDICA;

public abstract class Pessoa {

    public void setID(int ID) {
        this.ID = ID;
    }

    private int ID;

    private String Nome;

    private muitobommuitobom.TipoPessoa TipoPessoa;

    private String Documento;

    private String Endereco;

    private String ComplementoEndereco;

    private String Bairro;

    private String CEP;

    private String Cidade;

    private muitobommuitobom.Estado Estado;

    private String Telefone;

    public Pessoa(){
    }

    public Pessoa(String nome, muitobommuitobom.TipoPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, muitobommuitobom.Estado estado, String telefone) {

        if(nome.length()>=5 && endereco.length()>=5 && bairro.length()>=5){
            throw new IllegalArgumentException("Campo possui menos que cinco caracteres");
        }
        if(cidade.length()>=3){
            throw new IllegalArgumentException("Campo possui menos que três caracteres");
        }
        if(!documentoValido(documento, tipoPessoa))
            throw new IllegalArgumentException("Documentos inválidos");
        if(validarTelefone(telefone))
            throw new IllegalArgumentException("Telefone Inválido");


        this.ID = ID + 1;
        Nome = nome;
        TipoPessoa = tipoPessoa;
        Documento = documento;
        Endereco = endereco;
        ComplementoEndereco = complementoEndereco;
        Bairro = bairro;
        this.CEP = CEP;
        Cidade = cidade;
        Estado = estado;
        Telefone = telefone;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public muitobommuitobom.TipoPessoa getTipoPessoa() {
        return TipoPessoa;
    }

    public void setTipoPessoa(muitobommuitobom.TipoPessoa tipoPessoa) {
        TipoPessoa = tipoPessoa;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getComplementoEndereco() {
        return ComplementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        ComplementoEndereco = complementoEndereco;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public muitobommuitobom.Estado getEstado() {
        return Estado;
    }

    public void setEstado(muitobommuitobom.Estado estado) {
        Estado = estado;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public boolean documentoValido(String documento, TipoPessoa tipo){
        switch (tipo) {
            case PESSOA_FISICA:
                return validarCPF(documento);
            case PESSOA_JURIDICA:
                return validarCNPJ(documento);
            default:
                throw new IllegalArgumentException("Tipo de pessoa inválido");
        }
    }

    private boolean validarCPF(String cpf) {
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    private boolean validarCNPJ(String cnpj) {
        return cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}");
    }

    public boolean validarTelefone(String telefone) {
        if (telefone == null || telefone.isEmpty()) {
            return false;
        }

        telefone = telefone.replaceAll("[^0-9]", "");

        char primeiroDigito = telefone.charAt(0);
        if (primeiroDigito == '2' || primeiroDigito == '3' || primeiroDigito == '4' || primeiroDigito == '5') {
            return validarTelefoneFixo(telefone);
        } else if (primeiroDigito == '6' || primeiroDigito == '7' || primeiroDigito == '8' || primeiroDigito == '9') {
            return validarTelefoneMovel(telefone);
        } else {
            return false;
        }
    }

    private boolean validarTelefoneFixo(String telefone) {
        String regex = "[2-5]{1}[0-9]{3}-[0-9]{4}";
        return Pattern.matches(regex, telefone);
    }

    private boolean validarTelefoneMovel(String telefone) {
        String regex = "[6-9]{1}[0-9]{4}-[0-9]{4}";
        return Pattern.matches(regex, telefone);
    }

}
