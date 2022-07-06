package com.mayki.projcadastrobiblioteca.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.mayki.projcadastrobiblioteca.model.Livro;
import com.mayki.projcadastrobiblioteca.repository.LivroRepository;

@Service
@Transactional
@Controller
public class LivroController {

    @Autowired
    private LivroRepository rep;

    public List<Livro> listarTodos(){
        return this.rep.findAll();
    }

    public void salvar(Livro livro){
        this.rep.save(livro);
    }

    public Livro getLivro(int id){
        return this.rep.findById(id).get();
    }

    public void excluir(int id){
        this.rep.deleteById(id);
    }

    @RequestMapping("/")
    public String chamarLista(Model modelo){
        List<Livro> listaLivro = this.listarTodos();
        modelo.addAttribute("listaLivros", listaLivro);
        return "index";
    }

    @RequestMapping("/novo")
    public ModelAndView chamarNovo(){
        ModelAndView modelo = new ModelAndView("novo");
        Livro objLivro = new Livro();
        modelo.addObject("livro", objLivro);
        return modelo;
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView chamarEditar(@PathVariable(name = "id") int id){
        ModelAndView modelo = new ModelAndView("editar");
        Livro objLivro = this.getLivro(id);
        modelo.addObject("livro", objLivro);
        return modelo;
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String chamarSalvar(@ModelAttribute("livro") Livro livro){
        salvar(livro);
        return "redirect:/";
    }

    @RequestMapping("/excluir/{id}")
    public String chamarExcluir(@PathVariable(name = "id") int id){
        excluir(id);
        return "redirect:/";
    }
}
