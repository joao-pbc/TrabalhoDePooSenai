package Modelo;

import Enum.Estado;
import Enum.TpPessoa;
import Utils.Telefone;

public abstract class Pessoa {
	
	private TpPessoa tipoPessoa;
	private Estado estado;
	
	private int id = 0;
	private static int nextId = 1;

	private String nome; 
	private String documento;
	private String endereco;
	private String complementoEndereco;
	private String bairro;
	private String cidade;	
	private Telefone telefone;
	private String cep;
	
	
	public Pessoa(String nome, TpPessoa tipoPessoa, String documento, String endereco, String complementoEndereco, String bairro, String CEP, String cidade, Estado estado, String DDD,String telefone) {
		this.tipoPessoa = tipoPessoa;
		this.id = nextId;
		nextId++;
		setNome(nome);
        setDocumento(documento);
        setEndereco(endereco);
        complementoEndereco = this.complementoEndereco;
        setBairro(bairro);
        setCEP(CEP);
        setCidade(cidade);
        setEstado(estado);
        setTelefone(DDD,telefone);

    }
	public int getID() {
		return id;
	}



	public TpPessoa getTipoPessoa() {
		return this.tipoPessoa;
	}
	public void setTipoPessoa(TpPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public Estado getEstado() {
		return this.estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		if (nome.length() >= 5) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome deve ter pelo menos 5 caracteres");
        }
	}
	public String getDocumento() {
		
		String docFormatado = "";
		
		if ((this.getTipoPessoa() == TpPessoa.PessoaFisica)) {
			docFormatado = this.documento.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        } else if ((this.getTipoPessoa() == TpPessoa.PessoaJuridica)) {
        	docFormatado = this.documento.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
        }
		
		return docFormatado;
	}
	
	public void setDocumento(String Documento) {
		
		try {
			if (this.getTipoPessoa() == null) {
				throw new Exception("Antes de informar o documento, é preciso especificar o tipo de pessoa.");
			}
			
			if (DocumentoValido(Documento)) {
				this.documento = Documento;
			}
		} catch (Exception e){
			System.out.println("Documento inválido\n" + e.getMessage());
		}
	}
	
	protected boolean DocumentoValido(String Documento){
		if ((this.getTipoPessoa() == TpPessoa.PessoaFisica)) {
			return Utils.Rotinas.verificaCPF(Documento);
		} else if ((this.getTipoPessoa() == TpPessoa.PessoaJuridica)) {
			return Utils.Rotinas.validaCNPJ(Documento);
		}
		
		return false;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String endereco) {
		if (endereco.length() >= 5) {
            this.endereco = endereco;
        } else {
            throw new IllegalArgumentException("Endereço deve ter pelo menos 5 caracteres");
        }
	}
	public String getComplementoEndereco() {
		return this.complementoEndereco;
	}
	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}
	public String getBairro() {
		return this.bairro;
	}
	public void setBairro(String bairro) {
		 if (bairro.length() >= 5) {
			 this.bairro = bairro;
	     } else {
	    	 throw new IllegalArgumentException("Bairro deve ter pelo menos 5 caracteres");
	     }
	}
	public String getCidade() {
		return this.cidade;
	}
	public void setCidade(String cidade) {
        if (cidade.length() >= 3) {
            this.cidade = cidade;
        } else {
            throw new IllegalArgumentException("Cidade deve ter pelo menos 3 caracteres");
        }
	}
	
	public String getTelefone() {
		String numero =  this.telefone.toString();
		return numero;
	}
	
	public void setTelefone(String ddd, String numeroTelefone) {
        try {
            this.telefone = new Telefone(ddd, numeroTelefone);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.telefone = null;
        }
    }
	
	public String getCEP() {
		return this.cep;
	}
	
	public void setCEP(String CEP) {
		if (CEP.length() == 8) {
			this.cep = CEP.replaceAll("(\\d{5})(\\d{3})", "$1-$2");
		} else {
			System.out.println("CEP Inválido");
		}
	}
	
	@Override
	public String toString() {
		return "Pessoa [tipoPessoa=" + tipoPessoa + ", estado=" + estado + ", id=" + id + ", nome=" + nome
				+ ", documento=" + documento + ", endereco=" + endereco + ", complementoEndereco=" + complementoEndereco
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", telefone=" + telefone + ", cep=" + cep + "]";
	}

}


