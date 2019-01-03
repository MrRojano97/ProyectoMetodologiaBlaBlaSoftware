/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Juan Andres
 */

//
public class Cuenta {
    
    public String id;
    public String password;
    public boolean permisos_de_admin;

    public Cuenta(String id, String password, boolean permisos_de_admin) {
        this.id = id;
        this.password = password;
        this.permisos_de_admin = permisos_de_admin;
    }

    public Cuenta() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public boolean verificarClave(String a){
        if(a.equals(this.password))
            return true;
        else
            return false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPermisos_de_admin() {
        return permisos_de_admin;
    }

    public void setPermisos_de_admin(boolean permisos_de_admin) {
        this.permisos_de_admin = permisos_de_admin;
    }
    
    
}
