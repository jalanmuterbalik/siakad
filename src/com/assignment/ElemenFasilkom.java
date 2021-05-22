package com.assignment;

abstract class ElemenFasilkom {
    
    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    String tipe;
    
    String nama;

    int friendship;

    ElemenFasilkom[] telahMenyapa = new ElemenFasilkom[100];

    // tambahan
    long npm;
    // end of tambahan variabel

    void menyapa(ElemenFasilkom elemenFasilkom) {
        /* TODO: implementasikan kode Anda di sini */
        if (this.nama == elemenFasilkom.nama) {
            System.out.println("[DITOLAK] Objek yang sama tidak bisa saling menyapa");
        }
    }

    void resetMenyapa() {
        /* TODO: implementasikan kode Anda di sini */
        if (this.telahMenyapa != null) {
            this.telahMenyapa = null;
        }
    }

    void membeliMakanan(ElemenFasilkom pembeli, ElemenFasilkom penjual, String namaMakanan) {
        /* TODO: implementasikan kode Anda di sini */
    }

    public String toString() {
        /* TODO: implementasikan kode Anda di sini */
        return "Namanya " + nama + ", tipenya " + tipe;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getTipe() {
        return tipe;
    }

    public void setFriendship(int friendship) {
        this.friendship = friendship;
    }

    public void setTelahMenyapa(ElemenFasilkom[] telahMenyapa) {
        this.telahMenyapa = telahMenyapa;
    }
}