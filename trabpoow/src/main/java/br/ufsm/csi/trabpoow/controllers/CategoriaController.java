package br.ufsm.csi.trabpoow.controllers;

import br.ufsm.csi.trabpoow.models.Categoria;
import br.ufsm.csi.trabpoow.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("listarCategoria")
    public ModelAndView listarCategorias() {
        List<Categoria> categorias = this.categoriaRepository.findAll();
        ModelAndView mv= new ModelAndView("categoria/listarCategoria");
        mv.addObject("categorias", categorias);
        return mv;
    }

    @GetMapping("/addCategoria")
    public ModelAndView exibirFormularioAdicao() {
        Categoria categoria = new Categoria();

        ModelAndView mv = new ModelAndView("categoria/cadastrarCategoria");
        mv.addObject("categoria", categoria);
        return mv;
    }

    @PostMapping("/criarCategoria")
    public String adicionarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/listarCategoria";
    }

    @GetMapping("/editarCategoria/{id}")
    public ModelAndView exibirFormularioEdicao(@PathVariable("id") int id) {
        Categoria categoria = categoriaRepository.getReferenceById(id);
        ModelAndView mv = new ModelAndView("categoria/editarCategoria");
        mv.addObject("categoria", categoria);
        return mv;
    }

    @GetMapping("/excluirCategoria/{id}")
    public String excluirCategoria(@PathVariable("id") int id) {
        categoriaRepository.deleteById(id);
        return "redirect:/listarCategoria";
    }
}
