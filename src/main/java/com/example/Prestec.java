package com.example;

import java.time.LocalDate;

// Classe pública que representa un préstec
public class Prestec {

    // Propietats de la classe Prestec
    private Usuari usuari;
    private Llibre llibre;
    private LocalDate dataPrestec;
    private LocalDate dataRetorn;

    // CONSTRUCTORS
        // Constructor amb paràmetres
    public Prestec(Usuari usuari, Llibre llibre, LocalDate dataPrestec) {
        this.usuari = usuari;
        this.llibre = llibre;
        this.dataPrestec = dataPrestec;
        this.dataRetorn = dataPrestec.plusWeeks(2);
    }
    // GETTERS
        // Usuari
    public Usuari getUsuari() { return usuari; }

        // Llibre
    public Llibre getLlibre() { return llibre; }

        // Data de retorn
    public LocalDate getDataRetorn() { return dataRetorn; }
}