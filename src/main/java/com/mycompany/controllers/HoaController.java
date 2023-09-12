/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojos.Hoa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.mycompany.service.HoaService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class HoaController {
    @Autowired
    private HoaService hoaService;
    
    @GetMapping("/admin/Hoa")
    public String list(Model model){
        model.addAttribute("Hoa", new Hoa());
        return "Hoa";
    }
    @GetMapping("/Hoa/{maHoa}")
    public String detail(Model model,@PathVariable(value = "maHoa")int maHoa) {
        model.addAttribute("Hoa", this.hoaService.getHoaByID(maHoa));
        return "Hoa-detail";
    }
    
    @PostMapping("/admin/Hoa")
    public String add(Model model ,@ModelAttribute(value="Hoa")@Valid Hoa hoa,BindingResult result){
        if(!result.hasErrors()){
            if(this.hoaService.addOrUpdate(hoa)==true)
                return "redirect:/";
            else
                model.addAttribute("errMgs", "Something wrong!!!");
        }
        return "Hoa";
        
}

}
