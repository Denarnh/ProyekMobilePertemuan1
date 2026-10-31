package com.example.modernandroid.feature.greeting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun GreetingScreen(
    viewModel: GreetingViewModel = viewModel(),
    onNavigateToProfile: () -> Unit = {}
) {
    // Column menyusun elemen dari atas ke bawah secara berurutan
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Modern Android Development",
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "Arsitektur MVVM & Package by Feature",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 1. Kotak Input Nama
        OutlinedTextField(
            value = viewModel.inputNama,
            onValueChange = { viewModel.onNamaChanged(it) },
            label = { Text("Masukkan Nama Anda") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 2. Tombol Sapa
        Button(
            onClick = { viewModel.sapaMahasiswa() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sapa Saya")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 3. Tombol Profil (Persiapan untuk Pertemuan 2)
        OutlinedButton(
            onClick = onNavigateToProfile,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ke Halaman Profil ->")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 4. Kartu Sapaan (Hanya muncul kalau dataMahasiswa sudah tidak kosong)
        viewModel.dataMahasiswa?.let { mahasiswa ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Selamat Datang, ${mahasiswa.nama}!",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Peran: ${mahasiswa.peran}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Tampilan Awal Greeting Screen"
)
@Composable
fun GreetingScreenPreview() {
    MaterialTheme {
        GreetingScreen()
    }
}