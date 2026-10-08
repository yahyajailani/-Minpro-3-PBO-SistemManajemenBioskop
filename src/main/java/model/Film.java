/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ADVAN
 */
public class Film {

    private String judul;
    private String genre;
    private int durasi;
    private double harga;

    private static final ArrayList<Film> daftarFilm =
            new ArrayList<>();

    public Film(
            String judul,
            String genre,
            int durasi,
            double harga) {

        this.judul = judul;
        this.genre = genre;
        this.durasi = durasi;
        this.harga = harga;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public static ArrayList<Film> getDaftarFilm() {
        return daftarFilm;
    }

    public static void tambah(Film film) {
        daftarFilm.add(film);
    }

    public static void update(
            int index,
            Film film) {

        daftarFilm.set(index, film);
    }

    public static void hapus(int index) {
        daftarFilm.remove(index);
    }

    @Override
    public String toString() {

        return "Judul  : " + judul
                + "\nGenre  : " + genre
                + "\nDurasi : " + durasi + " menit"
                + "\nHarga  : Rp" + harga;
    }
}