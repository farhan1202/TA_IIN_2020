package com.dev.ta_iin_2020.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.ta_iin_2020.R;
import com.dev.ta_iin_2020.model.PerMonth;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPerMonth extends RecyclerView.Adapter<AdapterPerMonth.viewHolder> {

    private Context context;
    private List<PerMonth.DataBean> dataBeans;

    public AdapterPerMonth(Context context, List<PerMonth.DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_per_month, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.dateRowPerMonth.setText(dataBeans.get(position).getBulan()+"-"+dataBeans.get(position).getTahun());
        holder.TotalRowPerMonth.setText(dataBeans.get(position).getTotal());
    }

    @Override
    public int getItemCount() {
        return (dataBeans != null) ? dataBeans.size() : 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.dateRowPerMonth)
        TextView dateRowPerMonth;
        @BindView(R.id.TotalRowPerMonth)
        TextView TotalRowPerMonth;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
