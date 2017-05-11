package com.example.tomas.material;


public class Jugador {

    private String foto ;
    private String nombre;
    private int idjugador;
    private String equipo;

    public Jugador ()
    {

    }


    public Jugador(String foto, String nombre,String equipo) {
        this.foto = foto;
        this.nombre = nombre;
        this.equipo = equipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(int idjugador) {
        this.idjugador = idjugador;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
}
