package com.example.modernandroid.feature.greeting

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.modernandroid.data.model.Mahasiswa

class GreetingViewModel : ViewModel() {

    // State 1: Menyimpan teks yang sedang diketik pengguna di kotak input
    var inputNama by mutableStateOf("")
        private set

    // State 2: Menyimpan hasil data Mahasiswa setelah tombol diklik (awalnya kosong/null)
    var dataMahasiswa by mutableStateOf<Mahasiswa?>(null)
        private set

    // Fungsi ini dipanggil setiap kali pengguna mengetik 1 huruf di kotak input
    fun onNamaChanged(namaBaru: String) {
        inputNama = namaBaru
    }

    // Fungsi ini dipanggil saat tombol "Sapa Saya" diklik
    fun sapaMahasiswa() {
        if (inputNama.isNotBlank()) {
            dataMahasiswa = Mahasiswa(nama = inputNama)
        }
    }
}