package com.tp1.users;

import com.tp1.management.Basket;
import com.tp1.management.Catalog;
import com.tp1.management.UserManagement;

import java.util.Scanner;

/**
 * Display admin's menu
 * Handle action
 * Add/Modify/Delete a user
 */
public class Admin extends User {

    public Admin(String firstname, String name, String town, String login, String password){

        super(firstname, name, town, login, password);
    }

    @Override
    public void showMenu() {
        super.showMenu();
        System.out.println("4 --- Créer un utilisateur");
        System.out.println("5 --- Modifier les informations d'un utilisateur");
        System.out.println("6 --- Supprimer un utilisateur");
        System.out.println("7 --- Afficher la liste des utilisateurs");
        System.out.println("-------------------------------------------------");
    }

    @Override
    protected boolean handleAction(Scanner sc, int answer, Catalog catalog, UserManagement userManagement, Basket basket) {
        boolean handleActionAnswer = super.handleAction(sc, answer, catalog, userManagement, basket);
        if (!handleActionAnswer)
            switch (answer){
                case 4:
                    addUser(sc, userManagement);
                    return true;
                case 5:
                    modifyUser(sc, userManagement);
                    return true;
                case 6:
                    deleteUser(sc, userManagement);
                    return true;
                case 7 :
                    userManagement.getUserList();
                    return true;
            } else {
            return true;
        }
        return false;
    }


    private void addUser(Scanner sc, UserManagement userManagement) {
        System.out.println("1 --- Ajouter un admin");
        System.out.println("2 --- Ajouter un client");
        System.out.println("3 --- Ajouter un commercial");
        int choiceToAdd = sc.nextInt();

        switch (choiceToAdd){
            case 1:
                this.addNewUser(sc, userManagement, "admin");
                break;
            case 2:
                this.addNewUser(sc, userManagement, "client");
                break;
            case 3:
                this.addNewUser(sc, userManagement, "commercial");
                break;
            default:
                System.out.println("Oops");
        }
    }

    public void addNewUser(Scanner sc, UserManagement userManagement, String typeUser) {
        String addFirstname;
        String addName;
        String addTown;
        String addLogin;
        String addPassword;
        System.out.println("Indiquez le prénom de l'utilisateur à ajouter");
        addFirstname = sc.next();
        System.out.println("Indiquez le nom de l'utilisateur à ajouter");
        addName = sc.next();
        System.out.println("Indiquez la ville de l'utilisateur à ajouter");
        addTown = sc.next();
        System.out.println("Indiquez le login de l'utilisateur à ajouter");
        addLogin = sc.next();
        System.out.println("Indiquez le mot de passe de l'utilisateur à ajouter");
        addPassword = sc.next();

        if (typeUser.equals("admin")) {
            User newUser = new Admin(addFirstname, addName, addTown, addLogin, addPassword);
            System.out.println("Nouvel utilisateur ajouté : " + userManagement.addUser(newUser));
        } else if (typeUser.equals("client")) {
            User newUser = new Client(addFirstname, addName, addTown, addLogin, addPassword);
            System.out.println("Nouvel utilisateur ajouté : " + userManagement.addUser(newUser));
        } else if (typeUser.equals("commercial")) {
            User newUser = new Commercial(addFirstname, addName, addTown, addLogin, addPassword);
            System.out.println("Nouvel utilisateur ajouté : " + userManagement.addUser(newUser));
        }
    }


    public void modifyUser(Scanner sc, UserManagement userManagement){
        String whichUserToModify;
        userManagement.getUserList();
        System.out.println("Indiquez le login de l'utilisateur à supprimer : ");
        whichUserToModify = sc.next();
        User chosenUser = userManagement.getOneUser(whichUserToModify);
        System.out.println("Utilisateur à modifier : "+chosenUser+"\n");

        System.out.println("Indiquez le nouveau prénom :");
        String replacementFirstname = sc.next();
        chosenUser.setFirstname(replacementFirstname);

        System.out.println("Indiquez le nouveau nom : ");
        String replacementName = sc.next();
        chosenUser.setName(replacementName);

        System.out.println("Indiquez la nouvelle ville : ");
        String replacementTown = sc.next();
        chosenUser.setTown(replacementTown);

        System.out.println("Indiquez le nouveau login : ");
        String replacementLogin = sc.next();
        chosenUser.setLogin(replacementLogin);

        System.out.println("Indiquez le nouveau mot de passe : ");
        String replacementPassword = sc.next();
        chosenUser.setPassword(replacementPassword);

        System.out.println("Le profil a bien été mis à jour : "+chosenUser);
    }

    public void deleteUser(Scanner sc, UserManagement userManagement){
        String userLoginToDelete;
        userManagement.getUserList();
        System.out.println("Indiquez le login de l'utilisateur que vous souhaitez supprimer :");
        userLoginToDelete = sc.next();
        userManagement.getOneUser(userLoginToDelete);
        userManagement.deleteUser(userLoginToDelete);
        System.out.println("Cet utilisateur a bien été supprimé!");
    }



}
