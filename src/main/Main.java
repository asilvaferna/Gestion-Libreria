/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import libros.Libro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;
import libreriaprueba.Operaciones;

/**
 *
 * @author Adri
 */
public class Main {


    public static void addBook(Libro l, ArrayList<Libro> aLibro) {
        aLibro.add(l);
    }

    public static void sellBook(Libro l, ArrayList<Libro> aLibro) {
        int index = aLibro.indexOf(l);
        aLibro.remove(index-1);
    }


    public static void mostrarLibro(ArrayList<Libro> bd) {
        for (Libro elemento : bd) {
            JOptionPane.showMessageDialog(null, "Author: " + elemento.getAuthor() + ", title: " + elemento.getTitle() + ", ISBN: " + elemento.getIsbn());
        }

    }

    public static void ordenaLibros(ArrayList<Libro> bd) {
        Collections.sort(bd);
        Main.mostrarLibro(bd);
    }

    public static void deleteEmpty(Libro l, ArrayList<Libro> bd) {
        Iterator itBd = bd.iterator();
        int index = 0;
        while (itBd.hasNext()) {
            l = (Libro) itBd.next();
            if (l.getUds() == 0) {
                index = bd.indexOf(l);
                bd.remove(index-1);
            }
        }
    }
    
    public static void mostrarLibroPosicion(ArrayList<Libro> bd, int posicion){
        for (Libro elemento : bd) {
            if (bd.indexOf(elemento)==posicion){
                JOptionPane.showMessageDialog(null, "Author: " + elemento.getAuthor() + ", title: " + elemento.getTitle() + ", ISBN: " + elemento.getIsbn());
            }
        }
    }
    
    public static void addLibroFichero(ArrayList<Libro> libreria) {
        PrintWriter add = null;
        FileWriter fichero = null;
        try {
            add = new PrintWriter(new FileWriter("libreria.txt", true));
            for (Libro libro: libreria){
                add.println(libro.getAuthor() + ", " + libro.getIsbn() + ", " + libro.getTitle() + ", " + libro.getPrecio() + ", " + libro.getUds());
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            add.close();
        }
        
    }
    
    public static void consultarLibroFichero(String tituloLibro) {
        FileWriter fichero = null;
        try {
            Scanner sc = new Scanner(new File("libreria.txt"));
            while(sc.hasNextLine()){
                if (sc.nextLine().equals(tituloLibro))
                    JOptionPane.showMessageDialog(null, sc.nextLine());
                else {
                    JOptionPane.showMessageDialog(null, "Libro no encontrado");
                }
            }
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Libro> libreria = new ArrayList<>();
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("MENU:\n 1. Añadir libro\n 2. Vender libro\n 3. Mostrar libros ordenados\n 4. Borar libros sin unidades\n 5. Consultar libro\n 6. Salir"));
        Operaciones.validarInt(num1);
       Libro l1 = null;
        while (num1 > 0 && num1 < 6) {
            switch (num1) {
                case 1: //Añadir libro
                    l1 = new Libro();
                    String title = JOptionPane.showInputDialog("Title: ");
                    String author = JOptionPane.showInputDialog("Author: ");
                    String isbn = JOptionPane.showInputDialog("ISBN: ");
                    double value = Long.parseLong(JOptionPane.showInputDialog("Value: "));
                    l1.setAuthor(author);
                    l1.setIsbn(isbn);
                    l1.setValue(value);
                    l1.setTitle(title);
                    Main.addBook(l1, libreria);
                    Main.addLibroFichero(libreria);
                    break;
                case 2: //Vender libro
                    Main.sellBook(l1, libreria);
                    JOptionPane.showMessageDialog(null, "Libro vendido");
                    break;
                case 3: //Mostrar libros ordenados
                    Main.ordenaLibros(libreria);
                    JOptionPane.showMessageDialog(null, "Libros ordenados");
                    break;
                case 4: //Dar de baja libros sin uds
                    Main.deleteEmpty(l1, libreria);
                    JOptionPane.showMessageDialog(null, "Todos los libros sin unidades eliminados");
                    break;
                case 5: //Consultar libro
                    int index = Integer.parseInt(JOptionPane.showInputDialog("Nº de libro que quieres mostrar: "));
                    Main.mostrarLibroPosicion(libreria, index-1);
                    Main.consultarLibroFichero("");
                    break;
                case 6: // Visualizar fichero
                    break;
                case 7: // Modificar precio de un libro
                    break;
                case 8: // Buscar libros de un autor

            }
            num1 = Integer.parseInt(JOptionPane.showInputDialog("MENU:\n 1. Añadir libro\n 2. Vender libro\n 3. Mostrar libros ordenados\n 4. Borar libros sin unidades\n 5. Consultar libro\n 6. Salir"));
        }

    }

}
