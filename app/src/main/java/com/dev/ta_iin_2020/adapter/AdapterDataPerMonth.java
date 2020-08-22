package com.dev.ta_iin_2020.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.ta_iin_2020.R;
import com.dev.ta_iin_2020.model.DetailPerMonth;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDataPerMonth extends RecyclerView.Adapter<AdapterDataPerMonth.ViewHolder> {


    private Context context;
    private List<DetailPerMonth.DataBean> dataBeans;

    public AdapterDataPerMonth(Context context, List<DetailPerMonth.DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_data_per_month, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position < 9) {
            holder.noDetailMonth.setText("0" + (position + 1) + "");
        } else {
            holder.noDetailMonth.setText((position + 1) + "");
        }

        if (position % 2 != 0) {
            holder.linearMonth.setBackgroundColor(Color.parseColor("#cccccc"));
        }

        holder.nominalDetailMonth.setText("Rp. " + dataBeans.get(position).getNominal());
        holder.banyakDetailMonth.setText(dataBeans.get(position).getBanyak());
        holder.tanggalDetailMonth.setText(dataBeans.get(position).getTahun() + "-" + dataBeans.get(position).getBulan());
    }

    @Override
    public int getItemCount() {
        return (dataBeans != null) ? dataBeans.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.noDetailMonth)
        TextView noDetailMonth;
        @BindView(R.id.nominalDetailMonth)
        TextView nominalDetailMonth;
        @BindView(R.id.banyakDetailMonth)
        TextView banyakDetailMonth;
        @BindView(R.id.tanggalDetailMonth)
        TextView tanggalDetailMonth;
        @BindView(R.id.linearMonth)
        LinearLayout linearMonth;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
