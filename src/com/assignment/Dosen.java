package com.assignment;

class Dosen extends ElemenFasilkom {

    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    MataKuliah mataKuliah;

    Dosen(String nama) {
        /* TODO: implementasikan kode Anda di sini */
        super.nama = nama;
        super.tipe = "Dosen";
    }

    void mengajarMataKuliah(MataKuliah mataKuliah) {
        /* TODO: implementasikan kode Anda di sini */
        if (this.mataKuliah == null) {
            this.mataKuliah = mataKuliah;
            System.out.println(this.nama + " mengajar mata kuliah " + mataKuliah.nama);
        } else {
            System.out.println("[DITOLAK] " + this.nama + " sudah mengajar mata kuliah " + this.mataKuliah.nama);
        }
    }

    void dropMataKuliah() {
        /* TODO: implementasikan kode Anda di sini */
        if (this.mataKuliah != null) {
            System.out.println(this.nama + " berhenti mengajar " + this.mataKuliah.nama);
            this.mataKuliah = null;
        } else {
            System.out.println("[DITOLAK] " + this.nama + " sedang tidak mengajar mata kuliah apapun");
        }
    }
}