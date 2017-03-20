/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros;

/**
 *
 * @author Adri
 */
public class Libro implements Comparable<Libro> {

    private String title, author, isbn;
    private double value;
    private int uds;

    public Libro() {
        uds++;
    }

    public Libro(String title, String author, String isbn, double precio, int uds) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.value = precio;
        this.uds = uds;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrecio() {
        return value;
    }

    public int getUds() {
        return uds;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setUds(int uds) {
        this.uds = uds;
    }

    @Override
    public int compareTo(Libro o) {
        String a = String.valueOf(this.getTitle());
        String b = String.valueOf(o.getTitle());
        return a.compareTo(b);
    }

}
