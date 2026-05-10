package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe que gestiona els préstecs de la biblioteca
public class GestorBiblioteca {

    // Atributs de la classe
    public static final int MAX_LLIBRES_PER_USUARI = 3; // Quantitat màxima de llibres prestats a un únic usuari
    private List<Prestec> prestecs; // Llistat de préstecs

    // CONSTRUCTORS
        // Constructor per defecte
    public GestorBiblioteca() {
        this.prestecs = new ArrayList<>();
    }

    // Mètodes de la classe
        // Funció que presta un llibre a un usuari
    public void prestarLlibre(Usuari usuari, Llibre llibre) {

        // Comprovem si l'usuari ha arribat al límit de llibres prestats
        if (usuari.getLlibresPrestats().size() >= MAX_LLIBRES_PER_USUARI) {
            System.out.println("Aquest usuari ha arribat al màxim de llibres permesos.");
            return;
        }

        // Comprovem si el llibre està disponible (stock)
        if (!llibre.estaDisponible()) {
            System.out.println("No hi ha stock disponible d'aquest llibre.");
            return;
        }

        // Reduïm l'stock del llibre
        llibre.reduirStock();

        // Creem el préstec amb la data actual
        Prestec prestec = new Prestec(usuari, llibre, LocalDate.now());

        // Afegim el préstec a la llista general
        prestecs.add(prestec);

        // Afegim el llibre a la llista de llibres de l'usuari
        usuari.afegirLlibre(llibre);

        // Afegim el préstec a l'historial de l'usuari
        usuari.afegirPrestec(prestec);

        // Missatge de confirmació
        System.out.println(usuari.getNom() + " ha agafat el llibre: " + llibre.getTitol());
    }

        // Funció que mostra les estadístiques de la biblioteca
    public void estadistiques() {

        System.out.println("Estadístiques de la biblioteca");

        // Total de préstecs realitzats
        System.out.println("Total de préstecs: " + prestecs.size());

        // LECTOR MÉS ACTIU
        Map<Usuari, Integer> mapUsuaris = new HashMap<>();

        for (Prestec p : prestecs) {
            mapUsuaris.put(
                    p.getUsuari(),
                    mapUsuaris.getOrDefault(p.getUsuari(), 0) + 1
            );
        }

        Usuari lectorMesActiu = null;
        int max = 0;

        for (var entry : mapUsuaris.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                lectorMesActiu = entry.getKey();
            }
        }

        if (lectorMesActiu != null) {
            System.out.println("Lector més actiu: " +
                    lectorMesActiu.getNom() +
                    " (" + max + " préstecs)");
        }

        // LLIBRES MÉS PRESTATS
        Map<Llibre, Integer> mapLlibres = new HashMap<>();

        for (Prestec p : prestecs) {
            mapLlibres.put(
                    p.getLlibre(),
                    mapLlibres.getOrDefault(p.getLlibre(), 0) + 1
            );
        }

        System.out.println("Llibres més prestats:");

        for (var entry : mapLlibres.entrySet()) {
            System.out.println(
                    entry.getKey().getTitol() +
                    " -> " +
                    entry.getValue() +
                    " préstecs"
            );
        }

        // PRÉSTECS PER CATEGORIA
        Map<String, Integer> mapCategories = new HashMap<>();

        for (Prestec p : prestecs) {

            String categoria = p.getLlibre().getCategoria();

            mapCategories.put(
                    categoria,
                    mapCategories.getOrDefault(categoria, 0) + 1
            );
        }

        System.out.println("Préstecs per categoria:");

        for (var entry : mapCategories.entrySet()) {
            System.out.println(
                    entry.getKey() +
                    ": " +
                    entry.getValue()
            );
        }
    }
}