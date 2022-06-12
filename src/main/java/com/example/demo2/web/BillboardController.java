package com.example.demo2.web;

import com.example.demo2.entities.Billboard;
import com.example.demo2.repositories.BillboardRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class BillboardController {
    private BillboardRepository br;
    @GetMapping(path = "/")
    public String billboard(Model model, @RequestParam(name="page",defaultValue = "0")int page){
        Page<Billboard> billboardList = br.findAll(PageRequest.of(page,10));
        model.addAttribute("listbillboard",billboardList.getContent());
        model.addAttribute("pages",new int[billboardList.getTotalPages()]);
        model.addAttribute("cp",billboardList.getNumber()+1);
        model.addAttribute("pp",billboardList.getNumber()-1);
        model.addAttribute("size",billboardList.getTotalPages());
        model.addAttribute("currentPage",page);
        return "billboard";
    }

    @GetMapping(path="/delete")
    public String remove(@RequestParam(name="id") Long id, @RequestParam(name="page") int p){
        br.deleteById(id);
        return "redirect:/?page=" +p;
    }
}
