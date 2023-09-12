/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.pojos.Hoa;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface HoaService {
    List<Hoa> getHoas(String kw, int page);
    boolean addOrUpdate(Hoa hoa);
    long countHoa();
    Hoa getHoaByID(int hoaId);
    
}
