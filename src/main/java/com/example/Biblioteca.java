package com.example;

import java.util.ArrayList;
import java.util.List; 

// Classe pública que representa una Biblioteca
public class Biblioteca { 
    // Propietats de Biblioteca
        // Llista (Array) de llibres
    private List<Llibre> llibres;

    // CONSTRUCTORS
        // Crea una Biblioteca inicialitzant la llista de llibres buida
    public Biblioteca() { 
        this.llibres = new ArrayList<>(); 
    }

    // Mètodes de la classe
        // Mètode que afegeix un llibre a la llista
    public void afegirLlibre(Llibre llibre) { llibres.add(llibre); } 
    
        /*  Mètode que, donat un títol, busca dins de la llista.
            si existeix, el retorna, si no existeix, retorna null*/
    public Llibre buscarLlibre(String titol) { 
        // Recorrem la llista de llibres
        for (Llibre llibre : llibres) { 
            if (llibre.getTitol().equalsIgnoreCase(titol)) { // Si el títol coincideix
                return llibre; // Retorna el llibre
            } 
        } 
        
        return null; // Si no coincideix retorna null
    } 

    // GETTER
        // Get que retorna la llista de llibres
    public List<Llibre> getLlibres() { return llibres; } 
}

