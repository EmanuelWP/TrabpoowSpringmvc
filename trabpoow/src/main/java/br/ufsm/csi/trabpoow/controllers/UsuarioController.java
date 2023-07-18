package br.ufsm.csi.trabpoow.controllers;

import br.ufsm.csi.trabpoow.models.Usuario;
import br.ufsm.csi.trabpoow.repositories.CategoriaRepository;
import br.ufsm.csi.trabpoow.repositories.JogoRepository;
import br.ufsm.csi.trabpoow.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final JogoRepository jogoRepository;
    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository, JogoRepository jogoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.jogoRepository = jogoRepository;
    }

    @GetMapping
    public ModelAndView exibirFormularioLogin() {

        ModelAndView mv = new ModelAndView("usuario/login");
        mv.addObject("usuario", new Usuario());
        return mv;
    }

    @PostMapping("/login")
    public String realizarLogin(Usuario usuario) {
        usuario = usuarioRepository.findByNome(usuario.getNome());
        if (usuario != null && usuario.getSenha().equals(usuario.getSenha())) {
            return "redirect:../usuarios/menuPrincipal";
        } else {
            return "login";
        }
    }

    @GetMapping("/new")
    public ModelAndView exibirFormularioCadastro() {
        ModelAndView mv = new ModelAndView("usuario/cadastroUsuario");
        mv.addObject("usuario", new Usuario());
        return mv;
    }

    @PostMapping
    public ModelAndView realizarCadastro(Usuario usuario) {

        ModelAndView mv = new ModelAndView("usuario/login");
        usuarioRepository.save(usuario);
        return mv;
    }

    @GetMapping("/menuPrincipal")
    public ModelAndView exibirDashboard() {
        ModelAndView mv= new ModelAndView("/menuPrincipal");
        mv.addObject("relatorioJogosAvaliados", jogoRepository.obterRelatorioJogosAvaliados());
        return mv;
    }

}

