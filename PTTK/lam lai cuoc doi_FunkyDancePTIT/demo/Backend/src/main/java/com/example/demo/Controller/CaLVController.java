package com.example.demo.Controller;

import com.example.demo.DAO.CaLVDAO;
import com.example.demo.Model.CaLV;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaLVController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllCaLV")
    public List<CaLV> getAllCaLV(){
        CaLVDAO calvDao = new CaLVDAO();
        return calvDao.getAllCaLV();
    }

}
