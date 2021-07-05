package br.com.qm.qeep.moving.alunos.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qm.qeep.moving.alunos.api.entity.Aluno;
import br.com.qm.qeep.moving.alunos.api.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repository;
	
	public Aluno insereAluno(Aluno aluno) {
		
		if (repository.existsById(aluno.getMatricula())) {
			return null;
		}
  		
		return repository.save(aluno);
	}
	
	public Optional<Aluno> consultaAluno(Long matricula) {
		return repository.findById(matricula);
	}
	
	public List<Aluno> listaAlunos() {
		return (List<Aluno>) repository.findAll();
	}
	
	public boolean removeAluno(Long matricula) {
		
		if(!repository.existsById(matricula)) {
			return false;
		}
		
		
		repository.deleteById(matricula);
		return true;
		
	}
	
	public Aluno alteraAluno(Long matricula, Aluno aluno) {
		
		if (!matricula.equals(aluno.getMatricula())) {
			return null;
		}
		
		if (!repository.existsById(aluno.getMatricula())) {
			return null;
		}
		
		return repository.save(aluno);
	}
	
	public List<Aluno> listaAlunosMensalidadeMaior(Float valorMensalidade) {
		return repository.findAllByValorMensalidadeGreaterThan(valorMensalidade);
	}
	
}
