package com.example;

import java.util.Scanner;

// Programa principal
public class Main {

    // Funció per pausar el programa
    public static void pausa(Scanner sc) {
        System.out.println("\nPrem qualsevol tecla per continuar...");
        sc.nextLine();
    }

    public static void main(String[] args) {

        // Scanner per llegir per teclat
        Scanner sc = new Scanner(System.in);

        // Creem la biblioteca i el gestor
        Biblioteca biblioteca = new Biblioteca();
        GestorBiblioteca gestor = new GestorBiblioteca();

        // Dades inicials de prova
            // Afegim 2 llibres
        biblioteca.afegirLlibre(new Llibre("1984", "George Orwell", "Novel·la", 1));
        biblioteca.afegirLlibre(new Llibre("El petit príncep", "Antoine de Saint-Exupéry", "Filosofia", 2));

            // Afegim 2 usuaris        
        biblioteca.afegirUsuari(new Usuari("Carla"));
        biblioteca.afegirUsuari(new Usuari("Joan"));

        int opcio; // Variable per tractar l'opció escollida per l'usuari al menú

        // Menú principal
        do {
            // Mostrem totes les opcions
            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1. Llistar llibres");
            System.out.println("2. Buscar llibre");
            System.out.println("3. Afegir llibre");
            System.out.println("4. Eliminar llibre");

            System.out.println("5. Llistar usuaris");
            System.out.println("6. Buscar usuari");
            System.out.println("7. Afegir usuari");
            System.out.println("8. Eliminar usuari");

            System.out.println("9. Prestar llibre");
            System.out.println("10. Estadístiques");
            System.out.println("0. Sortir");

            System.out.print("Opció: "); // Demanem opció
            opcio = sc.nextInt();
            sc.nextLine();


            System.out.println();
            System.out.println();

            // Switch que tractarà l'opció de l'usuari
            switch (opcio) {

                // LLISTAR LLIBRES
                case 1:
                    biblioteca.llistarLlibres();
                    pausa(sc);
                    break;

                // BUSCAR LLIBRE
                case 2:
                    System.out.print("Introdueix títol: ");
                    String titol = sc.nextLine();

                    Llibre llibre = biblioteca.buscarLlibre(titol);

                    if (llibre != null) {
                        System.out.println(llibre);
                    } else {
                        System.out.println("Llibre no trobat");
                    }
                    pausa(sc);
                    break;

                // AFEGIR LLIBRE
                case 3:
                    System.out.print("Títol: ");
                    String t = sc.nextLine();

                    System.out.print("Autor: ");
                    String a = sc.nextLine();

                    System.out.print("Categoria: ");
                    String c = sc.nextLine();

                    System.out.print("Stock: ");
                    int s = sc.nextInt();
                    sc.nextLine();

                    biblioteca.afegirLlibre(new Llibre(t, a, c, s));
                    System.out.println("Llibre afegit");
                    pausa(sc);
                    break;

                // ELIMINAR LLIBRE
                case 4:
                    System.out.print("Títol del llibre a eliminar: ");
                    String titolDel = sc.nextLine();

                    Llibre lDel = biblioteca.buscarLlibre(titolDel);

                    if (lDel != null) {
                        biblioteca.eliminarLlibre(lDel);
                        System.out.println("Llibre eliminat");
                    } else {
                        System.out.println("No existeix el llibre");
                    }
                    pausa(sc);
                    break;

                // LLISTAR USUARIS
                case 5:
                    biblioteca.llistarUsuaris();
                    pausa(sc);
                    break;

                // BUSCAR USUARI
                case 6:
                    System.out.print("Nom usuari: ");
                    String nom = sc.nextLine();

                    Usuari u = biblioteca.buscarUsuari(nom);

                    if (u != null) {
                        System.out.println(u);
                    } else {
                        System.out.println("Usuari no trobat");
                    }
                    pausa(sc);
                    break;

                // AFEGIR USUARI
                case 7:
                    System.out.print("Nom usuari: ");
                    String nouNom = sc.nextLine();

                    biblioteca.afegirUsuari(new Usuari(nouNom));
                    System.out.println("Usuari afegit");
                    pausa(sc);
                    break;

                // ELIMINAR USUARI
                case 8:
                    System.out.print("Nom usuari: ");
                    String nomDel = sc.nextLine();

                    Usuari uDel = biblioteca.buscarUsuari(nomDel);

                    if (uDel != null) {
                        biblioteca.eliminarUsuari(uDel);
                        System.out.println("Usuari eliminat");
                    } else {
                        System.out.println("Usuari no trobat");
                    }
                    pausa(sc);
                    break;

                // PRESTAR LLIBRE
                case 9:
                    System.out.print("Nom usuari: ");
                    String nomUsuari = sc.nextLine();

                    System.out.print("Títol llibre: ");
                    String titolLlibre = sc.nextLine();

                    Usuari usuari = biblioteca.buscarUsuari(nomUsuari);
                    Llibre llibrePrestec = biblioteca.buscarLlibre(titolLlibre);

                    if (usuari != null && llibrePrestec != null) {
                        gestor.prestarLlibre(usuari, llibrePrestec);
                    } else {
                        System.out.println("Usuari o llibre no trobat");
                    }
                    pausa(sc);
                    break;

                // ESTADÍSTIQUES
                case 10:
                    gestor.estadistiques();
                    pausa(sc);
                    break;

                case 0:
                    System.out.println("Sortint del sistema...");
                    break;

                default:
                    System.out.println("Opció no vàlida");
                    pausa(sc);
            }

        } while (opcio != 0);

        sc.close();
    }
}