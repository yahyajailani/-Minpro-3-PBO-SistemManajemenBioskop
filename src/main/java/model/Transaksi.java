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
public class Transaksi
        implements Pembayaran {

    private String idTransaksi;
    private Penonton penonton;
    private Tiket tiket;
    private double totalBayar;
    private double diskon;

    private static final ArrayList<Transaksi> daftarTransaksi =
            new ArrayList<>();

    public Transaksi(
            String idTransaksi,
            Penonton penonton,
            Tiket tiket) {

        this.idTransaksi = idTransaksi;
        this.penonton = penonton;
        this.tiket = tiket;

        this.diskon =
                penonton.hitungDiskon(
                        tiket.getTotalHarga()
                );

        this.totalBayar =
                hitungTotal();
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Penonton getPenonton() {
        return penonton;
    }

    public Tiket getTiket() {
        return tiket;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public double getDiskon() {
        return diskon;
    }

    @Override
    public double hitungTotal() {

        return tiket.getTotalHarga()
                - diskon;
    }

    @Override
    public void tampilkanPembayaran() {

        System.out.println(
                "\n========== PEMBAYARAN =========="
        );

        System.out.println(
                "ID Transaksi : "
                + idTransaksi
        );

        System.out.println(
                "Penonton     : "
                + penonton.getNama()
        );

        System.out.println(
                "Film         : "
                + tiket.getFilm().getJudul()
        );

        System.out.println(
                "Studio       : "
                + tiket.getStudio().getNama()
        );

        System.out.println(
                "Harga Awal   : Rp"
                + tiket.getTotalHarga()
        );

        System.out.println(
                "Diskon       : Rp"
                + diskon
        );

        System.out.println(
                "Total Bayar  : Rp"
                + totalBayar
        );
    }

    public static ArrayList<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }

    public static void tambah(
            Transaksi transaksi) {

        daftarTransaksi.add(transaksi);
    }

    @Override
    public String toString() {

        return "ID Transaksi : "
                + idTransaksi
                + "\nPenonton     : "
                + penonton.getNama()
                + "\nFilm         : "
                + tiket.getFilm().getJudul()
                + "\nStudio       : "
                + tiket.getStudio().getNama()
                + "\nHarga Awal   : Rp"
                + tiket.getTotalHarga()
                + "\nDiskon       : Rp"
                + diskon
                + "\nTotal Bayar  : Rp"
                + totalBayar;
    }
}