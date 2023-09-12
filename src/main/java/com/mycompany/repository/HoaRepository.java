/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojos.Hoa;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface HoaRepository {
    List<Hoa> gethoas(String kw, int page);
    Hoa getHoaByID(int hoaId);
    boolean addOrUpdate(Hoa hoa);
    long countHoa();
    
}
