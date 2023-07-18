package br.ufsm.csi.trabpoow.controllers;

import br.ufsm.csi.trabpoow.models.Plataforma;
import br.ufsm.csi.trabpoow.repositories.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PlataformaController {
    @Autowired
    private PlataformaRepository plataformaRepository;

    @GetMapping("listarPlataforma")
    public ModelAndView listarPlataformas(Model model) {
        List<Plataforma> plataformas = this.plataformaRepository.findAll();
        ModelAndView mv= new ModelAndView("plataforma/listarPlataforma");
        mv.addObject("plataformas", plataformas);
        return mv;
    }

    @GetMapping("/addPlataforma")
    public ModelAndView exibirFormularioAdicao() {
        Plataforma plataforma = new Plataforma();

        ModelAndView mv = new ModelAndView("plataforma/cadastrarPlataforma");
        mv.addObject("plataforma", plataforma);
        return mv;
    }

    @PostMapping("/criarPlataforma")
    public String adicionarPlataforma(Plataforma plataforma) {
        plataformaRepository.save(plataforma);
        return "redirect:/listarPlataforma";
    }

    @GetMapping("/editarPlataforma/{id}")
    public ModelAndView exibirFormularioEdicao(@PathVariable("id") int id) {
        Plataforma plataforma = plataformaRepository.getReferenceById(id);
        ModelAndView mv = new ModelAndView("plataforma/editarPlataforma");
        mv.addObject("plataforma", plataforma);
        return mv;
    }

    @GetMapping("/excluirPlataforma/{id}")
    public String excluirPlataforma(@PathVariable("id") int id) {
        plataformaRepository.deleteById(id);
        return "redirect:/listarPlataforma";
    }
}
