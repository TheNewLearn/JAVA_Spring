package com.example.demo2.web;

import com.example.demo2.entities.Billboard;
import com.example.demo2.repositories.BillboardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class Editboard {
    private BillboardRepository br;
    @GetMapping(path="/border")
    public String editboard(Model model,@RequestParam(name="id") Long bid){
        Optional<Billboard> billboard = br.findById(bid);
        model.addAttribute("bordercontent",billboard.get());
        System.out.println(billboard.get());
        return "board";
    }

}
