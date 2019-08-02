/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author brayangarcia
 */
public class Continente {
    private long idContinente;
    private String nombre;
    private ArrayList<Pais> paises;


    public Continente(){
        paises = new ArrayList<>();
    }
    /**
     * 
     * @param idContinente id delcontinente
     * @param nombre nombre del continente, este no es único
     */
    public Continente(long idContinente, String nombre) {
        this.idContinente = idContinente;
        this.nombre = nombre;
                paises = new ArrayList<>();

    }
    public long getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(long idContinente) {
        this.idContinente = idContinente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPais(long idPais, String nombre){
        Pais myPais = new Pais(idPais, nombre);
        paises.add(myPais);
    }
    public void setCiudad(long idPais,long idCiudad, String nombre){
        for (int i = 0; i < paises.size(); i++) {
            if(paises.get(i).getIdPais()==idPais){
                paises.get(i).setCiudad(idCiudad, nombre);
            }
        }
    }
    

  
}
