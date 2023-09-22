package br.com.isabela.layout.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.isabela.layout.model.Contato;

@Controller
public class ContatoController {

  List<Contato> contatos = new ArrayList<>();

  @GetMapping("/create")
  public ModelAndView home() {
    ModelAndView mv = new ModelAndView("create");
    mv.addObject("contato", new Contato());
    return mv;
  }

  @PostMapping("/create")
  public String create(Contato contato) {
    System.out.println(" Get ID" + contato.getId());

    if (contato.getId() != null) {
      Contato contatoFind = contatos.stream().filter(contatoItem -> contato.getId().equals(contatoItem.getId())).findFirst().get();
      contatos.set(contatos.indexOf(contatoFind), contato);
    } else {
      Long id = contatos.size() + 1L;
      contatos.add(new Contato(id, contato.getName(), contato.getDate(), contato.getMatricula()));
    }

    return "redirect:/list";
  }

  @GetMapping("/list")
  public ModelAndView list() {
    ModelAndView mv = new ModelAndView("list");
    mv.addObject("contatos", contatos);
    return mv;
  }

  @GetMapping("/edit/{id}")
  public ModelAndView edit(@PathVariable("id") Long id) {
    ModelAndView mv = new ModelAndView("create");

    Contato contatoFind = contatos.stream().filter(contato -> id.equals(contato.getId())).findFirst().get();
    mv.addObject("contato", contatoFind);
    return mv;
  }

  @GetMapping("/delete/{id}")
public ModelAndView delete(@PathVariable("id") Long id) {
    // Encontre o contato pelo ID
    Contato contatoFind = contatos.stream().filter(contato -> id.equals(contato.getId())).findFirst().orElse(null);

    if (contatoFind != null) {
        // Remova o contato da lista
        contatos.remove(contatoFind);
    }

    ModelAndView mv = new ModelAndView("list");
    mv.addObject("contatos", contatos);
    return mv;
}
}
