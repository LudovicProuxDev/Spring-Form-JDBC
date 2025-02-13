package com.example.form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.bll.jdbc.FormtestServiceJDBC;
import com.example.form.bo.Formtest;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class FormtestController {

    @Autowired
    FormtestServiceJDBC formtestServiceJDBC;

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("listFormtests", formtestServiceJDBC.showFormtests());
        return "index";
    }

    @GetMapping("new")
    public String getNewFormtest(Model model) {
        model.addAttribute("formtest", new Formtest());
        return "formtest/new";
    }

    @PostMapping("new")
    public String postNewFormtest(@Valid Formtest formtest) {
        // Create the formtest
        formtestServiceJDBC.createFormtest(formtest);
        // Redirect to the index
        return "redirect:/";
    }

    @GetMapping("{id}")
    public String getShowFormtest(@PathVariable("id") Integer id, Model model) {
        Formtest formtest = formtestServiceJDBC.showFormtestById(id);
        model.addAttribute("formtest", formtest);
        return "formtest/show";
    }

    @GetMapping("{id}/edit")
    public String getEditFormtest(@PathVariable("id") Integer id, Model model) {
        Formtest formtest = formtestServiceJDBC.showFormtestById(id);
        model.addAttribute("formtest", formtest);
        return "formtest/edit";
    }

    @PostMapping("{id}/edit")
    public String postEditFormtest(@PathVariable("id") Integer id, @Valid Formtest formtest) {
        // Ensure the formtest object has the correct ID
        formtest.setId(id);
        // Update the formtest
        formtestServiceJDBC.updateFormtest(formtest);
        // Redirect to the formtest
        return "redirect:/" + id;
    }

    @PostMapping("{id}/delete")
    public String deleteFormtest(@PathVariable("id") Integer id) {
        // Delete the formtest
        formtestServiceJDBC.deleteFormtest(id);
        // Redirect to the index
        return "redirect:/";
    }
}
