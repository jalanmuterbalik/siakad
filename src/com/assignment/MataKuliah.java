package com.assignment;

class MataKuliah {

    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    String nama;
    
    int kapasitas;

    Dosen dosen;

    Mahasiswa[] daftarMahasiswa;

    MataKuliah(String nama, int kapasitas) {
        /* TODO: implementasikan kode Anda di sini */
        this.nama = nama;
        this.kapasitas = kapasitas;
    }

    int checkMahasiswa(String nama) {
        int ada = -1;
        for (int i = 0; i < this.daftarMahasiswa.length; i++) {
            if (this.daftarMahasiswa[i] != null && this.daftarMahasiswa[i].nama.equalsIgnoreCase(nama)) {
                ada = i;
                break;
            }
        }
        return ada;
    }

    void addMahasiswa(Mahasiswa mahasiswa) {
        /* TODO: implementasikan kode Anda di sini */
        if (this.daftarMahasiswa.length <= this.kapasitas) {
            int i = checkMahasiswa(mahasiswa.nama);
            if (i < 0) {
                this.daftarMahasiswa[i] = mahasiswa;
                System.out.println(mahasiswa.nama + " berhasil menambahkan mata kuliah " + this.nama);
            }
        } else {
            System.out.println("[DITOLAK] " + this.nama + " telah penuh kapasitasnya");
        }
    }

    void dropMahasiswa(Mahasiswa mahasiswa) {
        /* TODO: implementasikan kode Anda di sini */
        int i = checkMahasiswa(mahasiswa.nama);
        if (i >= 0) {
            System.out.println("Mahasiswa " + mahasiswa.nama + " berhasil dihapus");
            this.daftarMahasiswa[i] = null;
        }
    }

    void addDosen(Dosen dosen) {
        /* TODO: implementasikan kode Anda di sini */
        if (this.dosen == null) {
            this.dosen = dosen;
            dosen.mengajarMataKuliah(this);
        }
    }

    void dropDosen() {
        /* TODO: implementasikan kode Anda di sini */
        if (this.dosen != null) {
            this.dosen = null;
            dosen.dropMataKuliah();
        }
    }

    public String getDaftarMahasiswa() {
        if(this.daftarMahasiswa == null) return "Belum ada yang mengambil mata kuliah ini";

        for (int i = 0; i <= this.daftarMahasiswa.length; i++) {
            System.out.println(this.daftarMahasiswa[i].nama);
        }
        return null;
    }

    public String toString() {
        /* TODO: implementasikan kode Anda di sini */
        return "Nama mata kuliah : " + this.nama + "\n" +
                "Kapasitas : " + this.kapasitas + "\n" +
                "Jumlah mahasiswa : " + this.daftarMahasiswa.length + "\n" +
                "Daftar mahasiswa yang mengambil mata kuliah ini : \n" + this.getDaftarMahasiswa();
    }
}