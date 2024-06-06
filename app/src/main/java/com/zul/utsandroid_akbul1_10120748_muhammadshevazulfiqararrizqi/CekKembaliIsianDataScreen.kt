package com.zul.utsandroid_akbul1_10120748_muhammadshevazulfiqararrizqi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CekKembaliIsianDataScreen : AppCompatActivity() {

    private lateinit var textViewJenisTes: TextView
    private lateinit var textViewRapidAntigen: TextView
    private lateinit var textViewTanggalTerkonfirmasi: TextView
    private lateinit var textViewNIK: TextView
    private lateinit var textViewNama: TextView
    private lateinit var textViewTanggalLahir: TextView
    private lateinit var textViewJenisKelamin: TextView
    private lateinit var textViewHubunganDenganAnda: TextView
    private lateinit var buttonCekHasilTes: Button
    private lateinit var buttonUbah: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cekkembaliisiandatascreen)

        // Inisialisasi views
        textViewJenisTes = findViewById(R.id.text_view_jenis_tes)
        textViewRapidAntigen = findViewById(R.id.text_view_rapid_antigen)
        textViewTanggalTerkonfirmasi = findViewById(R.id.text_view_tanggal_terkonfirmasi_value)
        textViewNIK = findViewById(R.id.text_view_nik_value)
        textViewNama = findViewById(R.id.text_view_nama_value)
        textViewTanggalLahir = findViewById(R.id.text_view_tanggal_lahir_value)
        textViewJenisKelamin = findViewById(R.id.text_view_jenis_kelamin_value)
        textViewHubunganDenganAnda = findViewById(R.id.text_view_hubungan_dengan_anda_value)
        buttonCekHasilTes = findViewById(R.id.button_cek_hasil_tes)
        buttonUbah = findViewById(R.id.button_ubah)

        // Mengisi data dari intent (atau bisa juga dari Shared Preferences atau database)
        fillData()

        // Event handler untuk tombol "Cek Hasil Tes"
        buttonCekHasilTes.setOnClickListener {
            // Implementasi ketika tombol "Cek Hasil Tes" diklik
        }

        // Event handler untuk tombol "Ubah"
        buttonUbah.setOnClickListener {
            // Implementasi ketika tombol "Ubah" diklik
            // Anda dapat mengarahkan pengguna kembali ke layar FormPengisianData atau mengaktifkan mode edit langsung di layar ini
        }
    }

    private fun fillData() {
        // Implementasi untuk mengisi data dari intent (atau Shared Preferences atau database) ke TextViews
        // Contoh pengisian data sementara:
        textViewJenisTes.text = "Jenis Tes"
        textViewRapidAntigen.text = "Rapid Antigen"
        textViewTanggalTerkonfirmasi.text = "8 September 2021"
        textViewNIK.text = "7323456778941234"
        textViewNama.text = "Mohammad Reksa"
        textViewTanggalLahir.text = "2 November 1993"
        textViewJenisKelamin.text = "Laki-laki"
        textViewHubunganDenganAnda.text = "Orangtua"
    }
}
