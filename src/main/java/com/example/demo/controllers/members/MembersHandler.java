package com.example.demo.controllers.members;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/members")
public class MembersHandler {

    @GetMapping("")
    public String members() {
        return "members/members";
    }

    @GetMapping("/new_member")
    public String newMember() {
        return "members/new_member";
    }

    @PostMapping("/new_member/create")
    public String createNewMember(@RequestParam String name,
                                  @RequestParam String lastName) {
        System.out.println(name + " " + lastName);
        return "redirect:/members";
    }

}
