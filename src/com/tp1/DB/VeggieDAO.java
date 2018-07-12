package com.tp1.DB;

import com.tp1.products.Fruit;
import com.tp1.products.Product;
import com.tp1.products.Veggie;

import java.sql.*;
import java.util.ArrayList;

public class VeggieDAO {

    private Connection connect;

    public VeggieDAO(Connection conn){
        this.connect = conn;

    }

    /**
     * DAO Veggies
     * @return load list of veggies
     */
    public ArrayList<Product> loadListOfVeggies(){
        Statement state;
        ArrayList<Product> loadListOfVeggies = new ArrayList<>();
        try {
            state = connect.createStatement();
            ResultSet result = state.executeQuery("SELECT id, label, origin FROM Tp1.VeggieDAO");
            while(result.next()){
                Integer id=result.getInt(1);
                String label=result.getObject(2).toString();
                String origin=result.getObject(3).toString();

                loadListOfVeggies.add(new Veggie(id, label, origin));
            }
            result.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loadListOfVeggies;
    }

    public void addVeggieToDB(Product newVeggie){

        try{
            PreparedStatement prepare = connect.prepareStatement("INSERT INTO Tp1.VeggieDAO (label, origin) VALUES (?, ?)");
            prepare.setString(1, newVeggie.getLabel());
            prepare.setString(2, newVeggie.getOrigin());

            prepare.executeUpdate();

            prepare.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifyVeggieFromDB(int id, Product veggieToModify){
        try{
            PreparedStatement prepare = connect.prepareStatement("UPDATE Tp1.VeggieDAO SET label=?, origin=?" + "WHERE id ="+id);
            prepare.setString(1, veggieToModify.getLabel());
            prepare.setString(2, veggieToModify.getOrigin());

            prepare.executeUpdate();

            prepare.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVeggieFromDB(Product id){
        try {
            PreparedStatement prepare = connect.prepareStatement("DELETE FROM Tp1.VeggieDAO WHERE id = ?");
            prepare.setInt(1,id.getId());

            prepare.executeUpdate();
            prepare.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
