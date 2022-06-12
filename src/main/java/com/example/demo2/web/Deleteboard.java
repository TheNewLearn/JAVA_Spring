package com.example.demo2.web;

import com.example.demo2.repositories.BillboardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class Deleteboard {
    private BillboardRepository br;

    @GetMapping(path="/delete")
    public String remove(@RequestParam(name="id") Long id){
        br.deleteById(id);
        return "redirect:/";
    }
}
