package com.example.demo.controllers.members;

import com.example.demo.controllers.models.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/members")
public class MembersHandler {

    /*
    Model - это то что передается в шаблон. Находясь в контроллере можно положить какие-то данные в Model и в шаблоне
    эти данные использовать. Model по структуре очень похож на Map. У каждого метода своя область видимости и
    поэтому у Model область видимости так же только в рамках метода.
     */

    private List<Member> members = new ArrayList<>();

    @GetMapping("")
    public String members(Model model) {
        model.addAttribute("members", members);
        return "members/members";
    }

    @GetMapping("/new_member")
    public String newMember() {
        return "members/new_member";
    }

    @PostMapping("/new_member/create")
    public String createNewMember(@RequestParam String name,
                                  @RequestParam String lastName) {
        members.add(new Member(name, lastName));
        return "redirect:/members";
    }

}
