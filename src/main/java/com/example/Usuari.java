package com.example;

import java.util.ArrayList;
import java.util.List;

// Classe pública que representa un usuari
public class Usuari {
    
    // Propietats de la classe Usuari
    private String nom;
    private List<Llibre> llibresPrestats;

    // CONSTRUCTORS
        // Constructor amb paràmetres
    public Usuari(String nom) {
        this.nom = nom;
        this.llibresPrestats = new ArrayList<>();
    }

    // GETTERS
        // Nom
    public String getNom() { return nom; }

        // Llibres prestats
    public List<Llibre> getLlibresPrestats() { return llibresPrestats; }

    // Mètodes de la classe
        // Funció que afegeix un llibre a la llista de llibres prestats
    public void afegirLlibre(Llibre llibre) { llibresPrestats.add(llibre); }

        // Funció que retorna un llibre (elimina el llibre de la llista de llibres prestats)
    public void retornarLlibre(Llibre llibre) { llibresPrestats.remove(llibre); }
}