package com.paulo.pessoas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.paulo.pessoas.model.Pessoa;
import com.paulo.pessoas.reporitory.PessoaRepository;

@Service
public class PessoaService {

	@Autowired private PessoaRepository pessoaRepository;
	
	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	public Pessoa buscarPorId(String id) {
		return pessoaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
	}

	@Transactional
	public void deletarPorId(String id) {
		this.buscarPorId(id);
		pessoaRepository.deleteById(id);
	}

	public Pessoa editar(Pessoa pessoa, String id) {
		Pessoa pessoaPersistida = this.buscarPorId(id);
		pessoaPersistida.setNome(pessoa.getNome());
		pessoaPersistida.setIdade(pessoa.getIdade());
		return pessoaRepository.save(pessoaPersistida);
	}
}
