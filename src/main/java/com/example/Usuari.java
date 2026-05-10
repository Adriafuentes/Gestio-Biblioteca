package com.example;

import java.util.ArrayList;
import java.util.List;

// Classe pública que representa un usuari
public class Usuari {
    
    // Propietats de la classe Usuari
    private String nom;
    private List<Llibre> llibresPrestats;
    private List<Prestec> historialPrestecs;

    // CONSTRUCTORS
        // Constructor amb paràmetres
    public Usuari(String nom) {
        this.nom = nom;
        this.llibresPrestats = new ArrayList<>();

        this.historialPrestecs = new ArrayList<>();
    }

    // GETTERS i SETTERS
        // Nom
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

        // Llibres prestats
    public List<Llibre> getLlibresPrestats() { return llibresPrestats; }

        // Historial Prestecs
    public List<Prestec> getHistorialPrestecs() { return historialPrestecs; }

    // Mètodes de la classe
        // Funció que afegeix un llibre a la llista de llibres prestats
    public void afegirLlibre(Llibre llibre) { llibresPrestats.add(llibre); }

        // Funció que retorna un llibre (elimina el llibre de la llista de llibres prestats)
    public void retornarLlibre(Llibre llibre) { llibresPrestats.remove(llibre); }

    // Mètodes dels usuaris
        // Afegir un prèstec
    public void afegirPrestec(Prestec prestec) { historialPrestecs.add(prestec); }

    // Sobreescripts
        //toString
    @Override
    public String toString() {
        return "Nom: " + nom + " | Llibres prestats: " + llibresPrestats + " | Historial préstecs: " + historialPrestecs;
    }
}