package com.tp1.DB;

import com.tp1.products.Fruit;
import com.tp1.products.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FruitDAO {
    private Connection connect;


    public FruitDAO(Connection conn){
        this.connect = conn;
    }



    public ArrayList<Product> loadListOfFruits(){
        Statement state;
        ArrayList<Product> loadListOfFruits = new ArrayList<>();
        try {
            state = connect.createStatement();
            ResultSet result = state.executeQuery("SELECT label, origin FROM Tp1.FruitDAO");
            while(result.next()){
                String label=result.getObject(1).toString();
                String origin=result.getObject(2).toString();

                loadListOfFruits.add(new Fruit(label, origin));
            }
            result.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loadListOfFruits;
    }


//    public Fruit find(int id) {
//        Fruit fruit = new Fruit();
//
//
//
//    try{
//        ResultSet result = this.connect.createStatement(
//
//                ResultSet.TYPE_SCROLL_INSENSITIVE,
//
//                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Tp1.FruitDAO WHERE id = " + id);
//
//        if(result.first())
//            fruit = new Fruit(
//                    id,
//                    result.getString("label"),
//
//                    result.getString("origin"
//                    ));
//    } catch (SQLException e){
//        e.printStackTrace();
//    }
//        return fruit;
//    }
}
