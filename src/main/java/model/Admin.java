/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADVAN
 */
public class Admin extends Pengguna {

    private String password;

    private final String EMAIL_PERUSAHAAN =
            "cinematter@gmail.com";

    public Admin(
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
        return "Admin";
    }

    @Override
    public void tampilkanMenu() {

        System.out.println("\n========== MENU ADMIN ==========");
        System.out.println("1. Data Film");
        System.out.println("2. Data Studio");
        System.out.println("3. Data Tiket");
        System.out.println("4. Data Penonton");
        System.out.println("5. Riwayat Transaksi");
        System.out.println("0. Logout");
    }

    public boolean login(
            String email,
            String password) {

        return EMAIL_PERUSAHAAN.equalsIgnoreCase(email)
                && this.password.equals(password);
    }
}