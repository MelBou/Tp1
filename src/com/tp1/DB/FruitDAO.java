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


    /**
     * DAO Fruits
     * @return load list of fruits
     */
    public ArrayList<Product> loadListOfFruits(){
        Statement state;
        ArrayList<Product> loadListOfFruits = new ArrayList<>();
        try {
            state = connect.createStatement();
            ResultSet result = state.executeQuery("SELECT id, label, origin FROM Tp1.FruitDAO");
            while(result.next()){
                Integer id=result.getInt(1);
                String label=result.getObject(2).toString();
                String origin=result.getObject(3).toString();

                loadListOfFruits.add(new Fruit(id, label, origin));
            }
            result.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loadListOfFruits;
    }

    public void addFruitToDB(Product newFruit){

        try{
            PreparedStatement prepare = connect.prepareStatement("INSERT INTO Tp1.FruitDAO (label, origin) VALUES (?, ?)");
            prepare.setString(1, newFruit.getLabel());
            prepare.setString(2, newFruit.getOrigin());

            prepare.executeUpdate();

            prepare.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifyFruitFromDB(int id, Product fruitToModify){
        try{
            PreparedStatement prepare = connect.prepareStatement("UPDATE Tp1.FruitDAO SET label=?, origin=?" + "WHERE id ="+id);
            prepare.setString(1, fruitToModify.getLabel());
            prepare.setString(2, fruitToModify.getOrigin());

            prepare.executeUpdate();

            prepare.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFruitFromDB(Product id){
        try {
            PreparedStatement prepare = connect.prepareStatement("DELETE FROM Tp1.FruitDAO WHERE id = ?");
            prepare.setInt(1,id.getId());

            prepare.executeUpdate();
            prepare.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
