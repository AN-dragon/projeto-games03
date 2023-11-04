import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

import alanorisio.games.models.Jogo;
import alanorisio.games.repositories.JogoRepository;
import alanorisio.games.models.Plataforma;
import alanorisio.games.repositories.PlataformaRepository;
import alanorisio.games.repositories.GeneroRepository;

@Controller
@RequestMapping("/jogos")

public class JogoController {
    @Autowired
    private JogoRepository jogosRepo;

    @Autowired
    private GeneroRepository generosRepo;

    @Autowired
    private PlataformaRepository plataformasRepo;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("jogos", jogosRepo.findAll());
        return "list.jsp";
    }

    @RequestMapping("insert")
    public String formInsert(Model model) {
        model.addAttribute("generos", generosRepo.findAll());
        model.addAttribute("plataformas", plataformasRepo.findAll());
        return "insert.jsp";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String saveInsert(@RequestParam("titulo") String titulo, @RequestParam("genero") int generoId,
        @RequestParam("plataformas") int[] plataformas) {
            Jogo jogo = new Jogo();
            jogo.setTitulo(titulo);
            jogo.setGenero(generosRepo.findById(generoId).get());
            for(int p : plataformas) {
                Optional<Plataforma> plataforma = plataformasRepo.findById(p);
                if(plataforma.isPresent())
                    jogo.getPlataforma().add(plataforma.get());
            }
            jogosRepo.save(jogo);
        return "redirect:/jogos/list";
    }
    /*=================================================<aqui>*/

    @RequestMapping("update/{id}")
    public String formUpdate(Model model, @PathVariable int id) {
        Optional<Genero> genero = generosRepo.findById(id);
        if(!genero.isPresent())
            return "redirect:/generos/list";
        model.addAttribute("genero", genero.get());
        return "/generos/update.jsp";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String saveUpdate(@RequestParam("nome") String nome, @RequestParam("id") int id) {
        Optional<Genero> genero = generosRepo.findById(id);
        if(!genero.isPresent())
            return "redirect:/generos/list";
        genero.get().setNome(nome);
        generosRepo.save(genero.get());
        return "redirect:/generos/list";
    }

    @RequestMapping("delete/{id}")
    public String formDelete(Model model, @PathVariable int id) {
        Optional<Genero> genero = generosRepo.findById(id);
        if(!genero.isPresent())
            return "redirect:/generos/list";
        model.addAttribute("genero", genero.get());
        return "/generos/delete.jsp";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String saveDelete(@RequestParam("id") int id) {
        generosRepo.deleteById(id);
        return "redirect:/generos/list";
    }
}