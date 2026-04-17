package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// 
public class GestorBiblioteca {

    // 
    private List<Prestec> prestecs;

    // CONSTRUCTORS
        // Constructor per defecte
    public GestorBiblioteca() {
        this.prestecs = new ArrayList<>();
    }

    // Mètodes de la classe
        // Funció que presta un llibre a un usuari
    public void prestarLlibre(Usuari usuari, Llibre llibre) {
        if (!llibre.esPrestat()) {  // Si el llibre no està prestat, el prestem
            llibre.prestar();   // Marquem el llibre com prestat
            Prestec prestec = new Prestec(usuari, llibre, LocalDate.now()); // Creem un nou préstec
            prestecs.add(prestec);  // Afegim el préstec a la llista de préstecs
            usuari.afegirLlibre(llibre);    // Afegim el llibre a la llista de llibres prestats de l'usuari
            System.out.println(usuari.getNom() + " ha agafat el llibre: " + llibre.getTitol()); // Imprimim un missatge confirmant el préstec
        } else {
            System.out.println("Aquest llibre ja està prestat.");   // Si el llibre ja està prestat, mostrem un missatge d'error
        }
    }
}