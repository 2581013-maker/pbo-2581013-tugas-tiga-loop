import java.util.Scanner;

public class TigaLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Batas deret (n) : ");
        int n = input.nextInt();

        // ===== 1. TIGA VERSI DERET 1..n =====
        System.out.println();
        System.out.println("===== SATU DERET, TIGA LOOP =====");

        // Versi for: pencacah a dibuat, dicek, dan dinaikkan di satu baris
        System.out.print("for      : ");
        for (int a = 1; a <= n; a++) {
            System.out.print(a + " ");
        }
        System.out.println();

        // Versi while: kondisi dicek SEBELUM badan loop
        System.out.print("while    : ");
        int b = 1;
        while (b <= n) {
            System.out.print(b + " ");
            b++; // pengubah jangan lupa, kalau tidak program menggantung
        }
        System.out.println();

        // Versi do-while: badan dijalankan dulu, kondisi dicek SESUDAH
        System.out.print("do-while : ");
        int c = 1;
        do {
            System.out.print(c + " ");
            c++;
        } while (c <= n);
        System.out.println();

        // ===== 2. BUKTI MELESET SATU (off-by-one) =====
        System.out.println();
        int kurang = 0;
        for (int i = 1; i < n; i++) {
            kurang++;
        }
        int kurangSama = 0;
        for (int i = 1; i <= n; i++) {
            kurangSama++;
        }
        System.out.println("i <  n berputar : " + kurang + " kali");
        System.out.println("i <= n berputar : " + kurangSama + " kali");

        // ===== 3. SARINGAN continue + break (angka tetap 1-10) =====
        System.out.println();
        System.out.print("Disaring : ");
        int hitungPrintln = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;   // genap: lompati sisa badan iterasi ini
            }
            if (i > 7) {
                break;      // berhenti kalau i > 7
            }
            System.out.print(i + " ");
            hitungPrintln++;
        }
        System.out.println();
        System.out.println("Sampai println  : " + hitungPrintln + " kali");

        input.close();
    }
}

/*
 * ===== KELUARAN PROGRAM =====
 *
 * Jalankan pertama, n = 5:
 *
 *   Batas deret (n) : 5
 *
 *   ===== SATU DERET, TIGA LOOP =====
 *   for      : 1 2 3 4 5
 *   while    : 1 2 3 4 5
 *   do-while : 1 2 3 4 5
 *
 *   i <  n berputar : 4 kali
 *   i <= n berputar : 5 kali
 *
 *   Disaring : 1 3 5 7
 *   Sampai println  : 4 kali
 *
 * Jalankan kedua, n = 0:
 *
 *   Batas deret (n) : 0
 *
 *   ===== SATU DERET, TIGA LOOP =====
 *   for      :
 *   while    :
 *   do-while : 1
 *
 *   i <  n berputar : 0 kali
 *   i <= n berputar : 0 kali
 *
 *   Disaring : 1 3 5 7
 *   Sampai println  : 4 kali
 *
 * KESIMPULAN do-while:
 * do-while memeriksa kondisinya SETELAH badan loop dijalankan, jadi
 * badannya pasti jalan minimal sekali.
 *
 * KENAPA HANYA do-while YANG MENCETAK PADA n = 0:
 * for dan while mengecek kondisi (1 <= 0 -> false) sebelum putaran pertama,
 * sehingga badan loop tidak pernah dimasuki. do-while sudah menjalankan
 * badannya sekali (mencetak 1) baru mengecek kondisi, yang baru false.
 *
 * BUKTI MELESET SATU:
 * Dengan n = 5, i < n berputar 4 kali (i = 1..4) sedangkan i <= n berputar
 * 5 kali (i = 1..5). Satu karakter "=" menambah satu putaran penuh.
 *
 * KENAPA LOOP TIDAK BERHENTI DI i = 8 PADAHAL 8 > 7:
 * Di badan loop, continue (lewati genap) ditulis SEBELUM break (i > 7).
 * Saat i = 8, angka itu genap sehingga continue langsung melompat ke
 * iterasi berikutnya dan baris "if (i > 7) break;" tidak pernah dicapai.
 * Pengecekan break baru terjadi pada i = 9 (ganjil, 9 > 7), dan baru di
 * situlah loop berhenti. Hasilnya tetap 1 3 5 7 dengan println 4 kali.
 */