package br.com.logap.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cliente extends Pessoa{

	public Cliente(){}
	
}