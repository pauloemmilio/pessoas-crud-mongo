package com.paulo.pessoas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.pessoas.model.Pessoa;
import com.paulo.pessoas.service.PessoaService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired private PessoaService pessoaService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Pessoa cadastrar(@RequestBody @Valid Pessoa pessoa) {
		return pessoaService.salvar(pessoa);
	}
	
	@GetMapping
	public List<Pessoa> listar(){
		return pessoaService.listar();
	}
	
	@GetMapping("/{id}")
	public Pessoa getById(String id) {
		return pessoaService.getById(id);
	}
}
