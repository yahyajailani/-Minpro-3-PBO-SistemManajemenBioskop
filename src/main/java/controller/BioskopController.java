/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Admin;
import model.Film;
import model.Penonton;
import model.Studio;
import model.Tiket;
import model.Transaksi;
import view.BioskopView;

/**
 *
 * @author ADVAN
 */
public class BioskopController {

    private final BioskopView view;
    private final Admin admin;

    private final ArrayList<Penonton> daftarPenonton =
            new ArrayList<>();

    public BioskopController() {

        view = new BioskopView();

        admin = new Admin(
                "Cinematter",
                "cinematter@gmail.com",
                "081234567890",
                "Cinematter111"
        );

        isiDummyData();
    }

    private void isiDummyData() {

        if (Film.getDaftarFilm().isEmpty()) {

            Film.tambah(
                    new Film(
                            "Avengers: Endgame",
                            "Action",
                            181,
                            50000
                    )
            );

            Film.tambah(
                    new Film(
                            "Interstellar",
                            "Sci-Fi",
                            169,
                            45000
                    )
            );

            Film.tambah(
                    new Film(
                            "The Conjuring",
                            "Horror",
                            112,
                            45000
                    )
            );
        }

        if (Studio.getDaftarStudio().isEmpty()) {

            Studio.tambah(
                    new Studio(
                            "Studio 1",
                            100,
                            "Regular"
                    )
            );

            Studio.tambah(
                    new Studio(
                            "Studio 2",
                            80,
                            "VIP"
                    )
            );
        }
    }

    public void jalankan() {

        boolean jalan = true;

        view.header();

        while (jalan) {

            System.out.println(
                    "\n========== LOGIN =========="
            );

            System.out.println(
                    "1. Login Admin"
            );

            System.out.println(
                    "2. Login Penonton"
            );

            System.out.println(
                    "3. Daftar Penonton"
            );

            System.out.println(
                    "0. Keluar"
            );

            int pilihan =
                    view.bacaPilihan(
                            "Pilih menu: ",
                            0,
                            3
                    );

            switch (pilihan) {

                case 1:
                    loginAdmin();
                    break;

                case 2:
                    loginPenonton();
                    break;

                case 3:
                    daftarPenonton();
                    break;

                case 0:
                    jalan = false;

                    view.pesan(
                            "Program selesai. Terima kasih."
                    );

                    break;
            }
        }
    }

    private void loginAdmin() {

        System.out.println(
                "\n========== LOGIN ADMIN =========="
        );

        String email =
                view.bacaEmail("Email : ");

        String password =
                view.bacaString("Password : ");

        if (admin.login(email, password)) {

            view.pesan(
                    "Login admin berhasil."
            );

            menuAdmin();

        } else {

            view.pesan(
                    "Email atau password salah."
            );
        }
    }
    
    private void loginPenonton() {

        if (daftarPenonton.isEmpty()) {

            view.pesan(
                    "Belum ada akun penonton."
            );

            return;
        }

        System.out.println(
                "\n========== LOGIN PENONTON =========="
        );

        String email =
                view.bacaEmail("Email : ");

        String password =
                view.bacaString("Password : ");

        for (Penonton penonton :
                daftarPenonton) {

            if (penonton.login(
                    email,
                    password)) {

                view.pesan(
                        "Login berhasil."
                );

                menuPenonton(penonton);

                return;
            }
        }

        view.pesan(
                "Email atau password salah."
        );
    }

    private void daftarPenonton() {

        System.out.println(
                "\n========== DAFTAR PENONTON =========="
        );

        String nama =
                view.bacaNama("Nama : ");

        String email =
                view.bacaEmail("Email : ");

        for (Penonton p :
                daftarPenonton) {

            if (p.getEmail()
                    .equalsIgnoreCase(email)) {

                view.pesan(
                        "Email sudah terdaftar."
                );

                return;
            }
        }

        String noHP =
                view.bacaNoHP("No HP : ");

        String password =
                view.bacaPassword(
                        "Password : "
                );

        Penonton penonton =
                new Penonton(
                        nama,
                        email,
                        noHP,
                        password
                );

        daftarPenonton.add(penonton);

        view.pesan(
                "Akun berhasil dibuat."
        );
    }

    private void menuAdmin() {

        boolean logout = false;

        while (!logout) {

            admin.tampilkanMenu();

            int pilihan =
                    view.bacaPilihan(
                            "Pilih menu: ",
                            0,
                            5
                    );

            switch (pilihan) {

                case 1:
                    menuFilm();
                    break;

                case 2:
                    menuStudio();
                    break;

                case 3:
                    menuTiket();
                    break;

                case 4:
                    menuPenonton();
                    break;

                case 5:
                    lihatTransaksi();
                    break;

                case 0:
                    logout = true;
                    break;
            }
        }
    }

    private void menuPenonton(
            Penonton penonton) {

        boolean logout = false;

        while (!logout) {

            penonton.tampilkanMenu();

            int pilihan =
                    view.bacaPilihan(
                            "Pilih menu: ",
                            0,
                            5
                    );

            switch (pilihan) {

                case 1:
                    tampilProfil(penonton);
                    break;

                case 2:
                    lihatFilm();
                    break;

                case 3:
                    lihatStudio();
                    break;

                case 4:
                    beliTiket(penonton);
                    break;

                case 5:
                    lihatRiwayat(
                            penonton
                    );
                    break;

                case 0:
                    logout = true;
                    break;
            }
        }
    }

    private void menuFilm() {

        boolean kembali = false;

        while (!kembali) {

            System.out.println(
                    "\n========== DATA FILM =========="
            );

            System.out.println(
                    "1. Tambah"
            );

            System.out.println(
                    "2. Lihat"
            );

            System.out.println(
                    "3. Update"
            );

            System.out.println(
                    "4. Hapus"
            );

            System.out.println(
                    "0. Kembali"
            );

            int pilihan =
                    view.bacaPilihan(
                            "Pilih: ",
                            0,
                            4
                    );

            switch (pilihan) {

                case 1:
                    tambahFilm();
                    break;

                case 2:
                    lihatFilm();
                    break;

                case 3:
                    updateFilm();
                    break;

                case 4:
                    hapusFilm();
                    break;

                case 0:
                    kembali = true;
                    break;
            }
        }
    }

    private void tambahFilm() {

        String judul =
                view.bacaString(
                        "Judul film: "
                );

        String genre =
                view.bacaGenre();

        int durasi =
                view.bacaPositif(
                        "Durasi menit: "
                );

        double harga =
                view.bacaHarga(
                        "Harga tiket: Rp"
                );

        Film.tambah(
                new Film(
                        judul,
                        genre,
                        durasi,
                        harga
                )
        );

        view.pesan(
                "Film berhasil ditambahkan."
        );
    }

    private void lihatFilm() {

        System.out.println(
                "\n========== DAFTAR FILM =========="
        );

        if (Film.getDaftarFilm().isEmpty()) {

            view.pesan(
                    "Data film kosong."
            );

            return;
        }

        for (int i = 0;
                i < Film.getDaftarFilm().size();
                i++) {

            view.tampilFilm(
                    Film.getDaftarFilm().get(i),
                    i + 1
            );
        }
    }

    private void updateFilm() {

        lihatFilm();

        if (Film.getDaftarFilm().isEmpty()) {
            return;
        }

        int index =
                view.bacaPilihan(
                        "Nomor film: ",
                        1,
                        Film.getDaftarFilm().size()
                ) - 1;

        Film film =
                Film.getDaftarFilm().get(index);

        film.setJudul(
                view.bacaString(
                        "Judul baru: "
                )
        );

        film.setGenre(
                view.bacaGenre()
        );

        film.setDurasi(
                view.bacaPositif(
                        "Durasi baru: "
                )
        );

        film.setHarga(
                view.bacaHarga(
                        "Harga baru: Rp"
                )
        );

        view.pesan(
                "Film berhasil diupdate."
        );
    }

    private void hapusFilm() {

        lihatFilm();

        if (Film.getDaftarFilm().isEmpty()) {
            return;
        }

        int index =
                view.bacaPilihan(
                        "Nomor film: ",
                        1,
                        Film.getDaftarFilm().size()
                ) - 1;

        if (view.konfirmasi(
                "Hapus film ini?"
        )) {

            Film.hapus(index);

            view.pesan(
                    "Film berhasil dihapus."
            );
        }
    }

    // =====================================================
    // CRUD STUDIO
    // =====================================================

    private void menuStudio() {

        boolean kembali = false;

        while (!kembali) {

            System.out.println(
                    "\n========== DATA STUDIO =========="
            );

            System.out.println("1. Tambah");
            System.out.println("2. Lihat");
            System.out.println("3. Update");
            System.out.println("4. Hapus");
            System.out.println("0. Kembali");

            int pilihan =
                    view.bacaPilihan(
                            "Pilih: ",
                            0,
                            4
                    );

            switch (pilihan) {

                case 1:
                    tambahStudio();
                    break;

                case 2:
                    lihatStudio();
                    break;

                case 3:
                    updateStudio();
                    break;

                case 4:
                    hapusStudio();
                    break;

                case 0:
                    kembali = true;
                    break;
            }
        }
    }

    private void tambahStudio() {

        String nama =
                view.bacaString(
                        "Nama studio: "
                );

        int kapasitas =
                view.bacaPositif(
                        "Kapasitas: "
                );

        String tipe =
                view.bacaTipeStudio();

        Studio.tambah(
                new Studio(
                        nama,
                        kapasitas,
                        tipe
                )
        );

        view.pesan(
                "Studio berhasil ditambahkan."
        );
    }

    private void lihatStudio() {

        System.out.println(
                "\n========== DAFTAR STUDIO =========="
        );

        for (int i = 0;
                i < Studio.getDaftarStudio().size();
                i++) {

            view.tampilStudio(
                    Studio.getDaftarStudio().get(i),
                    i + 1
            );
        }
    }

    private void updateStudio() {

        lihatStudio();

        int index =
                view.bacaPilihan(
                        "Nomor studio: ",
                        1,
                        Studio.getDaftarStudio().size()
                ) - 1;

        Studio studio =
                Studio.getDaftarStudio().get(index);

        studio.setNama(
                view.bacaString(
                        "Nama baru: "
                )
        );

        studio.setKapasitas(
                view.bacaPositif(
                        "Kapasitas baru: "
                )
        );

        studio.setTipe(
                view.bacaTipeStudio()
        );

        view.pesan(
                "Studio berhasil diupdate."
        );
    }

    private void hapusStudio() {

        lihatStudio();

        int index =
                view.bacaPilihan(
                        "Nomor studio: ",
                        1,
                        Studio.getDaftarStudio().size()
                ) - 1;

        if (view.konfirmasi(
                "Hapus studio ini?"
        )) {

            Studio.hapus(index);

            view.pesan(
                    "Studio berhasil dihapus."
            );
        }
    }
    
    private void menuTiket() {

        boolean kembali = false;

        while (!kembali) {

            System.out.println(
                    "\n========== DATA TIKET =========="
            );

            System.out.println("1. Tambah");
            System.out.println("2. Lihat");
            System.out.println("3. Update");
            System.out.println("4. Hapus");
            System.out.println("0. Kembali");

            int pilihan =
                    view.bacaPilihan(
                            "Pilih: ",
                            0,
                            4
                    );

            switch (pilihan) {

                case 1:
                    tambahTiket();
                    break;

                case 2:
                    lihatTiket();
                    break;

                case 3:
                    updateTiket();
                    break;

                case 4:
                    hapusTiket();
                    break;

                case 0:
                    kembali = true;
                    break;
            }
        }
    }

    private void tambahTiket() {

        if (daftarPenonton.isEmpty()) {

            view.pesan(
                    "Belum ada penonton."
            );

            return;
        }

        System.out.println(
                "\n========== PILIH PENONTON =========="
        );

        for (int i = 0;
                i < daftarPenonton.size();
                i++) {

            System.out.println(
                    (i + 1)
                    + ". "
                    + daftarPenonton
                            .get(i)
                            .getNama()
            );
        }

        int penontonIndex =
                view.bacaPilihan(
                        "Pilih penonton: ",
                        1,
                        daftarPenonton.size()
                ) - 1;

        Penonton penonton =
                daftarPenonton.get(
                        penontonIndex
                );

        int filmIndex =
                view.pilihFilm();

        Film film =
                Film.getDaftarFilm()
                        .get(filmIndex);

        int studioIndex =
                view.pilihStudio();

        Studio studio =
                Studio.getDaftarStudio()
                        .get(studioIndex);

        int jumlah =
                view.bacaPositif(
                        "Jumlah tiket: "
                );

        if (jumlah >
                studio.getKapasitas()) {

            view.pesan(
                    "Jumlah melebihi kapasitas studio."
            );

            return;
        }

        Tiket tiket =
                new Tiket(
                        penonton,
                        film,
                        studio,
                        jumlah
                );

        Tiket.tambah(tiket);

        view.pesan(
                "Tiket berhasil dibuat."
        );
    }

    private void lihatTiket() {

        if (Tiket.getDaftarTiket().isEmpty()) {

            view.pesan(
                    "Belum ada tiket."
            );

            return;
        }

        for (int i = 0;
                i < Tiket.getDaftarTiket().size();
                i++) {

            view.tampilTiket(
                    Tiket.getDaftarTiket().get(i),
                    i + 1
            );
        }
    }

    private void updateTiket() {

        lihatTiket();

        if (Tiket.getDaftarTiket().isEmpty()) {
            return;
        }

        int index =
                view.bacaPilihan(
                        "Nomor tiket: ",
                        1,
                        Tiket.getDaftarTiket().size()
                ) - 1;

        Tiket tiket =
                Tiket.getDaftarTiket()
                        .get(index);

        int filmIndex =
                view.pilihFilm();

        int studioIndex =
                view.pilihStudio();

        int jumlah =
                view.bacaPositif(
                        "Jumlah tiket: "
                );

        Studio studio =
                Studio.getDaftarStudio()
                        .get(studioIndex);

        if (jumlah >
                studio.getKapasitas()) {

            view.pesan(
                    "Jumlah melebihi kapasitas."
            );

            return;
        }

        tiket.setFilm(
                Film.getDaftarFilm()
                        .get(filmIndex)
        );

        tiket.setStudio(studio);
        tiket.setJumlah(jumlah);

        view.pesan(
                "Tiket berhasil diupdate."
        );
    }

    private void hapusTiket() {

        lihatTiket();

        if (Tiket.getDaftarTiket().isEmpty()) {
            return;
        }

        int index =
                view.bacaPilihan(
                        "Nomor tiket: ",
                        1,
                        Tiket.getDaftarTiket().size()
                ) - 1;

        if (view.konfirmasi(
                "Hapus tiket ini?"
        )) {

            Tiket.hapus(index);

            view.pesan(
                    "Tiket berhasil dihapus."
            );
        }
    }

    // =====================================================
    // PENONTON
    // =====================================================

    private void menuPenonton() {

        lihatPenonton();
    }

    private void lihatPenonton() {

        System.out.println(
                "\n========== DAFTAR PENONTON =========="
        );

        if (daftarPenonton.isEmpty()) {

            view.pesan(
                    "Belum ada penonton."
            );

            return;
        }

        for (int i = 0;
                i < daftarPenonton.size();
                i++) {

            Penonton p =
                    daftarPenonton.get(i);

            System.out.println(
                    "\n[" + (i + 1) + "]"
            );

            System.out.println(
                    "Nama  : "
                    + p.getNama()
            );

            System.out.println(
                    "Email : "
                    + p.getEmail()
            );

            System.out.println(
                    "No HP : "
                    + p.getNoHP()
            );
        }
    }
    
    private void tampilProfil(
            Penonton penonton) {

        System.out.println(
                "\n========== PROFIL =========="
        );

        System.out.println(
                "Nama  : "
                + penonton.getNama()
        );

        System.out.println(
                "Email : "
                + penonton.getEmail()
        );

        System.out.println(
                "No HP : "
                + penonton.getNoHP()
        );
    }

    private void beliTiket(
            Penonton penonton) {

        int filmIndex =
                view.pilihFilm();

        Film film =
                Film.getDaftarFilm()
                        .get(filmIndex);

        int studioIndex =
                view.pilihStudio();

        Studio studio =
                Studio.getDaftarStudio()
                        .get(studioIndex);

        int jumlah =
                view.bacaPositif(
                        "Jumlah tiket: "
                );

        if (jumlah >
                studio.getKapasitas()) {

            view.pesan(
                    "Jumlah tiket melebihi kapasitas."
            );

            return;
        }

        Tiket tiket =
                new Tiket(
                        penonton,
                        film,
                        studio,
                        jumlah
                );

        Tiket.tambah(tiket);

        String id =
                "TRX-"
                + (
                    Transaksi
                    .getDaftarTransaksi()
                    .size()
                    + 1
                );

        Transaksi transaksi =
                new Transaksi(
                        id,
                        penonton,
                        tiket
                );

        Transaksi.tambah(
                transaksi
        );

        transaksi
                .tampilkanPembayaran();

        view.pesan(
                "Pembelian tiket berhasil."
        );
    }
    
    private void lihatTransaksi() {

        System.out.println(
                "\n========== RIWAYAT TRANSAKSI =========="
        );

        if (Transaksi
                .getDaftarTransaksi()
                .isEmpty()) {

            view.pesan(
                    "Belum ada transaksi."
            );

            return;
        }

        for (int i = 0;
                i < Transaksi
                        .getDaftarTransaksi()
                        .size();
                i++) {

            view.tampilTransaksi(
                    Transaksi
                            .getDaftarTransaksi()
                            .get(i),
                    i + 1
            );
        }
    }

    private void lihatRiwayat(
            Penonton penonton) {

        System.out.println(
                "\n========== RIWAYAT PEMBELIAN =========="
        );

        boolean ada = false;

        for (Transaksi transaksi :
                Transaksi
                        .getDaftarTransaksi()) {

            if (transaksi
                    .getPenonton()
                    .getEmail()
                    .equalsIgnoreCase(
                            penonton.getEmail()
                    )) {

                transaksi
                        .tampilkanPembayaran();

                ada = true;
            }
        }

        if (!ada) {

            view.pesan(
                    "Belum ada riwayat transaksi."
            );
        }
    }
}