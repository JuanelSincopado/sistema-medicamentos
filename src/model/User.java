package model;

public class User {

    private int user_id;
    private String user;
    private String first_name;
    private String last_name;
    private String pass;
    private int rol;

    public User(int user_id, String user, String first_name, String last_name, String pass, int rol) {
        this.user_id = user_id;
        this.user = user;
        this.first_name = first_name;
        this.last_name = last_name;
        this.pass = pass;
        this.rol = rol;
    }

    public int getUserId() {
        return this.user_id;
    }

    public void setUserId(int id) {
        this.user_id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return this.last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRol() {
        return this.rol;
    }

    public void setRol(int id) {
        this.rol = id;
    }

}