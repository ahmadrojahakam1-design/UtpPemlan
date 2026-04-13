package UTP;

import java.util.*;

public class GymSystem {
    private static Map<String, Member> members = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());

        for (int i = 0; i < N; i++) {
            String[] cmd = in.nextLine().split(" ");
            switch (cmd[0]) {
                case "ADD":
                    addMember(cmd[1], cmd[2], cmd[3]);
                    break;
                case "TOPUP":
                    topUp(cmd[1], Integer.parseInt(cmd[2]));
                    break;
                case "BUY":
                    buy(cmd[1], cmd[2], Integer.parseInt(cmd[3]));
                    break;
                case "CHECK":
                    check(cmd[1]);
                    break;
                case "COUNT":
                    System.out.println("Total member: " + members.size());
                    break;
                default:
                    System.out.println("Perintah tidak valid");
                    break;
            }
        }
        in.close();
    }

    private static void addMember(String tipe, String id, String nama) {
        if (members.containsKey(id)) {
            System.out.println("Member sudah terdaftar");
        } else {
            Member Gym;
            if (tipe.equals("REGULER")) {
                Gym = new Reguler(id, nama);
            } else {
                Gym = new VIP(id, nama);
            }
            members.put(id, Gym);
            System.out.println(tipe + " " + id + " berhasil ditambahkan");
        }
    }

    private static void topUp(String id, int jumlah) {
        Member Gym = members.get(id);
        if (Gym == null) {
            System.out.println("Member tidak ditemukan");
        } else {
            Gym.topUp(jumlah);
        }
    }

    private static void buy(String id, String layanan, int sesi) {
        Member Gym = members.get(id);
        if (Gym == null) {
            System.out.println("Member tidak ditemukan");
        } else {
            int total = Gym.hitungPembayaran(layanan, sesi);
            if (total == -1) {
                System.out.println("Layanan tidak valid");
            } else {
                Gym.bayar(total);
            }
        }
    }

    private static void check(String id) {
        Member Gym = members.get(id);
        if (Gym == null) {
            System.out.println("Member tidak ditemukan");
        } else {
            System.out.println(Gym);
        }
    }
}


