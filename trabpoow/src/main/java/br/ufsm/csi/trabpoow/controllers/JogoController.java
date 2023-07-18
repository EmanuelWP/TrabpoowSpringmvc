package br.ufsm.csi.trabpoow.controllers;

import br.ufsm.csi.trabpoow.models.Jogo;
import br.ufsm.csi.trabpoow.repositories.CategoriaRepository;
import br.ufsm.csi.trabpoow.repositories.JogoRepository;
import br.ufsm.csi.trabpoow.repositories.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private PlataformaRepository plataformaRepository;


    @GetMapping("listarJogo")
    public ModelAndView listarJogos() {
        List<Jogo> jogos = this.jogoRepository.findAll();
        ModelAndView mv= new ModelAndView("jogo/listarJogo");
        mv.addObject("jogos", jogos);
        return mv;
    }

    @GetMapping("/addJogo")
    public ModelAndView exibirFormularioAdicao() {
        Jogo jogo = new Jogo();

        ModelAndView mv = new ModelAndView("jogo/cadastrarJogo");
        mv.addObject("jogo", jogo);
        mv.addObject("categorias", categoriaRepository.findAll());
        mv.addObject("plataformas", plataformaRepository.findAll());
        return mv;
    }

    @PostMapping("/criarJogo")
    public String adicionarJogo(Jogo jogo) {
        jogoRepository.save(jogo);
        return "redirect:/listarJogo";
    }

    @GetMapping("/editarJogo/{id}")
    public ModelAndView exibirFormularioEdicao(@PathVariable("id") int id) {
        Jogo jogo = jogoRepository.findById(id);
        ModelAndView mv = new ModelAndView("jogo/editarJogo");
        mv.addObject("jogo", jogo);
        mv.addObject("categorias", categoriaRepository.findAll());
        mv.addObject("plataformas", plataformaRepository.findAll());
        return mv;
    }

    @GetMapping("/excluirJogo/{id}")
    public String excluirJogo(@PathVariable("id") int id) {
        jogoRepository.deleteById(id);
        return "redirect:/listarJogo";
    }
}
