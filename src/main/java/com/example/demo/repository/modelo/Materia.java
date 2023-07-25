package com.example.demo.repository.modelo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.aspectj.weaver.CompressingDataOutputStream;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.World;
import org.aspectj.weaver.patterns.Declare;
import org.aspectj.weaver.patterns.IScope;
import org.aspectj.weaver.patterns.PatternNodeVisitor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {
	
	@Id
	@GeneratedValue(generator = "seq_materia",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@Column(name = "mate_id")
	private Integer id;
	
	
	@Column(name = "mate_nombre")
	private String nombre;
	
	@Column(name = "mate_horas_academicas")
	private String horasAcademicas;
	
	@Column(name = "mate_codigo")
	private String codigo;
	
	@OneToMany(mappedBy = "materia")
	private List<Matricula> matriculas;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mate_id_semestre")
	private Semestre semestre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHorasAcademicas() {
		return horasAcademicas;
	}

	public void setHorasAcademicas(String horasAcademicas) {
		this.horasAcademicas = horasAcademicas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", horasAcademicas=" + horasAcademicas + ", codigo="
				+ codigo + ", semestre=" + semestre + "]";
	}
	
	Declare c = new Declare() {
		
		
		
		@Override
		public void write(CompressingDataOutputStream s) throws IOException {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public Object accept(PatternNodeVisitor visitor, Object data) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void resolve(IScope scope) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public Declare parameterizeWith(Map<String, UnresolvedType> typeVariableBindingMap, World w) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean isAdviceLike() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public String getNameSuffix() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	
}
