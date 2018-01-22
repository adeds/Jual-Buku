package com.noes.adeyds.jualbuku;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adeyds on 1/21/2018.
 */

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.HolderBuku> {
    //ini
    private Context context;
    private ArrayList<Buku> bukuArrayList;

    public BukuAdapter(Context context, ArrayList<Buku> bukuArrayList) {
        this.context = context;
        this.bukuArrayList = bukuArrayList;
    }
//sampai ini

    @Override
    public HolderBuku onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);

        return new HolderBuku(view);
    }

    @Override
    public void onBindViewHolder(HolderBuku holder, final int position) {
        holder.tvJudul.setText(bukuArrayList.get(position).getJudul());
        holder.tvHarga.setText(String.valueOf(bukuArrayList.get(position).getHarga()));
        holder.tvEmail.setText(bukuArrayList.get(position).getEmail());
        holder.imgCover.setImageResource(bukuArrayList.get(position).getCover());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDetail = new Intent(v.getContext(), DetailActivity.class);

                toDetail.putExtra("judulExtra", bukuArrayList.get(position).getJudul());
                toDetail.putExtra("hargaExtra", bukuArrayList.get(position).getHarga());
                toDetail.putExtra("emailExtra", bukuArrayList.get(position).getEmail());
                toDetail.putExtra("coverExtra", bukuArrayList.get(position).getCover());

                v.getContext().startActivity(toDetail);

            }
        });

    }

    @Override
    public int getItemCount() {
        return bukuArrayList.size();  //ini diedit
    }

    class HolderBuku extends RecyclerView.ViewHolder {
        TextView tvJudul, tvHarga, tvEmail;
        ImageView imgCover;
        CardView container;

        public HolderBuku(View itemView) {

            super(itemView);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvHarga = itemView.findViewById(R.id.tv_harga);
            imgCover = itemView.findViewById(R.id.img_cover);
            container = itemView.findViewById(R.id.container);

        }
    }
}
