package com.example.demo.DAO;

import com.example.demo.Ultil.Connect;
import java.sql.Connection;

public interface DAO {
    Connection con= Connect.get();
}
