package com.example;

// Classe pública que representa un llibre
public class Llibre {

    // Propietas de la classe Llibre
    private String titol; 
    private String autor; 
    private boolean prestat; 
    
    // CONSTRUCTORS
        // Constructor amb paràmetres
    public Llibre(String titol, String autor) { 
        this.titol = titol; 
        this.autor = autor; 
        this.prestat = false; // Per defecte prestat és false
    } 
    
    // GETTERS: 
        // Títol
    public String getTitol() { return titol; } 

        // Autor
    public String getAutor() { return autor; } 
    
        // Prestat (utilitza "esPrestat" ja que és un boolean)
    public boolean esPrestat() { return prestat; } 
    
    // Mètodes de la classe
        // Funció que presta un llibre
    public void prestar() { prestat = true; } 
    
        // Funció que retorna un llibre
    public void retornar() { prestat = false; } 
    
    // SOBREESCRIPTS

        // toString
    @Override 
        public String toString() { 
        
        // Retornem el títol, l'autor i si el llibre es prestat
        return titol + " de " + autor + (prestat ? " (En préstec)" : " (Disponible)"); 
    } 
}

