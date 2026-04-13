package UTP;

abstract class Member {
    protected String id;
    protected String nama;
    protected int saldo;

    public Member(String id, String nama) {
        this.id = id;
        this.nama = nama;
        this.saldo = 0;
    }

    public String getId() { 
        return id; 
    }
    public String getNama() { 
        return nama; 
    }
    public int getSaldo() { 
        return saldo; 
    }

    public void topUp(int jumlah) {
        saldo += jumlah;
        System.out.println("Saldo " + id + ": " + saldo);
    }

    public abstract int hitungPembayaran(String layanan, int sesi);

    public boolean bayar(int total) {
        if (saldo < total) {
            System.out.println("Saldo " + id + " tidak cukup");
            return false;
        } else {
            saldo -= total;
            System.out.println("Total bayar " + id + ": " + total);
            System.out.println("Saldo " + id + ": " + saldo);
            return true;
        }
    }

    @Override
    public String toString() {
        return id + " | " + nama + " | " + this.getClass().getSimpleName() + " | saldo: " + saldo;
    }
}


