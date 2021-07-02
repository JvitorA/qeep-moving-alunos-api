package br.com.qm.qeep.moving.alunos.api.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Aluno {
	
	@Id
	private long matricula;
	// Aqui nos deparamos com uma outra propriedade da anotação
	// Column, que é o nullable, equivale a dizer que no BD essa
	// coluna será not null;
	@Column(nullable = false)
	private String nome;
	@Column(name = "data_nascimento", nullable = false)
	// A anotação DateTimeFormat serve para indicar em que formato iremos
	// receber a nossa data (já discutiremos sobre JSON) e como convertê-la
	// da maneira que nós precisamos.
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataNascimento;
	// Aqui nos deparamos com a propriedade unique, que
	// equivale a dizer que no BD essa coluna será unique.
	@Column(unique = true)
	private String cpf;
	@Column(name = "valor_mensalidade", nullable = false)
	private Float valorMensalidade;
	//GETTERS E SETTER OMITIDOS
	
	public Aluno(long matricula, String nome, LocalDate dataNascimento, String cpf, Float valorMensalidade) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.valorMensalidade = valorMensalidade;
	}
	
	public Aluno() {
		super();
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Float getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(Float valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

}