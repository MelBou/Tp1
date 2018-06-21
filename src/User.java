public class User {

    private String firstname;
    private String name;
    private String town;
    private String login;
    private String password;

    public String getFirstname(){

        return firstname;
    }

    public void setFirstname(String firstname){

        this.firstname=firstname;
    }

    public String getName(){

        return name;
    }

    public void setName(String name){

        this.name=name;
    }

    public String getTown(){

        return town;
    }

    public void setTown(String town){

        this.town=town;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login=login;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void menu(){
        System.out.println("-------------------------------------------------");
        System.out.println("Maintenant, que voulez-vous faire?");
        System.out.println(" ");
        System.out.println("0 --- Quitter");
        System.out.println("1 --- Consulter vos infos personnelles");
        System.out.println("2 --- Modifier vos infos personnelles");
        System.out.println("3 --- Afficher les produits de notre catalogue");


    }

}