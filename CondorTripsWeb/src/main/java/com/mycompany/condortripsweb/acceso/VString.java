package com.mycompany.condortripsweb.acceso;

/**
 *
 * @author danielmej
 */
public class VString {
    private String string;

    public VString() {
    }

    public VString(String value) {
        this.string = value;
    }
    
    public int getInt(){
        return Integer.parseInt(string);
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
    
    
    
    
    
}
