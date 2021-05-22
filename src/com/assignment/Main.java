package com.assignment;

import java.util.Scanner;

public class Main {

    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    static ElemenFasilkom[] daftarElemenFasilkom = new ElemenFasilkom[100];

    static MataKuliah[] daftarMataKuliah = new MataKuliah[100];

    static int totalMataKuliah = 0;

    static int totalElemenFasilkom = 0;

    // tambahan
    static Dosen[] daftarDosen = new Dosen[100];
    static int totalDosen = 0;

    static int checkNamaMahasiswa(String nama, String tipe) {
        int ada = -1;
        for (int i = 0; i < daftarElemenFasilkom.length; i++) {
            if (daftarElemenFasilkom[i] != null && daftarElemenFasilkom[i].nama.equalsIgnoreCase(nama)
                    && daftarElemenFasilkom[i].tipe.equalsIgnoreCase(tipe)) {
                ada = i;
                break;
            }
        }
        return ada;
    }

    static int checkMataKuliah(String nama) {
        int ada = -1;
        for (int i = 0; i < daftarMataKuliah.length; i++) {
            if (daftarMataKuliah[i] != null && daftarMataKuliah[i].nama.equalsIgnoreCase(nama)) {
                ada = i;
                break;
            }
        }
        return ada;
    }
    static int checkDosen(String nama) {
        int ada = -1;
        for (int i = 0; i < daftarDosen.length; i++) {
            if (daftarDosen[i] != null && daftarDosen[i].nama.equalsIgnoreCase(nama)) {
                ada = i;
                break;
            }
        }
        return ada;
    }

    static int checkElemenFasilkom(String nama) {
        int ada = -1;
        for (int i = 0; i < daftarElemenFasilkom.length; i++) {
            if (daftarElemenFasilkom[i] != null && daftarElemenFasilkom[i].nama.equalsIgnoreCase(nama)) {
                ada = i;
                break;
            }
        }
        return ada;
    }

    static void addMahasiswa(String nama, long npm) {
        /* TODO: implementasikan kode Anda di sini */
        if (checkNamaMahasiswa(nama, "Mahasiswa") == -1) {
            Mahasiswa mhs = new Mahasiswa(nama, npm);
            daftarElemenFasilkom[totalElemenFasilkom] = mhs;
            totalElemenFasilkom++;
            System.out.println(mhs.extractTanggalLahir(npm));
            System.out.println(mhs.extractJurusan(npm));
        } else {
            System.out.println("Gagal tambah elemen : sudah terdaftar");
        }
    }

    static void addDosen(String nama) {
        /* TODO: implementasikan kode Anda di sini */
        if (checkNamaMahasiswa(nama, "Dosen") == -1) {
            daftarDosen[totalDosen] = new Dosen(nama);
            daftarElemenFasilkom[totalElemenFasilkom] = daftarDosen[totalDosen];
            totalDosen++;
            totalElemenFasilkom++;
        } else {
            System.out.println("Gagal tambah elemen : sudah terdaftar");
        }
    }

    static void addElemenKantin(String nama) {
        /* TODO: implementasikan kode Anda di sini */
        if (checkNamaMahasiswa(nama, "ElemenKantin") == -1) {
            daftarElemenFasilkom[totalElemenFasilkom] = new ElemenKantin(nama);
            totalElemenFasilkom++;
        } else {
            System.out.println("Gagal tambah elemen : sudah terdaftar");
        }
    }

    static void menyapa(String objek1, String objek2) {
        /* TODO: implementasikan kode Anda di sini */
        int i = checkElemenFasilkom(objek1);
        int j = checkElemenFasilkom(objek2);
        if (i >= 0 && j >= 0) {
            System.out.println("BELUMAN menyapa");
        } else {
            System.out.println("[DITOLAK] Salah satu objek tidak termasuk elemen Fasilkom");
        }
    }

    static void addMakanan(String objek, String namaMakanan, long harga) {
        /* TODO: implementasikan kode Anda di sini */
        int i = checkNamaMahasiswa(objek, "ElemenKantin");
        if (i >= 0) {
            // BELUMAN
        } else {
            System.out.println("[DITOLAK] " + objek + " bukan merupakan elemen kantin");
        }
    }

    static void membeliMakanan(String objek1, String objek2, String namaMakanan) {
        /* TODO: implementasikan kode Anda di sini */
    }

    static void createMatkul(String nama, int kapasitas) {
        /* TODO: implementasikan kode Anda di sini */
        int i = checkMataKuliah(nama);
        if (i >= 0) {
            System.out.println("[DITOLAK] Matkul sudah terdaftar");
        } else {
            daftarMataKuliah[totalMataKuliah] = new MataKuliah(nama, kapasitas);
            totalMataKuliah++;
        }
    }

    static void addMatkul(String objek, String namaMataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
        int i = checkNamaMahasiswa(objek, "Mahasiswa");
        if (i >= 0) {
            int j = checkMataKuliah(namaMataKuliah);
            if (j >= 0) {
                //daftarMataKuliah[j].addMahasiswa(new Mahasiswa(daftarElemenFasilkom[i].nama, daftarElemenFasilkom[i].));
            } else {
                System.out.println("[DITOLAK] Matkul tidak ditemukan");
            }
        } else {
            System.out.println("[DITOLAK] Hanya mahasiswa yang dapat menambahkan matkul");
        }
    }

    static void dropMatkul(String objek, String namaMataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
    }

    static void mengajarMatkul(String objek, String namaMataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
        int i = checkNamaMahasiswa(objek, "Dosen");
        if (i >= 0) {
            int j = checkMataKuliah(namaMataKuliah);
            if (j >= 0){
                int k = checkDosen(objek);
                if (k >= 0) {
                    daftarDosen[k].mengajarMataKuliah(new MataKuliah(daftarMataKuliah[j].nama, daftarMataKuliah[j].kapasitas));
                } else {
                    System.out.println("[DITOLAK] Dosen tidak ditemukan");
                }
            } else {
                System.out.println("[DITOLAK] Matkul tidak ditemukan");
            }
        } else {
            System.out.println("[DITOLAK] Hanya dosen yang dapat mengajar matkul");
        }
    }

    static void berhentiMengajar(String objek) {
        /* TODO: implementasikan kode Anda di sini */
    }

    static void ringkasanMahasiswa(String objek) {
        /* TODO: implementasikan kode Anda di sini */
        int i = checkNamaMahasiswa(objek, "Mahasiswa");
    }

    static void ringkasanMataKuliah(String namaMataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
        int i = checkMataKuliah(namaMataKuliah);
        if (i >= 0) {
            System.out.println(daftarMataKuliah[i].getDaftarMahasiswa());
        }
    }

    static void nextDay() {
        /* TODO: implementasikan kode Anda di sini */
    }

    static void friendshipRanking() {
        /* TODO: implementasikan kode Anda di sini */
    }

    static void programEnd() {
        /* TODO: implementasikan kode Anda di sini */
        System.exit(0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (true) {
            String in = input.nextLine();
            if (in.split(" ")[0].equals("ADD_MAHASISWA")) {
                addMahasiswa(in.split(" ")[1], Long.parseLong(in.split(" ")[2]));
            } else if (in.split(" ")[0].equals("ADD_DOSEN")) {
                addDosen(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("ADD_ELEMEN_KANTIN")) {
                addElemenKantin(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("MENYAPA")) {
                menyapa(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("ADD_MAKANAN")) {
                addMakanan(in.split(" ")[1], in.split(" ")[2], Long.parseLong(in.split(" ")[3]));
            } else if (in.split(" ")[0].equals("MEMBELI_MAKANAN")) {
                membeliMakanan(in.split(" ")[1], in.split(" ")[2], in.split(" ")[3]);
            } else if (in.split(" ")[0].equals("CREATE_MATKUL")) {
                createMatkul(in.split(" ")[1], Integer.parseInt(in.split(" ")[2]));
            } else if (in.split(" ")[0].equals("ADD_MATKUL")) {
                addMatkul(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("DROP_MATKUL")) {
                dropMatkul(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("MENGAJAR_MATKUL")) {
                mengajarMatkul(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("BERHENTI_MENGAJAR")) {
                berhentiMengajar(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("RINGKASAN_MAHASISWA")) {
                ringkasanMahasiswa(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("RINGKASAN_MATKUL")) {
                ringkasanMataKuliah(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("NEXT_DAY")) {
                nextDay();
            } else if (in.split(" ")[0].equals("PROGRAM_END")) {
                programEnd();
                break;
            }
        }
    }
}