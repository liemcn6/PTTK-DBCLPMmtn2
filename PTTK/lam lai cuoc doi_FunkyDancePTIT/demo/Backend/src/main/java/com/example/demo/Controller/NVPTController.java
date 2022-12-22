package com.example.demo.Controller;

import com.example.demo.DAO.NVPTDAO;
import com.example.demo.Model.NVPT;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NVPTController {
    NVPTDAO nvptdao = new NVPTDAO();

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/nvptSearch")
    public List<NVPT> nvptSearch(@RequestParam String keyword){
        return nvptdao.getListByName(keyword);
    }

}
