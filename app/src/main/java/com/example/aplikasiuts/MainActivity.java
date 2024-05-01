package com.example.aplikasiuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSubmit;
    EditText etnik, etnama, etemail, ettempatlahir, etalamat;
    Spinner spKelamin;
    CheckBox c1, c2, c3, c4, c5;
    RadioGroup kewarganegaraan;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etnik = findViewById(R.id.nik);
        etnama = findViewById(R.id.nama);
        etemail = findViewById(R.id.email);
        ettempatlahir = findViewById(R.id.tempLahir);
        etalamat = findViewById(R.id.alamat);
        spKelamin = findViewById(R.id.kelamin);
        output = findViewById(R.id.hasil);
        c1 = findViewById(R.id.ck1);
        c2 = findViewById(R.id.ck2);
        c3 = findViewById(R.id.ck3);
        c4 = findViewById(R.id.ck4);
        c5 = findViewById(R.id.ck5);
        kewarganegaraan = findViewById(R.id.RdGrup);
        btnSubmit = findViewById(R.id.submit);

        String[] kelamin_list = {"Laki-Laki", "Perempuan"};
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,kelamin_list);
        spKelamin.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder output = new StringBuilder();
                output.append("NIK : "+etnik.getText().toString()+"\n");
                output.append("Nama : "+etnama.getText().toString()+"\n");
                output.append("Email : "+etemail.getText().toString()+"\n");
                output.append("Tempat Lahir : "+ettempatlahir.getText().toString()+"\n");
                output.append("Alamat : "+etalamat.getText().toString()+"\n");
                int kewarga = kewarganegaraan.getCheckedRadioButtonId();
                if (kewarga == R.id.wni){
                    output.append("Kewarganegaraan : WNI \n");
                }
                else {
                    output.append("Kewarganegaraan : WNA \n");
                }

                output.append("Bidang Kompentensi : ");

                if (c1.isChecked()){
                    output.append("Development dan IT");
                }
                if (c1.isChecked()) {
                    output.append("AI Services");
                }
                if (c1.isChecked()) {
                    output.append("Design Creative");
                }
                if (c1.isChecked()) {
                    output.append("Writing");
                }
                if (c1.isChecked()) {
                    output.append("Finance 7 Acounting");
                }
                output.append("\n");
                output.append("Jenis Kelamin : "+spKelamin.getSelectedItem()+" \n");

                Intent x = new Intent(MainActivity.this, Terima_Data2.class);
                x.putExtra("hasil_data", output.toString());
                startActivity(x);
            }


        });
    }
}