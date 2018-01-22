package com.noes.adeyds.jualbuku;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
private TextView dtlJudul, dtlHarga, dtlEmail;
private ImageView dtlCover;
private Button btnOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dtlCover = findViewById(R.id.img_dtlCover);
        dtlJudul = findViewById(R.id.tv_dtlJudul);
        dtlEmail = findViewById(R.id.tv_dtlEmail);
        dtlHarga = findViewById(R.id.tv_dtlHarga);

        btnOrder=findViewById(R.id.btn_order);

        Intent fromMain = getIntent();
        dtlJudul.setText(fromMain.getStringExtra("judulExtra"));
        dtlEmail.setText(fromMain.getStringExtra("emailExtra"));

        dtlHarga.setText(String.valueOf(
                fromMain.getIntExtra("hargaExtra",0)));
        dtlCover.setImageResource(
                fromMain.getIntExtra("coverExtra",0));

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pesan = "Beli buku " +dtlJudul.getText();



                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"+dtlEmail.getText()));
                //intent.setType("text/plain");
                //intent.putExtra(Intent.EXTRA_EMAIL,dtlEmail.getText());
                    intent.putExtra(Intent.EXTRA_SUBJECT, "BELI BUKU");
                intent.putExtra(Intent.EXTRA_TEXT,pesan );
try {
    startActivity(Intent.createChooser(intent, "Send Email"));
}
catch (ActivityNotFoundException ex){
    Toast.makeText(DetailActivity.this, "Tidak ada aplikasi email", Toast.LENGTH_SHORT).show();
}

            }
        });

    }
}
