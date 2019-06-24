package com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.livraria.model.Livro;
import com.livraria.repository.Livros;

@Controller
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private Livros lr;

	@GetMapping
	public ModelAndView showCourses() {
		ModelAndView mv = new ModelAndView("Livros");
		mv.addObject("livros", lr.findAll());
		Livro c = new Livro();
		mv.addObject("livro", c);
		return mv;
	}

	 @PostMapping
	 public String addLivro(Livro l) {
		lr.save(l);
	 	return	 "redirect:/livros"; }
	 
	 @RequestMapping("/delete/{id}")
	 public String deleteLivro(@PathVariable Long id) {
		Livro c = lr.findOne(id);
		lr.delete(c.getId());
		return "redirect:/livros";
	 }	

}
