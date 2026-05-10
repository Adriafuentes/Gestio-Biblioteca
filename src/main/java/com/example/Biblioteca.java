package com.example;

import java.util.ArrayList;
import java.util.List; 
import java.text.Normalizer;
import java.util.regex.Pattern;

// Classe pública que representa una Biblioteca
public class Biblioteca { 
    // Propietats de Biblioteca
        // Llista (Array) de llibres
    private List<Llibre> llibres;
    private List<Usuari> usuaris;

    // CONSTRUCTORS
        // Crea una Biblioteca inicialitzant la llista de llibres i usuaris buides
    public Biblioteca() { 
        llibres = new ArrayList<>(); 
        usuaris = new ArrayList<>();
    }

    // GETTER
        // Get que retorna la llista de llibres
    public List<Llibre> getLlibres() { return llibres; }
    public List<Usuari> getUsuaris() { return usuaris; } 

        

    // Mètodes de la classe
        // Mètode que afegeix un llibre a la llista
    public void afegirLlibre(Llibre llibre) { llibres.add(llibre); } 
    
        // Mètode que busca un llibre a la llista
    public Llibre buscarLlibre(String titol) { 

        String titolNormalitzatBuscar = eliminarAccents(titol);

        // Recorrem la llista de llibres
        for (Llibre llibre : llibres) { 

            String titolNormalitzat = eliminarAccents(llibre.getTitol());

            if (titolNormalitzat.equalsIgnoreCase(titolNormalitzatBuscar)) { // Si el títol coincideix
                return llibre; // Retorna el llibre
            } 
        } 
        
        return null; // Si no coincideix retorna null
    } 

        // Mètode que elimina un llibre
    public void eliminarLlibre(Llibre llibre) { llibres.remove(llibre); }


        // Mètode que llista tots els llibres
    public void llistarLlibres() {
        if(llibres.isEmpty()) {
            System.out.println("No hi ha llibres");
            return;
        }

        for(Llibre llibre : llibres) {
            System.out.println("\t" + llibre);
        }
    }


        // Afegir Usuari
    public void afegirUsuari(Usuari usuari) { usuaris.add(usuari); }

        // Buscar Usuari
    public Usuari buscarUsuari(String nom) {
        for(Usuari usuari : usuaris) {
            if(usuari.getNom().equalsIgnoreCase(nom)) {
                return usuari;
            }
        }

        return null;
    }

        // Eliminar usuari
    public void eliminarUsuari(Usuari usuari) { usuaris.remove(usuari); }

        // Llistar usuaris
    public void llistarUsuaris() {
        if(usuaris.isEmpty()) {
            System.out.println("No hi ha usuaris");
            return;
        }

        for(Usuari usuari : usuaris) {
            System.out.println("\t" + usuari);
        }
    }

    // Mètodes privats
        // Mètode que normalitza el text
    public String eliminarAccents(String text) {
        if(text == null) return null;

        // Trenquem el text separant vocals d'accents
        String normalitzat = Normalizer.normalize(text, Normalizer.Form.NFD);

        // Creem un patró que elimina accents 
        Pattern patro = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

        // Retornem el text cridant al patró per eliminar accents
        return patro.matcher(normalitzat).replaceAll("");
    }
}

