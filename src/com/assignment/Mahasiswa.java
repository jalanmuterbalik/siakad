package com.assignment;

class Mahasiswa extends ElemenFasilkom {
    
    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    MataKuliah[] daftarMataKuliah = new MataKuliah[10];
    
    long npm;

    String tanggalLahir;
    
    String jurusan;

    Mahasiswa(String nama, long npm) {
        /* TODO: implementasikan kode Anda di sini */
        this.npm = npm;
        super.nama = nama;
        super.tipe = "Mahasiswa";
    }

    int checkMatkul(String nama) {
        int ada = -1;
        for (int i = 0; i < this.daftarMataKuliah.length; i++) {
            if (this.daftarMataKuliah[i] != null && this.daftarMataKuliah[i].nama.equalsIgnoreCase(nama)) {
                ada = i;
                break;
            }
        }
        return ada;
    }

    void addMatkul(MataKuliah mataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
        int i = checkMatkul(mataKuliah.nama);
        if (i < 0) {
            this.daftarMataKuliah[i].addMahasiswa(this);
        } else {
            System.out.println("[DITOLAK] " + mataKuliah.nama + " telah diambil sebelumnya");
        }
    }

    void dropMatkul(MataKuliah mataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
        int i = checkMatkul(mataKuliah.nama);
        if (i < 0) {
            System.out.println("[DITOLAK] " + mataKuliah.nama + " belum pernah diambil");
        } else {
            this.daftarMataKuliah[i] = null;
            System.out.println(this.nama + " berhasil drop mata kuliah " + mataKuliah.nama);
        }
    }

    @Override
    public String getNama() {
        return super.getNama();
    }

    String extractTanggalLahir(long npm) {
        /* TODO: implementasikan kode Anda di sini */
        String no = String.valueOf(npm);
        String tanggal = no.substring(4,6);
        String bulan = no.substring(6,8);
        String tahun = no.substring(8,12);
        return "Tanggal : " + tanggal + " - Bulan : " + bulan + " - Tahun : " + tahun;
    }

    String extractJurusan(long npm) {
        /* TODO: implementasikan kode Anda di sini */
        String no = String.valueOf(npm);
        String jurusan = no.substring(2,4);
        String jur;
        switch (jurusan){
            case "01":
                jur = "Ilmu Komputer";
                break;
            case "02":
                jur = "Sistem Informasi";
                break;
            default:
                jur = "[DITOLAK] Format salah";
                break;
        }

        return "Jurusan : " + jur;
    }
}