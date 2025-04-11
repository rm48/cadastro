package cadastro.modelo.beans;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable{
	private int id;
	private String nome;
	private String endereco;
	private String cidade;
	private String uf;
	private String cep;
	private String cpf;
	private String email;
	private String sexo;
	private String bairro;
	private String fone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		cep = cep.replaceAll(" ","").replaceAll("-", "");
		this.cep = cep;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		cpf = cpf.replaceAll(" ","").replaceAll("\\.", "").replaceAll("-", "");
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		fone = fone.replaceAll(" ","").replaceAll("\\(","").replaceAll("\\)","").replaceAll("-","");
		this.fone = fone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, cpf, email, endereco, fone, id, nome, sexo, uf);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(email, other.email) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(fone, other.fone) && id == other.id && Objects.equals(nome, other.nome)
				&& Objects.equals(sexo, other.sexo) && Objects.equals(uf, other.uf);
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade + ", uf=" + uf
				+ ", cep=" + cep + ", cpf=" + cpf + ", email=" + email + ", sexo=" + sexo + ", bairro=" + bairro
				+ ", fone=" + fone + "]";
	}

}
