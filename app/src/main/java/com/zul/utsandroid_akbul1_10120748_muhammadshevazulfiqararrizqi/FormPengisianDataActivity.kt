package com.zul.utsandroid_akbul1_10120748_muhammadshevazulfiqararrizqi

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class FormPengisianDataActivity : AppCompatActivity() {

    private lateinit var title: TextView
    private lateinit var imageInfo: ImageView
    private lateinit var radioGroupJenisTes: RadioGroup
    private lateinit var radioButtonRapidAntigen: RadioButton
    private lateinit var radioButtonPCR: RadioButton
    private lateinit var editTextTanggalTerkonfirmasi: EditText
    private lateinit var editTextNIK: EditText
    private lateinit var editTextNama: EditText
    private lateinit var editTextTanggalLahir: EditText
    private lateinit var radioGroupJenisKelamin: RadioGroup
    private lateinit var radioButtonLakiLaki: RadioButton
    private lateinit var radioButtonPerempuan: RadioButton
    private lateinit var radioGroupHubunganDenganAnda: RadioGroup
    private lateinit var radioButtonOrangtua: RadioButton
    private lateinit var radioButtonSuamiIstri: RadioButton
    private lateinit var radioButtonAnak: RadioButton
    private lateinit var radioButtonKerabatLainnya: RadioButton
    private lateinit var checkBoxConfirmation: CheckBox
    private lateinit var buttonSelanjutnya: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formpengisiandatascreen)

        // Inisialisasi views
        title = findViewById(R.id.title)
        imageInfo = findViewById(R.id.image_info)
        radioGroupJenisTes = findViewById(R.id.radio_group_jenis_tes)
        radioButtonRapidAntigen = findViewById(R.id.radio_button_rapid_antigen)
        radioButtonPCR = findViewById(R.id.radio_button_pcr)
        editTextTanggalTerkonfirmasi = findViewById(R.id.edit_text_tanggal_terkonfirmasi)
        editTextNIK = findViewById(R.id.edit_text_nik)
        editTextNama = findViewById(R.id.edit_text_nama)
        editTextTanggalLahir = findViewById(R.id.edit_text_tanggal_lahir)
        radioGroupJenisKelamin = findViewById(R.id.radio_group_jenis_kelamin)
        radioButtonLakiLaki = findViewById(R.id.radio_button_laki_laki)
        radioButtonPerempuan = findViewById(R.id.radio_button_perempuan)
        radioGroupHubunganDenganAnda = findViewById(R.id.radio_group_hubungan_dengan_anda)
        radioButtonOrangtua = findViewById(R.id.radio_button_orangtua)
        radioButtonSuamiIstri = findViewById(R.id.radio_button_suami_istri)
        radioButtonAnak = findViewById(R.id.radio_button_anak)
        radioButtonKerabatLainnya = findViewById(R.id.radio_button_kerabat_lainnya)
        checkBoxConfirmation = findViewById(R.id.check_box_confirmation)
        buttonSelanjutnya = findViewById(R.id.button_selanjutnya)

        val datePickerListener = { editText: EditText ->
            val calendar = Calendar.getInstance()
            DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(year, month, dayOfMonth)
                    val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.US)
                    editText.setText(dateFormat.format(selectedDate.time))
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        editTextTanggalTerkonfirmasi.setOnClickListener {
            datePickerListener(editTextTanggalTerkonfirmasi)
        }

        editTextTanggalLahir.setOnClickListener {
            datePickerListener(editTextTanggalLahir)
        }

        // Event handler untuk tombol Selanjutnya
        buttonSelanjutnya.setOnClickListener {
            onSelanjutnyaClicked()
        }
    }

    private fun onSelanjutnyaClicked() {
        if (!checkBoxConfirmation.isChecked) {
            Toast.makeText(this, "Anda harus menyetujui bahwa data yang Anda isikan adalah benar.", Toast.LENGTH_LONG).show()
            return
        }

        if (isDataValid()) {
            val intent = Intent(this, CekKembaliIsianDataScreen::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Silakan lengkapi semua isian terlebih dahulu.", Toast.LENGTH_LONG).show()
        }
    }

    private fun isDataValid(): Boolean {
        // Memeriksa apakah semua input sudah diisi
        return editTextTanggalTerkonfirmasi.text.isNotBlank() &&
                editTextNIK.text.isNotBlank() &&
                editTextNama.text.isNotBlank() &&
                editTextTanggalLahir.text.isNotBlank() &&
                radioGroupJenisTes.checkedRadioButtonId != -1 &&
                radioGroupJenisKelamin.checkedRadioButtonId != -1 &&
                radioGroupHubunganDenganAnda.checkedRadioButtonId != -1 &&
                checkBoxConfirmation.isChecked
    }
}
