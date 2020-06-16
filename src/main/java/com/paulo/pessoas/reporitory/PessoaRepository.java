package com.paulo.pessoas.reporitory;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.paulo.pessoas.model.Pessoa;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, String> {

}
