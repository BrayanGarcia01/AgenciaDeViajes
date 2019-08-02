package main;

import servicio.ServidorCentralServer;

public class Run {
    public static void main(String[] args){
        ServidorCentralServer scs = new ServidorCentralServer();
        scs.iniciar();
    }
    
}
