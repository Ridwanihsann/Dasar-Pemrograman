package model;

public class akun {
    private String name;
    private String email;
    

    public akun setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public akun setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

}