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
public class Studio {

    private String nama;
    private int kapasitas;
    private String tipe;

    private static final ArrayList<Studio> daftarStudio =
            new ArrayList<>();

    public Studio(
            String nama,
            int kapasitas,
            String tipe) {

        this.nama = nama;
        this.kapasitas = kapasitas;
        this.tipe = tipe;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public static ArrayList<Studio> getDaftarStudio() {
        return daftarStudio;
    }

    public static void tambah(Studio studio) {
        daftarStudio.add(studio);
    }

    public static void update(
            int index,
            Studio studio) {

        daftarStudio.set(index, studio);
    }

    public static void hapus(int index) {
        daftarStudio.remove(index);
    }

    @Override
    public String toString() {

        return "Nama Studio : " + nama
                + "\nKapasitas   : " + kapasitas
                + " kursi"
                + "\nTipe        : " + tipe;
    }
}