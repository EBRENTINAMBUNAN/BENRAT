📌 Remote Administration Tool (RAT) dengan Java (Server) & Python (Client)

📖 Deskripsi

Proyek ini adalah Remote Administration Tool (RAT) sederhana yang memungkinkan komunikasi antara PC (Server - Java) dan HP (Client - Python) melalui jaringan menggunakan Socket Programming.

Fitur utama dalam proyek ini meliputi:

📂 Transfer file dari HP ke PC dan sebaliknya

🎮 Remote command execution (menjalankan perintah di HP dari PC)

🔄 Koneksi real-time antara server dan client

🚀 Persyaratan

🖥 Di PC (Server - Java)

Java Development Kit (JDK) versi 8 ke atas

Terminal atau Command Prompt

📱 Di HP (Client - Python - Termux)

Termux (di Android)

Python 3.x

🔧 Instalasi & Penggunaan

1️⃣ Jalankan Server di PC

Clone repository ini atau salin file RATServer.java

Compile dan jalankan server:

javac RATServer.java
java RATServer

2️⃣ Jalankan Client di HP (Termux)

Install Python di Termux:

pkg install python

Download client script client.py dan jalankan:

python client.py

3️⃣ Gunakan Perintah di Server

Perintah

Fungsi

ls

Menampilkan daftar file di HP

getfile /sdcard/file.txt

Mengambil file dari HP ke PC

sendfile C:/Users/file.txt

Mengirim file dari PC ke HP

exit

Menutup koneksi

🎯 Contoh Penggunaan

📂 Ambil file dari HP ke PC

getfile /sdcard/Download/file.txt

📤 Kirim file dari PC ke HP

sendfile C:/Users/Nama/file.txt

🔍 Jalankan perintah di HP

ls /sdcard

⚠️ Disclaimer

🚨 Proyek ini dibuat untuk tujuan edukasi. Jangan gunakan untuk kegiatan ilegal atau tanpa izin. Penggunaan di luar kepentingan edukasi menjadi tanggung jawab pengguna.

📜 Lisensi

Proyek ini berada di bawah lisensi MIT. Silakan gunakan dan modifikasi sesuai kebutuhan!

