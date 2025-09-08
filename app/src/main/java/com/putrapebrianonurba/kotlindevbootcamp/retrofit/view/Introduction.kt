package com.putrapebrianonurba.kotlindevbootcamp.retrofit.view

// Retrofit Bootcamp with MVVM
/*
Penjelasan untuk setiap materi pembelajaran
> Retrofit
Retrofit merupakan sebuah liblary yang dikembangkan oleh Square, Liblary Retrofit digunakan untuk menghandle komunikasi Client Server.
Retrofit biasanya digunakan untuk mengambil data (Fetching) dan mengririmkan data ke REST API atau server.

Retrofit dapat menghandle beberapa HTTP method, seperti GET, POST, PUT, DELETE, dll. Dan bekerja dengan baik bersama Gson Converter

> OKHTTP
OKHTTP merupakan sebuah HTTP Client liblary yang dibuat oleh Square, sama halnya dengan retrofit. OKHTTP merupakan dasar daripada penggunaan
Retrofit, Karena retrofit dibangun diatas OKHHTP. Maka dari itu di belakang layar, OKHTTP digunakan oleh Retrofit untuk melakukan request dan
response

> Gson Converter
Gson converter merupakan sebuah liblary yang mengubah bentuk response dalam json menjadi objek. Karena Retrofit hanya bisa melakukan
request dan response berupa raw data, nah raw data ini tidak dapat digunakan dalam aplikasi. Maka dari itu GSON Converter hadir sebagai solusi
atas permasalahan ini. Dimana mengubah bentuk raw data menjadi objek java/kotlin

> Coil (Coroutine Image Loader)
COIL merupakan sebuah liblary yang berbasis coroutines, yang digunakan untuk menampilkan gambar dalam aplikasi. Biasanya penggunaan coil berkaitan
erat dengan async image atau penampilan gambar ke UI berdasarkan link gambar yang diberikan.

Beberapa tahapan yang perlu diperhatikan ketika melakukan fetching Api
1. Menambahkan beberapa dependency pada gradle
    a. Retrofit
    b. Gson Converter
    c. OkHttp
    d. Coil
2. Menambahkan usesPermission pada android manifest, untuk koneksi internet dan koneksi internet dari wifi



GLOSARIUM
1. <uses-permission android:name="android.permission.INTERNET"/>
   a. Mengizinkan aplikasi untuk menggunakan akses internet baik WiFi atau seluler
   b. Kalo ini gaada, aplikasi tetap jalan. Namun, Request HTTP/HTTPS akan gagal
   Gak perduli kita pake internet source dari mana, intinya kalo ada internet, aplikasinya jalan.

2. <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
   a. Mengizinkan aplikasi untuk mengakses status koneksi WiFi
   b. Mengatur behavior yang ada pada aplikasi, misalkan: "Download file besar hanya menggunakan WiFi"






*/