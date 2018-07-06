package com.tp1.DB;

import com.tp1.products.Fruit;
import com.tp1.products.Product;
import com.tp1.products.Veggie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VeggieDAO {

    private Connection connect;

    public VeggieDAO(Connection conn){
        this.connect = conn;

    }

    public ArrayList<Product> loadListOfVeggies(){
        Statement state;
        ArrayList<Product> loadListOfVeggies = new ArrayList<>();
        try {
            state = connect.createStatement();
            ResultSet result = state.executeQuery("SELECT label, origin FROM Tp1.VeggieDAO");
            while(result.next()){
                String label=result.getObject(1).toString();
                String origin=result.getObject(2).toString();

                loadListOfVeggies.add(new Veggie(label, origin));
            }
            result.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loadListOfVeggies;
    }
}
