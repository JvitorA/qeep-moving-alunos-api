package br.com.qm.qeep.moving.alunos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.qm.qeep.moving.alunos.api.entity.Aluno;
import br.com.qm.qeep.moving.alunos.api.entity.ObjetoX;
import br.com.qm.qeep.moving.alunos.api.repository.AlunoRepository;

//A anotação @RestController do Spring serve para nos
//dizer que essa classe se trata de um Controller.
@RestController
//A anotação @RequestMapping("/alunos") serve para especificar
//o endereço da url pela qual acessaremos alunos.
@RequestMapping("/alunos")
public class AlunoController {
	//A anotação autowired é a anotação do spring responsável por
	//injetar as nossas dependências, usando ela nós não precisaremos
	//mais criar por nós mesmos as instâncias de um objeto, o Spring
	//passa a se encarregar disso.
	@Autowired
	AlunoRepository repository;

	@PostMapping
	public Aluno insereAluno(@RequestBody Aluno aluno) {
		return this.repository.save(aluno);
	}

	//Aqui, a propriedade Path nos diz que iremos utilizar a
	//nossa url para enviar o número de matrícula do aluno
	//que desejamos buscar
	@GetMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Aluno buscaAluno(@PathVariable Long matricula) {
		return repository.findById(matricula).get();
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Aluno> buscaAlunos() {
		return (List<Aluno>) repository.findAll();
	}
	
	@DeleteMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ObjetoX removeAluno(@PathVariable Long matricula) {
		repository.deleteById(matricula);
		return new ObjetoX("UmValor", "outroValor");
	}
	
	
}
