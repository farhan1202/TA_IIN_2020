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
import com.dev.ta_iin_2020.model.PerDay;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPerDay extends RecyclerView.Adapter<AdapterPerDay.viewHolder> {


    private Context context;
    private List<PerDay.DataBean> dataBeanList;

    public AdapterPerDay(Context context, List<PerDay.DataBean> dataBeanList) {
        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_per_day, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        if (position < 9) {
            holder.noday.setText("0" + (position + 1) + "");
        } else {
            holder.noday.setText((position + 1) + "");
        }

        if (position % 2 != 0) {
            holder.linear1.setBackgroundColor(Color.parseColor("#cccccc"));
        }
        holder.dateRowPerDay.setText(dataBeanList.get(position).getTanggal() + "-" + dataBeanList.get(position).getBulan() + "-" + dataBeanList.get(position).getTahun());
        holder.TotalRowPerDay.setText("Rp." + dataBeanList.get(position).getTotal());
    }

    @Override
    public int getItemCount() {
        return (dataBeanList != null) ? dataBeanList.size() : 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.dateRowPerDay)
        TextView dateRowPerDay;
        @BindView(R.id.TotalRowPerDay)
        TextView TotalRowPerDay;
        @BindView(R.id.noday)
        TextView noday;
        @BindView(R.id.linear1)
        LinearLayout linear1;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
