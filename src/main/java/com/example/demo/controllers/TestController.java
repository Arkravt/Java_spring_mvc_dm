package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/intro")
public class TestController {

    /*
    Если мы используем аннотацию @ResponseBody, то возвращаемое значение будет строка, если этой аннотации не будет,
    тогда в качестве возвращаемого значения будет подставляться файл templates/home.html.

    Вместо аннотации класса @Controller можно использовать аннотацию @RestController. @RestController включает в себя
    аннотацию для @ResponseBody, следовательно, не придется каждый метод аннотировать этой аннотацией.

    С помощью @PathVariable мы из url извлекаем параметры.
    Если имя параметра пути отличается, мы можем указать его в аргументе аннотации @PathVariable("id")

    @RequestParam - обычно используется, когда параметры передаются в URL после символа ?
    Например, http://localhost:8080/spring-mvc-basics/api/foos?id=abc
     */

    //@ResponseBody
    @GetMapping(value = "/home")
    public String getInfo() {
        return "testController/home";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers() {
        return "testController/users";
    }

    @GetMapping(value = "CompanyName")
    public @ResponseBody String getCompanyName() {
        return "OOO Company";
    }

    @ResponseBody
    @GetMapping(value = "/user/{id}")
    public String getUserById(@PathVariable("id") String id) {
        return "User id: " + id;
    }

    @ResponseBody
    @GetMapping(value = "/user/{id}/{name}")
    public String getUserByIdAndName(
            @PathVariable("id") String userID,
            @PathVariable("name") String userName
    ) {
        //return "Id: " + userID + "; Name: " + userName;
        return String.format("UserID: %s; UserName: %s", userID, userName);
    }

    @ResponseBody
    @GetMapping(value = "/user", params = {"name", "lastname"})
    public String getUserByNameAndLastName(
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastName
    ) {
        return String.format("name: %s last name: %s", name, lastName);
    }

}
