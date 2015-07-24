package br.com.projetobase.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.projetobase.arq.modelo.ModeloPersistencia;



@Entity
@Table(name = "Equipamento")
public class Equipamento extends ModeloPersistencia{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nome", nullable = false)
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_usuario"))
	private Usuario usuario;
	
	@OneToMany(mappedBy = "equipamento", fetch = FetchType.LAZY)
	private List<Sensor> sensores;
	
	
	public Equipamento() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
