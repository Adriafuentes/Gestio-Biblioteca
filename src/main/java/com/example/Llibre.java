package com.example;

// Classe pública que representa un llibre
public class Llibre {

    // Propietas de la classe Llibre
    private String titol; 
    private String autor; 
    private boolean prestat; 
    private String categoria;
    private int stock;

    // CONSTRUCTORS
        // Constructor amb paràmetres
    public Llibre(String titol, String autor, String categoria, int stock) { 
        this.titol = titol; 
        this.autor = autor; 
        this.categoria = categoria;
        this.stock = stock;
        this.prestat = false; // Per defecte prestat és false
    } 
    
    // GETTERS i SETTERS: 
        // Títol
    public String getTitol() { return titol; } 
    public void setTitol(String titol) { this.titol = titol; }

        // Autor
    public String getAutor() { return autor; } 
    public void setAutor(String autor) { this.autor = autor; }

        // Categoria
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

        // Prestat (utilitza "esPrestat" ja que és un boolean)
    public boolean esPrestat() { return prestat; } 

        // stock
    public int getStock() { return stock; }


    // Mètodes de la classe
        // Funció que presta un llibre
    public void prestar() { prestat = true; } 
    
        // Funció que retorna un llibre
    public void retornar() { prestat = false; } 

        // Mètode que retorna si un llibre té disponibilitat
    public boolean estaDisponible() { return stock>0; }

        // Funció que redueix l'stock
    public void reduirStock() {
        if(stock > 0) { stock--; }
    }

        // Funció que augmenta l'stock
    public void augmentarStock() {
        stock++;
    }
    
    // SOBREESCRIPTS
        // toString
    @Override 
        public String toString() { 
        
        // Retornem el títol, l'autor i si el llibre es prestat
        return titol + " de " + autor +  " | Categoria: " + categoria + " | " + (estaDisponible() ? " (Disponible)" : " (En préstec)"); 
    } 
}

