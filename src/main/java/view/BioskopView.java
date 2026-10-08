/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import model.Film;
import model.Studio;
import model.Tiket;
import model.Transaksi;

/**
 *
 * @author ADVAN
 */
public class BioskopView {

    private final Scanner input =
            new Scanner(System.in);

    public void header() {

        System.out.println(
                "\n=========================================="
        );

        System.out.println(
                "       SISTEM MANAJEMEN BIOSKOP"
        );

        System.out.println(
                "=========================================="
        );
    }

    public String bacaString(String pesan) {

        while (true) {

            System.out.print(pesan);

            String hasil =
                    input.nextLine().trim();

            if (!hasil.isEmpty()) {
                return hasil;
            }

            System.out.println(
                    "Input tidak boleh kosong."
            );
        }
    }

    public String bacaNama(String pesan) {

        while (true) {

            String nama =
                    bacaString(pesan);

            if (nama.matches("[a-zA-Z ]+")) {
                return nama;
            }

            System.out.println(
                    "Nama hanya boleh menggunakan huruf."
            );
        }
    }

    public String bacaEmail(String pesan) {

        while (true) {

            String email =
                    bacaString(pesan);

            if (email.matches(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

                return email;
            }

            System.out.println(
                    "Format email tidak valid."
            );
        }
    }

    public String bacaNoHP(String pesan) {

        while (true) {

            String noHP =
                    bacaString(pesan);

            if (noHP.matches("[0-9]{10,13}")) {
                return noHP;
            }

            System.out.println(
                    "No HP harus 10-13 digit."
            );
        }
    }

    public String bacaPassword(String pesan) {

        while (true) {

            String password =
                    bacaString(pesan);

            if (password.length() >= 6) {
                return password;
            }

            System.out.println(
                    "Password minimal 6 karakter."
            );
        }
    }

    public int bacaInt(String pesan) {

        while (true) {

            try {

                System.out.print(pesan);

                String teks =
                        input.nextLine().trim();

                if (teks.isEmpty()) {

                    System.out.println(
                            "Input tidak boleh kosong."
                    );

                    continue;
                }

                int angka =
                        Integer.parseInt(teks);

                if (angka >= 0) {
                    return angka;
                }

                System.out.println(
                        "Angka tidak boleh negatif."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input harus berupa angka."
                );
            }
        }
    }

    public int bacaPositif(String pesan) {

        while (true) {

            int angka =
                    bacaInt(pesan);

            if (angka > 0) {
                return angka;
            }

            System.out.println(
                    "Nilai harus lebih dari 0."
            );
        }
    }

    public double bacaHarga(String pesan) {

        while (true) {

            try {

                System.out.print(pesan);

                String teks =
                        input.nextLine().trim();

                double harga =
                        Double.parseDouble(teks);

                if (harga > 0) {
                    return harga;
                }

                System.out.println(
                        "Harga harus lebih dari 0."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Harga harus berupa angka."
                );
            }
        }
    }

    public int bacaPilihan(
            String pesan,
            int min,
            int max) {

        while (true) {

            int pilihan =
                    bacaInt(pesan);

            if (pilihan >= min
                    && pilihan <= max) {

                return pilihan;
            }

            System.out.println(
                    "Pilihan hanya "
                    + min
                    + " - "
                    + max
            );
        }
    }

    public String bacaGenre() {

        while (true) {

            System.out.println(
                    "\nPilihan Genre:"
            );

            System.out.println(
                    "1. Action"
            );

            System.out.println(
                    "2. Comedy"
            );

            System.out.println(
                    "3. Horror"
            );

            System.out.println(
                    "4. Romance"
            );

            System.out.println(
                    "5. Sci-Fi"
            );

            System.out.println(
                    "6. Animation"
            );

            int pilihan =
                    bacaPilihan(
                            "Pilih genre: ",
                            1,
                            6
                    );

            switch (pilihan) {

                case 1:
                    return "Action";

                case 2:
                    return "Comedy";

                case 3:
                    return "Horror";

                case 4:
                    return "Romance";

                case 5:
                    return "Sci-Fi";

                case 6:
                    return "Animation";
            }
        }
    }

    public String bacaTipeStudio() {

        while (true) {

            System.out.println(
                    "\n1. Regular"
            );

            System.out.println(
                    "2. VIP"
            );

            int pilihan =
                    bacaPilihan(
                            "Pilih tipe studio: ",
                            1,
                            2
                    );

            if (pilihan == 1) {
                return "Regular";
            }

            if (pilihan == 2) {
                return "VIP";
            }
        }
    }

    public boolean konfirmasi(
            String pesan) {

        while (true) {

            String jawaban =
                    bacaString(
                            pesan
                            + " (y/n): "
                    );

            if (jawaban.equalsIgnoreCase("y")) {
                return true;
            }

            if (jawaban.equalsIgnoreCase("n")) {
                return false;
            }

            System.out.println(
                    "Masukkan y atau n."
            );
        }
    }

    public int pilihFilm() {

        System.out.println(
                "\n========== PILIH FILM =========="
        );

        for (int i = 0;
                i < Film.getDaftarFilm().size();
                i++) {

            Film film =
                    Film.getDaftarFilm().get(i);

            System.out.println(
                    (i + 1)
                    + ". "
                    + film.getJudul()
                    + " | "
                    + film.getGenre()
                    + " | Rp"
                    + film.getHarga()
            );
        }

        return bacaPilihan(
                "Pilih film: ",
                1,
                Film.getDaftarFilm().size()
        ) - 1;
    }

    public int pilihStudio() {

        System.out.println(
                "\n========== PILIH STUDIO =========="
        );

        for (int i = 0;
                i < Studio.getDaftarStudio().size();
                i++) {

            Studio studio =
                    Studio.getDaftarStudio().get(i);

            System.out.println(
                    (i + 1)
                    + ". "
                    + studio.getNama()
                    + " | "
                    + studio.getTipe()
                    + " | "
                    + studio.getKapasitas()
                    + " kursi"
            );
        }

        return bacaPilihan(
                "Pilih studio: ",
                1,
                Studio.getDaftarStudio().size()
        ) - 1;
    }

    public void tampilFilm(
            Film film,
            int nomor) {

        System.out.println(
                "\n[" + nomor + "]"
        );

        System.out.println(film);
    }

    public void tampilStudio(
            Studio studio,
            int nomor) {

        System.out.println(
                "\n[" + nomor + "]"
        );

        System.out.println(studio);
    }

    public void tampilTiket(
            Tiket tiket,
            int nomor) {

        System.out.println(
                "\n[" + nomor + "]"
        );

        System.out.println(tiket);
    }

    public void tampilTransaksi(
            Transaksi transaksi,
            int nomor) {

        System.out.println(
                "\n[" + nomor + "]"
        );

        System.out.println(transaksi);
    }

    public void pesan(String pesan) {
        System.out.println("\n" + pesan);
    }
}