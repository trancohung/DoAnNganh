/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;



import com.mycompany.pojos.Cart;
import com.mycompany.pojos.Loaihoa;
import com.mycompany.service.HoaService;
import com.mycompany.service.LoaihoaService;
import com.mycompany.utills.Utils;
import com.mysql.cj.Query;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private LoaihoaService  loaihoaService; 
    @Autowired
    private HoaService hoaService;
    
    @ModelAttribute
    public void commonAttr(Model model, HttpSession session){
         model.addAttribute("Loaihoa",this.loaihoaService.getLoaihoa());
         model.addAttribute("cartCounter",Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
    }
    @RequestMapping("/")
    @Transactional
    public String index(Model model,
            @RequestParam(required = false) Map<String, String> params){
        String kw = params.getOrDefault("kw", null);
        int page= Integer.parseInt(params.getOrDefault("page", "1"));
        String cateId = params.get("CateID");
        if(cateId == null){
            model.addAttribute("Hoa",this.hoaService.getHoas(kw, page));
        }else{
            Loaihoa c = this.loaihoaService.getLoaiHoaById(Integer.parseInt(cateId));
            model.addAttribute("Hoa", c.getHoaCollection());
        }
        model.addAttribute("counts", this.hoaService.countHoa());
       
        return "index";
    }
    
    @RequestMapping(path="/cart")
    public String index(Model model){
        return "cart";
    }
     
}
