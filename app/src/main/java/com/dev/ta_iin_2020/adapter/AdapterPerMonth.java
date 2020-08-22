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
        if (position < 9) {
            holder.nomonth.setText("0" + (position + 1) + "");
        } else {
            holder.nomonth.setText((position + 1) + "");
        }

        if (position % 2 != 0) {
            holder.linear2.setBackgroundColor(Color.parseColor("#cccccc"));
        }
        holder.dateRowPerMonth.setText(dataBeans.get(position).getBulan() + "-" + dataBeans.get(position).getTahun());
        holder.TotalRowPerMonth.setText("Rp. " + dataBeans.get(position).getTotal());
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
        @BindView(R.id.nomonth)
        TextView nomonth;
        @BindView(R.id.linear2)
        LinearLayout linear2;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
