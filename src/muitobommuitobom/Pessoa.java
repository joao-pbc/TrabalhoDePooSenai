package muitobommuitobom;

public abstract class Pessoa {

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


    public Pessoa(String nome, muitobommuitobom.TipoPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, muitobommuitobom.Estado estado, String telefone) {

        if(nome.length()>=5 && endereco.length()>=5 && bairro.length()>=5){
            throw new IllegalArgumentException("Campo possui menos que cinco caracteres");
        }
        if(cidade.length()>=3){
            throw new IllegalArgumentException("Campo possui menos que três caracteres");
        }

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

    public boolean DocumentoValido(){
        return false;
    }




}
