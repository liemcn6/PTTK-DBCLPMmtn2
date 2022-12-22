package com.example.demo.Controller;

import com.example.demo.DAO.LichDKDAO;
import com.example.demo.Model.LichDK;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LichDKController {
    LichDKDAO lichDKDAO = new LichDKDAO();

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getLichDKByNVPTId")
    public LichDK getLichDKByNVPTId(@RequestParam int nvptId){
        System.out.println(nvptId);
        return lichDKDAO.getLichDKByNVPTId(nvptId);
    }
}
