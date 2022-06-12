package com.example.demo2.web;

import com.example.demo2.entities.Billboard;
import com.example.demo2.repositories.BillboardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class Editboard {
    private BillboardRepository br;
    @GetMapping(path="/border")
    public String editboard(Model model,@RequestParam(name="id") Long bid){
        Optional<Billboard> billboard = br.findById(bid);
        model.addAttribute("bordercontent",billboard.get());
        return "board";
    }

    @PostMapping(path="/border")
    public String modifyborder(@RequestParam(name="id") Long id,@RequestParam(name="title") String title,@RequestParam(name="post_date") String post_date, @RequestParam(name="enddate") String enddate, @RequestParam(name="content") String content) throws Exception{
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date pd = formatter.parse(post_date);
        Date ed = formatter.parse(enddate);
        br.save(new Billboard(id,title,pd,"Admin",ed,content));
        return "redirect:/";
    }


}
