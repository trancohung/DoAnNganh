     /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojos.Hoa;
import com.mycompany.repository.HoaRepository;
import com.mycompany.service.HoaService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class HoaServiceImpl implements HoaService{
    @Autowired
    private HoaRepository hoaRepository;
    @Autowired
    private Cloudinary cloudinary;
    @Override
    public List<Hoa> getHoas(String kw, int page) {
        return this.hoaRepository.gethoas(kw, page);
    }

    @Override
    public boolean addOrUpdate(Hoa hoa) {
            try {
                Map r = this.cloudinary.uploader().upload(hoa.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type","auto"));
                hoa.setHinhanh((String) r.get("secure_url"));
                hoa.setMaHoa(Integer.SIZE);
                return this.hoaRepository.addOrUpdate(hoa);
            } catch (IOException ex) { 
                System.err.println(ex.getMessage() + "== ADD Hoa ==");
            }
            
            return false;
    }

    @Override
    public long countHoa() {
        return this.hoaRepository.countHoa();
    }

    @Override
    public Hoa getHoaByID(int i) {
       return this.hoaRepository.getHoaByID(i);
    }

    
    
}
