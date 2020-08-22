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
import com.dev.ta_iin_2020.model.DetailPerDay;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDataPerDay extends RecyclerView.Adapter<AdapterDataPerDay.ViewHolder> {



    private Context context;
    private List<DetailPerDay.DataBean> dataBeans;

    public AdapterDataPerDay(Context context, List<DetailPerDay.DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_detail_per_day, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position < 9) {
            holder.noDetailDay.setText("0" + (position + 1) + "");
        } else {
            holder.noDetailDay.setText((position + 1) + "");
        }

        if (position % 2 != 0) {
            holder.linearDay.setBackgroundColor(Color.parseColor("#cccccc"));
        }

        holder.nominalDetailDay.setText("Rp. " + dataBeans.get(position).getNominal());
        holder.banyakDetailDay.setText(dataBeans.get(position).getBanyak());
        holder.tanggalDetailDay.setText(dataBeans.get(position).getTahun() + "-" + dataBeans.get(position).getBulan() + "-" + dataBeans.get(position).getTanggal());
    }

    @Override
    public int getItemCount() {
        return (dataBeans != null) ? dataBeans.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.noDetailDay)
        TextView noDetailDay;
        @BindView(R.id.nominalDetailDay)
        TextView nominalDetailDay;
        @BindView(R.id.banyakDetailDay)
        TextView banyakDetailDay;
        @BindView(R.id.tanggalDetailDay)
        TextView tanggalDetailDay;
        @BindView(R.id.linearDay)
        LinearLayout linearDay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
