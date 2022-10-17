package com.pab1.formlombaprogramming;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ConfirmActivity extends AppCompatActivity {
        DatePickerDialog datePickerDialog;
        TextView tvNama, tvJk, tvNoWhatsapp, tvAlamat, tvTanggal;
        Button btnTanggal, btnKonfirmasi;

        String nama, jk, noWhatsapp, alamat, choosenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvNama = findViewById(R.id.tv_nama);
        tvJk = findViewById(R.id.tv_jk);
        tvNoWhatsapp = findViewById(R.id.tv_no_wa);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvTanggal = findViewById(R.id.tv_tanggal);

        btnTanggal = findViewById(R.id.btn_tanggal);
        btnKonfirmasi = findViewById(R.id.btn_konfirmasi);

        //ambil Intent yang dikirim oleh MainActivity
        Intent terima = getIntent();
        nama = terima.getStringExtra("varNama");
                jk = terima.getStringExtra("varJenisKelamin");
                        noWhatsapp = terima.getStringExtra("varNo");
                            alamat = terima.getStringExtra("varAlamat");

                        //set variabel
        tvNama.setText(nama);
        tvJk.setText(jk);
        tvNoWhatsapp.setText(noWhatsapp);
        tvAlamat.setText(alamat);

        btnTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Calendar newCalender = Calendar.getInstance();
                datePickerDialog = new DatePickerDialog(ConfirmActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String tahun = Integer.toString(year);
                        String bulan = Integer.toString(month + 1);
                        String tanggal = Integer.toString(dayOfMonth);
                        choosenDate = tanggal + " / " + bulan + " / " + tahun;
                        tvTanggal.setText(choosenDate);

                    }
                }, newCalender.get(Calendar.YEAR), newCalender.get(Calendar.MONTH), newCalender.get(Calendar.DAY_OF_MONTH));
//tampilkan datePickerDialog
datePickerDialog.show();


            }
        });

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(ConfirmActivity.this);
                dialog.setTitle("Perhatian");
                dialog.setMessage("Apakah data anda sudah benar?");

                //button positif
                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ConfirmActivity.this, "Terima kasih, Pendaftaran Anda berhasil.",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                //button negatif
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                //tampilkan dialog
                dialog.show();
            }
        });

    }
}