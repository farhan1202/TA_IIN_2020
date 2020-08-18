package com.dev.ta_iin_2020;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.ta_iin_2020.adapter.AdapterPerDay;
import com.dev.ta_iin_2020.adapter.AdapterPerMonth;
import com.dev.ta_iin_2020.model.PerDay;
import com.dev.ta_iin_2020.model.PerMonth;
import com.dev.ta_iin_2020.utils.LoadingDialog;
import com.dev.ta_iin_2020.utils.PrefManager;
import com.dev.ta_iin_2020.utils.apihelper.ApiInterface;
import com.dev.ta_iin_2020.utils.apihelper.UtilsApi;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.totalInfaq)
    TextView totalInfaq;
    @BindView(R.id.banyak2)
    TextView banyak2;
    @BindView(R.id.banyak5)
    TextView banyak5;
    @BindView(R.id.banyak10)
    TextView banyak10;
    @BindView(R.id.btndetailDay)
    LinearLayout btndetailDay;
    @BindView(R.id.recyclerDataMonth)
    RecyclerView recyclerDataMonth;
    @BindView(R.id.btndetailMonth)
    LinearLayout btndetailMonth;
    @BindView(R.id.recyclerDataDay)
    RecyclerView recyclerDataDay;

    Context context;
    ApiInterface apiInterface;
    LoadingDialog loadingDialog;

    List<PerDay.DataBean> dataBeans;
    List<PerMonth.DataBean> dataBeans1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;
        apiInterface = UtilsApi.getApiService();
        loadingDialog = new LoadingDialog(context);

        getData();
    }

    private void getData() {
        loadingDialog.startLoadingDialog();
        apiInterface.getData().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("status").equals("200")){
                            loadingDialog.dismissLoadingDialog();
                            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                            JSONArray jsonArray = jsonObject1.getJSONArray("detail");

                            totalInfaq.setText(jsonObject1.getString("total_infaq"));
                            banyak2.setText(jsonArray.getJSONObject(0).getString("banyak"));
                            banyak5.setText(jsonArray.getJSONObject(1).getString("banyak"));
                            banyak10.setText(jsonArray.getJSONObject(2).getString("banyak"));

                            getdataPerDay();
                            getdataPerMonth();
                        }else{
                            loadingDialog.dismissLoadingDialog();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(context, "Internet Problem", Toast.LENGTH_SHORT).show();
                loadingDialog.dismissLoadingDialog();
            }
        });
    }

    private void getdataPerMonth() {
        apiInterface.getPerMonth().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("status").equals("200")){
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            
                            dataBeans1 = new ArrayList<>();
                            Gson gson = new Gson();
                            for (int i = 0; i < jsonArray.length() ; i++){
                                PerMonth.DataBean dataBean = gson.fromJson(jsonArray.get(i).toString(), PerMonth.DataBean.class);
                                dataBeans1.add(dataBean);
                            }

                            AdapterPerMonth adapterPerMonth = new AdapterPerMonth(context, dataBeans1);
                            recyclerDataMonth.setLayoutManager(new LinearLayoutManager(context));
                            recyclerDataMonth.setAdapter(adapterPerMonth);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(context, "Connection Problem", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getdataPerDay() {
        apiInterface.getPerDay().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("status").equals("200")){
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            Gson gson = new Gson();
                            dataBeans = new ArrayList<>();
                            
                            for (int i = 0 ; i < jsonArray.length() ; i++){
                                PerDay.DataBean dataBean = gson.fromJson(jsonArray.get(i).toString(), PerDay.DataBean.class);
                                dataBeans.add(dataBean);
                            }

                            AdapterPerDay adapterPerDay = new AdapterPerDay(context, dataBeans);
                            recyclerDataDay.setLayoutManager(new LinearLayoutManager(context));
                            recyclerDataDay.setAdapter(adapterPerDay);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(context, "Internet Problem", Toast.LENGTH_SHORT).show();
            }
        });
    }
}