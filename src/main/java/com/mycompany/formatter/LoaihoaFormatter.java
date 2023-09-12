/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formatter;

import com.mycompany.pojos.Loaihoa;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author Admin
 */
public class LoaihoaFormatter implements Formatter<Loaihoa>{

    @Override
    public String print(Loaihoa t, Locale locale) {
       return String.valueOf(t.getMaLoaiHoa());
    }

    @Override
    public Loaihoa parse(String Maloai, Locale locale) throws ParseException {
        Loaihoa c= new Loaihoa();
        c.setMaLoaiHoa(Integer.parseInt(Maloai));
        return c;
    }
    
}
