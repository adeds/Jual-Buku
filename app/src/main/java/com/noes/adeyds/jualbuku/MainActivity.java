package com.noes.adeyds.jualbuku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Buku> bukuArrayList;
    private BukuAdapter adapter;

    private RecyclerView rcList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcList = (RecyclerView) findViewById(R.id.rc_list);

        bukuArrayList =new ArrayList<>();

        arrBuku();

        adapter=new BukuAdapter(getApplicationContext() , bukuArrayList);


        rcList.setLayoutManager(new LinearLayoutManager(this));

        rcList.setAdapter(adapter);


    }

    private void arrBuku() {
        String arrJudul[] = {"Bahasa Indo",
                "Biologi",
                "Hukum",
                "Seni Budaya",
                "TIK",
                "Matematika"};

        String arrEmail[] = {
                "airlangga@gmail.com",
                "admin@bse.com",
                "admin@andi.com",
                "gabriel@suplier.com",
                "tukang@kirim.com",
                "bakul@buku.com"

        };

        int arrHarga[] = {
                50000, 75000, 100000, 45000, 200000, 120000

        };

        int arrCover[] = {
                R.drawable.bindo,
                R.drawable.biologi,
                R.drawable.hukum,
                R.drawable.seni_budaya,
                R.drawable.tik,
                R.drawable.matematika

        };
        for (int i = 0; i < arrCover.length; i++) {
            Buku buku= new Buku();
            buku.setJudul(arrJudul[i]);
            buku.setHarga(arrHarga[i]);
            buku.setEmail(arrEmail[i]);
            buku.setCover(arrCover[i]);
            bukuArrayList.add(buku);

        }

    }

}
