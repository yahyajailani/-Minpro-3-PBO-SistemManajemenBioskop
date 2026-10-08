/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADVAN
 */
public class Penonton extends Pengguna {

    private String password;

    public Penonton(
            String nama,
            String email,
            String noHP,
            String password) {

        super(nama, email, noHP);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRole() {
        return "Penonton";
    }

    @Override
    public void tampilkanMenu() {

        System.out.println("\n========= MENU PENONTON =========");
        System.out.println("1. Lihat Profil");
        System.out.println("2. Lihat Film");
        System.out.println("3. Lihat Studio");
        System.out.println("4. Beli Tiket");
        System.out.println("5. Riwayat Transaksi");
        System.out.println("0. Logout");
    }

    public boolean login(
            String email,
            String password) {

        return getEmail().equalsIgnoreCase(email)
                && this.password.equals(password);
    }

    // OVERLOADING 1
    public double hitungDiskon(double harga) {

        if (harga >= 100000) {
            return harga * 0.10;
        }

        if (harga >= 50000) {
            return harga * 0.05;
        }

        return 0;
    }

    // OVERLOADING 2
    public double hitungDiskon(
            double harga,
            int jumlahTiket) {

        double total = harga * jumlahTiket;

        if (jumlahTiket >= 4) {
            return total * 0.15;
        }

        return hitungDiskon(total);
    }

    public double hitungHargaAkhir(
            double totalHarga) {

        double diskon =
                hitungDiskon(totalHarga);

        return totalHarga - diskon;
    }

    public double hitungHargaAkhir(
            double harga,
            int jumlahTiket) {

        double total =
                harga * jumlahTiket;

        double diskon =
                hitungDiskon(
                        harga,
                        jumlahTiket
                );

        return total - diskon;
    }
}