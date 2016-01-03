package com.micles;

import java.io.Serializable;

/**
 * Created by Bolesław on 2015-12-28.
 */
public class User implements Serializable {
    private String name;
    private String email;
    private Integer pesel;
    private int id;
    public static final String USERID= "U";

    public User(String name, String email, Integer pesel) {
        this.name = name;
        this.email = email;
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (pesel != user.pesel) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + pesel;
        return result;
    }

    @Override
    public String toString() {
        String result;
        result = USERID + "," + name + "," + email + "," + pesel;
        return result;
    }
}
