package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.Optional;

import application.model.Plataforma;
import application.model.PlataformaRepository;

@Controller
@RequestMapping("/plataformas")

public class PlataformaController {
    @Autowired
    private PlataformaRepository plataformasRepo;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("plataformas", plataformasRepo.findAll());
        return "list.jsp";
    }

    @RequestMapping("insert")
    public String formInsert() {
        return "insert.jsp";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String saveInsert(@RequestParam("nome") String nome) {
        Plataforma plataforma = new Plataforma();
        plataforma.setNome(nome);
        plataformasRepo.save(genero);
        return "redirect:/plataformas/list";
    }

    @RequestMapping("update/{id}")
    public String formUpdate(Model model, @PathVariable int id) {
        Optional<Plataforma> plataforma = plataformasRepo.findById(id);
        if(!plataforma.isPresent())
            return "redirect:/plataformas/list";
        model.addAttribute("plataforma", plataforma.get());
        return "/plataformas/update.jsp";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String saveUpdate(@RequestParam("nome") String nome, @RequestParam("id") int id) {
        Optional<Plataforma> plataforma = plataformasRepo.findById(id);
        if(!plataforma.isPresent())
            return "redirect:/plataformas/list";
        plataforma.get().setNome(nome);
        plataformasRepo.save(plataforma.get());
        return "redirect:/plataformas/list";
    }

    @RequestMapping("delete/{id}")
    public String formDelete(Model model, @PathVariable int id) {
        Optional<Plataforma> plataforma = plataformasRepo.findById(id);
        if(!plataforma.isPresent())
            return "redirect:/plataformas/list";
        model.addAttribute("plataforma", plataforma.get());
        return "/plataformas/delete.jsp";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String saveDelete(@RequestParam("id") int id) {
        plataformasRepo.deleteById(id);
        return "redirect:/plataformas/list";
    }
}