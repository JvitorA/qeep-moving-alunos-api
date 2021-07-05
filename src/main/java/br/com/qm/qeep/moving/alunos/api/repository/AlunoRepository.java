package br.com.qm.qeep.moving.alunos.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.qm.qeep.moving.alunos.api.entity.Aluno;

//Usando essa anotação nós diremos ao Spring que isso se trata de um
//repositório.
@Repository
//Quando extendemos o CrudRepository nós estamos herdando de uma interface em que os
//métodos básicos de Crud já estão prontos, só precisamos indicar aqui qual o tipo
//(ou a nossa entidade) e qual o tipo da sua chave, no caso é Long por que o atributo
//matricula que é chave primária do aluno é um Long.
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
//Sim, até o presente momento nós não declararemos nada dentro dessa interface.
	
	Optional<Aluno> findByCpf(String cpf);
	
	List<Aluno> findAllByValorMensalidadeGreaterThan(Float valorMensalidade);
	
}
