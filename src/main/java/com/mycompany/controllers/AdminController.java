/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.service.HoaService;
import com.mycompany.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StatsService statsService;
    @Autowired
    private HoaService hoaService;
    
    @GetMapping("/hoa-stats")
    public String hoaStats(Model model, @RequestParam(required = false) Map<String, String> params){
        SimpleDateFormat f= new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        Date fromDate = null,toDate = null;
        try{
            String from = params.getOrDefault("fromDate",null);
            if(from != null)
            fromDate = f.parse(from);
            String to = params.getOrDefault("toDate",null);
            if(to != null)
                toDate = f.parse(to);
        }catch (ParseException ex){
            ex.printStackTrace();
        }
        
        model.addAttribute("hoaStats", this.statsService.hoaStats(kw, fromDate, toDate));
        return "hoa-stats";
    }
}
