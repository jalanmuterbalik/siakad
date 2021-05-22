package com.assignment;

class ElemenKantin extends ElemenFasilkom {
    
    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    Makanan[] daftarMakanan = new Makanan[10];
    int jumlah = 0;

    ElemenKantin(String nama) {
        /* TODO: implementasikan kode Anda di sini */
        super.nama = nama;
        super.tipe = "ElemenKantin";
    }

    void setMakanan(String nama, long harga) {
        /* TODO: implementasikan kode Anda di sini */
        Makanan makanan = new Makanan(nama, harga);
        this.daftarMakanan[this.jumlah] = makanan;
        jumlah++;
    }
}