import java.util.Scanner;

public class Main {
    static String[] listUsername = { "admin", "karyawan" };
    static String[] listPassword = { "admin123", "karyawan456" };
    static String[] listNamaKaryawan = {
        "Dor", "Budi", 
    };
    static int[] indexJabatanKaryawan = {
        0, 4, 
    };
    static double[] listGajiJabatan = {
        0, 2000, 3000, 4000, 5000
    };
    static String[] listJabatanKaryawan = {
        "admin", "Satpam", "Sekertaris", "Manajer", "Direktur"
    };

    static int[] percentageTunjanganJabatan = {
        0, 5, 10, 12, 20,
    };

    static double[][] riwayatGaji = {
        { 0, },
        { 1000, 1500, 2000, 2500 },
    };

    static String[] bulan = {
        "Januari", "Februari", "Maret", "April", "Mei",
        "Juni", "Juli", "Agustus", "September", "Oktober",
        "November", "Desember"
    };

    static Scanner scan = new Scanner(System.in);

    ///Login
    public static int login(String username, String password) {
        int indexUsername = -1;
        boolean result = false;
        for (int i = 0; i < listUsername.length; i++) {
            if (listUsername[i].equals(username)) {
                indexUsername = i;
                break;
            }
        }
        if (indexUsername >= 0) {
            if (listPassword[indexUsername].equals(password)) {
                System.out.println("Login Berhasil!");
                result = true;
            } else {
                System.out.println("Password yang Anda masukkan salah!");
            }
        } else {
            System.out.println("Akun tidak terdaftar");
        }

        if (result) {
            return indexUsername;
        } else {
            return -1;
        }
    }

    ///Menambah data baru Karyawan
    public static void tambahDataKaryawan() {
        System.out.println("---- Tambah Data Karyawan ----");
        System.out.print("Nama : ");
        String nama = scan.nextLine();
        listNamaKaryawan = addNewStringData(listNamaKaryawan.length, listNamaKaryawan, nama);
        System.out.print("Username : ");
        String username = scan.nextLine();
        listUsername = addNewStringData(listUsername.length, listUsername, username);
        System.out.print("Password : ");
        String password = scan.nextLine();
        listPassword = addNewStringData(listPassword.length, listPassword, password);

        for (int i = 1; i < listJabatanKaryawan.length; i++) {
            System.out.println((i) + ". " + listJabatanKaryawan[i] + ", gaji => " + listGajiJabatan[i]);
        }

        System.out.print("Jabatan :  ");
        int indexJabatan = scan.nextInt();
        scan.nextLine();

        indexJabatanKaryawan = addNewIntData(indexJabatanKaryawan.length, indexJabatanKaryawan, indexJabatan);
        double[] newRow = new double[0];
        riwayatGaji = insertRowInto2D(riwayatGaji, riwayatGaji.length, newRow);
    }

    ///Menambahkan baris baru pada array 2d 
    public static double[][] insertRowInto2D(double[][] array, int size, double[] data) {
        double[][] newArr = new double[array.length + 1][];
        for (int i = 0; i < size; i++) {
            newArr[i] = array[i];
        }
        newArr[size] = data;

        return newArr;
    }

    ///Untuk menambah data baru bertipe data double, int, string
    public static double[] addNewDoubleData(int initialSize, double array[], double data) {
        double newArr[] = new double[initialSize + 1];
        for (int i = 0; i < initialSize; i++) {
            newArr[i] = array[i];
        }
        newArr[initialSize] = data;

        return newArr;
    }

    public static int[] addNewIntData(int initialSize, int array[], int data) {
        int newArr[] = new int[initialSize + 1];
        for (int i = 0; i < initialSize; i++) {
            newArr[i] = array[i];
        }
        newArr[initialSize] = data;

        return newArr;
    }

    public static String[] addNewStringData(int initialSize, String array[], String data) {
        String newArr[] = new String[initialSize + 1];
        for (int i = 0; i < initialSize; i++) {
            newArr[i] = array[i];
        }
        newArr[initialSize] = data;

        return newArr;
    }

    ///Menampilkan Tampil Gaji dan Data Karyawan
    public static void tampil() {
        System.out.println("---- Menampilkan Gaji dan Data Karyawan ----");
        System.out.println("-----------------------------");
        System.out.println("| Nama        | Gaji        |");
        System.out.println("-----------------------------");
        for (int i = 1; i < listNamaKaryawan.length; i++) {
            int indexJK = indexJabatanKaryawan[i];
            System.out.printf("| %-12s| %-12f|", listNamaKaryawan[i], listGajiJabatan[indexJK]);
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    ///Menampilkan Data Karyawan
    public static void tampilDataKaryawan() {
        System.out.println("---- Menampilkan Informasi Karyawan -----");
        System.out.println("-----------------------------------------");
        System.out.println("| Nama        | Gaji        | Jabatan   |");
        System.out.println("-----------------------------------------");
        for (int i = 1; i < listNamaKaryawan.length; i++) {
            int indexJK = indexJabatanKaryawan[i];

            System.out.printf("| %-12s| %-12f| %-10s|", listNamaKaryawan[i], listGajiJabatan[indexJK],
                    listJabatanKaryawan[indexJK]);
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }

    ///Mengupdate Data Karyawan
    public static void updateDataKaryawan(int indexKaryawan) {
        System.out.println("---- Mengupdate Data Karyawan ----");
        System.out.print("Nama : ");
        String nama = scan.nextLine();
        System.out.print("Username : ");
        String username = scan.nextLine();
        System.out.print("Password : ");
        String password = scan.nextLine();
        System.out.print("Jabatan (input index jabatan dengan tipe data int) : ");
        int indexJabatan = scan.nextInt();

        listNamaKaryawan[indexKaryawan] = nama;
        listUsername[indexKaryawan] = username;
        listPassword[indexKaryawan] = password;
        indexJabatanKaryawan[indexKaryawan] = indexJabatan;

    }

    ///Menghitung Gaji Karyawan
    public static void hitungGaji() {
        for (int i = 1; i < listNamaKaryawan.length; i++) {
            System.out.println((i) + ". " + listNamaKaryawan[i]);
        }
        System.out.print("Masukkan no urut/index karyawan : ");
        int indexKaryawan = scan.nextInt();
        scan.nextLine();
        double gajiKaryawan = hitungGajiKaryawan(indexKaryawan);
        System.out.println("Gaji dari " + listNamaKaryawan[indexKaryawan] + " adalah: " + gajiKaryawan);
    
        System.out.println("Apakah ingin menyimpan gaji ke riwayat? ");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        System.out.print("Ketik : ");
        int pilihan = scan.nextInt();
        scan.nextLine();
    
        if (pilihan == 1) {
            riwayatGaji[indexKaryawan] = addNewDoubleData(riwayatGaji[indexKaryawan].length, riwayatGaji[indexKaryawan], gajiKaryawan);
        }
    }
   

    ///Menu Admin
    public static void chooseMenuAdmin() {
        boolean isOut = false;

        do {
            int menu = 0;

            System.out.println();
            System.out.println("==================================================");
            System.out.println("             Sistem Aplikasi Kepegawaian");
            System.out.println("                 Masuk Sebagai Admin");
            System.out.println("==================================================");
            System.out.println("1. Tampilkan Data Gaji dan Karyawan");
            System.out.println("2. Tampilkan Informasi Karyawan");
            System.out.println("3. Tambah Data Karyawan");
            System.out.println("4. Update Data Karyawan");
            System.out.println("5. Print Gaji Karyawan");
            System.out.println("6. Hitung Gaji Karyawan");
            System.out.println("99. Keluar");
            System.out.print("Ketik : ");
            menu = scan.nextInt();
            scan.nextLine();
            switch (menu) {
                case 1:
                    tampil();
                    break;
                case 2:
                    tampilDataKaryawan();
                    break;
                case 3:
                    tambahDataKaryawan();
                    break;
                case 4:
                    // System.out.println("Update Karyawan hadir di update selanjutnya");
                    for (int i = 1; i < listNamaKaryawan.length; i++) {
                        System.out.println((i) + ". " + listNamaKaryawan[i]);
                    }
                    System.out.print("Masukkan no urut/index karyawan : ");
                    int indexKaryawan = scan.nextInt();
                    scan.nextLine();
                    updateDataKaryawan(indexKaryawan);
                    break;
                case 5:
                    printGajiKaryawan();
                    break;
                case 6:
                    hitungGaji();
                    break;
                case 99:
                    isOut = true;
                    break;

                default:
                    break;
            }

        } while (!isOut);
    }

    ///Menu Karyawan
    public static void chooseMenuKaryawan(int indexKaryawan) {
        boolean isOut = false;

        do {
            int menu = 0;

            System.out.println();
            System.out.println("==================================================");
            System.out.println("            Sistem Aplikasi Kepegawaian");
            System.out.println("               Masuk Sebagai Karyawan");
            System.out.println("==================================================");
            System.out.println("1. Tampilkan Data Karyawan");
            System.out.println("2. Tampilkan Gaji Karyawan");
            System.out.println("99. Keluar");
            System.out.print("Ketik : ");
            menu = scan.nextInt();
            scan.nextLine();
            switch (menu) {
                case 1:
                    System.out.println("---- Menampilkan Data Diri ----");
                    System.out.println("Nama: " + listNamaKaryawan[indexKaryawan]);
                    int indexJK = indexJabatanKaryawan[indexKaryawan];
                    System.out.println("Jabatan : " + listJabatanKaryawan[indexJK]);
                    break;
                case 2:
                    System.out.println("---- Menampilkan Gaji Keseluruhan ----");
                    for (int j = 0; j < riwayatGaji[indexKaryawan].length; j++) {
                        System.out.println("Bulan " + bulan[j] + " : " + riwayatGaji[indexKaryawan][j]);
                    }
                    break;
                case 99:
                    isOut = true;
                    break;

                default:
                    break;
            }

        } while (!isOut);
    }

    ///Menghitung total Gaji Karyawan 
    static double hitungGajiKaryawan(int indexKaryawan) {
        int indexJabatan = indexJabatanKaryawan[indexKaryawan];
        double tunjangan = percentageTunjanganJabatan[indexJabatan];

        double gaji = listGajiJabatan[indexJabatan];

        double hitungGaji = ((tunjangan / 100) * gaji) + gaji;

        return hitungGaji;
    }

    ///Menampilkan Gaji Karyawan keseluruhan
    static void printGajiKaryawan() {
        for (int i = 1; i < listNamaKaryawan.length; i++) {
            System.out.println("==================================================");
            System.out.println("              Gaji Karyawan Keseluruhan");
            System.out.println("==================================================");
            // System.out.println(i + " = i");
            System.out.println("Nama : " + listNamaKaryawan[i]);
            int indexJabatan = indexJabatanKaryawan[i];

            System.out.println("Jabatan : " + listJabatanKaryawan[indexJabatan]);

            for (int j = 0; j < riwayatGaji[i].length; j++) {
                System.out.println("Bulan "  + bulan[j % 12] + " : " + riwayatGaji[i][j]);
            }
            System.out.println();
            System.out.println("==================================================");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username, password;
        int counter = 1;

        do {
            System.out.println();
            System.out.println("==================================================");
            System.out.println("                      LOGIN");
            System.out.println("==================================================");
            System.out.print("Masukkan Username : ");
            username = scan.nextLine();
            System.out.print("Masukkan Password : ");
            password = scan.nextLine();

            int result = login(username, password);
            if (result < 0) {
                System.out.println("Login Gagal!");
                counter++;
            } else if (username.equals("admin")) {
                counter = 4;
                chooseMenuAdmin();
            } else {
                counter = 4;
                chooseMenuKaryawan(result);
            }
        } while (counter <= 3);

        scan.close();

    }
}
