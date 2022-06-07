package com.example.demo2.web;

import com.example.demo2.entities.Billboard;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo2.repositories.BillboardRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@AllArgsConstructor
public class Addbillboard {
    private BillboardRepository br;
    @GetMapping(path="/addbillboard")
    public String add_board(){
        System.out.print(new Date());
        return "add_board";

    }

    @PostMapping(path = "/addbillboard")
    public String submitform(@RequestParam String title, String enddate, String content) throws Exception{
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date cdate = formatter.parse(enddate);
            br.save(new Billboard(null,title,new Date(),"Admin",cdate,content));
            System.out.println(cdate);
        return "redirect:/index";

    }
}
