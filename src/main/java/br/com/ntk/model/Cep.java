package br.com.ntk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representacao do modelo <b>ORM</b> do CEP 
 * 
 * @author Eduardo Wallace
 * @author NTK Solutions
 * @since 12/08/2014
 */
@XmlRootElement
@Entity
@Table(schema="cep", name = "tb_sys_cep")
@NamedQueries({
	
	@NamedQuery(name = "cepFind", query = "SELECT c FROM Cep c WHERE c.cep =:cep "),
	@NamedQuery(name = "cepFindLogradouro", query = "SELECT c FROM Cep c "
			+ "WHERE c.logradouro LIKE :logradouro AND c.estado =:estado ORDER BY c.logradouro"),
	
})
public class Cep implements Serializable {
	private static final long serialVersionUID = -7189587566259881408L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CEP")
	private Integer id;

	@Column(name = "CEP", length = 8)
	private String cep;

	@Column(name = "TP_LOGRADOURO", length = 36)
	private String tpLogradouro;

	@Column(name = "LOGRADOURO", length = 100)
	private String logradouro;

	@Column(name = "COMPLEMENTO", length = 100)
	private String complemento;

	@Column(name = "BAIRRO", length = 72)
	private String bairro;

	@Column(name = "CIDADE", length = 72)
	private String cidade;

	@Column(name = "ESTADO", length = 2)
	private String estado;

	public Cep() {
		super();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTpLogradouro() {
		return tpLogradouro;
	}

	public void setTpLogradouro(String tpLogradouro) {
		this.tpLogradouro = tpLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cep [id=" + id + ", cep=" + cep + ", tpLogradouro="
				+ tpLogradouro + ", logradouro=" + logradouro
				+ ", complemento=" + complemento + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + "]";
	}

}