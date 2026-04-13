package UTP;

class VIP extends Member {
    public VIP(String id, String nama) {
        super(id, nama);
    }

    @Override
    public int hitungPembayaran(String layanan, int sesi) {
        int harga = getHargaLayanan(layanan);
        if (harga == -1) {
            return -1;
        } else {
            int dasar = harga * sesi;
            int diskonSesi = 0;
            if (sesi > 5) {
                diskonSesi = (dasar * 10) / 100;
            }
            int diskonVIP = (dasar * 15) / 100;
            int subtotal = dasar - diskonSesi - diskonVIP;
            int pajak = (subtotal * 5) / 100;
            return subtotal + pajak;
        }
    }

    private int getHargaLayanan(String layanan) {
        switch (layanan) {
            case "cardio": return 20000;
            case "yoga": return 25000;
            case "personal_training": return 40000;
            default: return -1;
        }
    }
}

