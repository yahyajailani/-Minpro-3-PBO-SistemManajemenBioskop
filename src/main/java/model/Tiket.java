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
public class Tiket {

    private Penonton penonton;
    private Film film;
    private Studio studio;
    private int jumlah;

    private static final int TAMBAHAN_VIP = 10000;

    private static final ArrayList<Tiket> daftarTiket =
            new ArrayList<>();

    public Tiket(
            Penonton penonton,
            Film film,
            Studio studio,
            int jumlah) {

        this.penonton = penonton;
        this.film = film;
        this.studio = studio;
        this.jumlah = jumlah;
    }

    public Penonton getPenonton() {
        return penonton;
    }

    public void setPenonton(Penonton penonton) {
        this.penonton = penonton;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHargaPerTiket() {

        double harga = film.getHarga();

        if (studio.getTipe()
                .equalsIgnoreCase("VIP")) {

            harga += TAMBAHAN_VIP;
        }

        return harga;
    }

    public double getTotalHarga() {

        return getHargaPerTiket() * jumlah;
    }

    public static ArrayList<Tiket> getDaftarTiket() {
        return daftarTiket;
    }

    public static void tambah(Tiket tiket) {
        daftarTiket.add(tiket);
    }

    public static void update(
            int index,
            Tiket tiket) {

        daftarTiket.set(index, tiket);
    }

    public static void hapus(int index) {
        daftarTiket.remove(index);
    }

    @Override
    public String toString() {

        return "Penonton     : "
                + penonton.getNama()
                + "\nFilm         : "
                + film.getJudul()
                + "\nStudio       : "
                + studio.getNama()
                + "\nTipe Studio  : "
                + studio.getTipe()
                + "\nHarga/Tiket  : Rp"
                + getHargaPerTiket()
                + "\nJumlah       : "
                + jumlah
                + "\nTotal        : Rp"
                + getTotalHarga();
    }
}