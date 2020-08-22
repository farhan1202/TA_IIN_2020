package com.dev.ta_iin_2020;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.ta_iin_2020.adapter.AdapterDataPerMonth;
import com.dev.ta_iin_2020.model.DetailPerMonth;
import com.dev.ta_iin_2020.utils.LoadingDialog;
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

public class DetailDataMonthActivity extends AppCompatActivity {

    @BindView(R.id.toolbarData2)
    Toolbar toolbarData2;
    @BindView(R.id.tabelHeader2)
    TableLayout tabelHeader2;
    @BindView(R.id.recyclerDetailDataMonth)
    RecyclerView recyclerDetailDataMonth;

    ApiInterface apiInterface;
    Context context;
    LoadingDialog loadingDialog;
    List<DetailPerMonth.DataBean> dataBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data_month);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarData2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail");

        apiInterface = UtilsApi.getApiService();
        context = this;
        loadingDialog = new LoadingDialog(context);

        fetchData();
    }

    private void fetchData() {
        loadingDialog.startLoadingDialog();
        apiInterface.getDetailMonth().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("status").equals("200")){
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            loadingDialog.dismissLoadingDialog();

                            dataBeans = new ArrayList<>();
                            Gson gson = new Gson();

                            for (int i = 0 ; i < jsonArray.length() ; i++){
                                DetailPerMonth.DataBean dataBean = gson.fromJson(jsonArray.getJSONObject(i).toString(), DetailPerMonth.DataBean.class);
                                dataBeans.add(dataBean);
                            }

                            AdapterDataPerMonth adapterDataPerMonth = new AdapterDataPerMonth(context, dataBeans);
                            recyclerDetailDataMonth.setAdapter(adapterDataPerMonth);
                            recyclerDetailDataMonth.setLayoutManager(new LinearLayoutManager(context));
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
                loadingDialog.dismissLoadingDialog();
                Toast.makeText(context, "Internet Problem", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}