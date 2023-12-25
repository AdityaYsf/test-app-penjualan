import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplikasiPenjualan{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Barang> daftarBelanja = new ArrayList<>();
        int totalHarga = 0;

        while (true) {
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tampilkan Daftar Belanja");
            System.out.println("3. Hitung Total Harga");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahBarang(scanner, daftarBelanja);
                    break;
                case 2:
                    tampilkanDaftarBelanja(daftarBelanja);
                    break;
                case 3:
                    totalHarga = hitungTotalHarga(daftarBelanja);
                    System.out.println("Total Harga: Rp " + totalHarga);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void tambahBarang(Scanner scanner, List<Barang> daftarBelanja) {
        System.out.print("Masukkan nama barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Masukkan harga barang: ");
        int harga = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan jumlah barang: ");
        int jumlah = scanner.nextInt();

        Barang barang = new Barang(namaBarang, harga, jumlah);
        daftarBelanja.add(barang);
    }

    private static void tampilkanDaftarBelanja(List<Barang> daftarBelanja) {
        System.out.println("------------------------------------");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Nama Barang", "Harga", "Jumlah", "Total");
        System.out.println("------------------------------------");

        for (Barang barang : daftarBelanja) {
            System.out.printf("%-20s %-10d %-10d %-10d%n", barang.getNamaBarang(), barang.getHarga(), barang.getJumlah(), barang.getTotal());
        }

        System.out.println("------------------------------------");
    }

    private static int hitungTotalHarga(List<Barang> daftarBelanja) {
        int totalHarga = 0;

        for (Barang barang : daftarBelanja) {
            totalHarga += barang.getTotal();
        }

        return totalHarga;
    }
}

class Barang {
    private String namaBarang;
    private int harga;
    private int jumlah;
    private int total;

    public Barang(String namaBarang, int harga, int jumlah) {
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.jumlah = jumlah;
        this.total = harga * jumlah;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getTotal() {
        return total;
    }
}
