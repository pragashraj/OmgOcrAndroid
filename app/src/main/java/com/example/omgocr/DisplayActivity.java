package com.example.omgocr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayActivity extends AppCompatActivity {
    ImageView imageView;
    Bundle bundle;
    Uri uri;
    ProgressDialog progressDialog;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        imageView=(ImageView)findViewById(R.id.imageDisplay);
        textView=(TextView)findViewById(R.id.resultView);
        bundle=getIntent().getExtras();
        uri=Uri.parse(bundle.getString("uri"));
        imageView.setImageURI(uri);

    }
    public void onViewBtnClick(View v)
    {
        try{
            progressDialog=new ProgressDialog(this);
            progressDialog.setMessage("Please wait.......");
            progressDialog.setCancelable(false);
            progressDialog.show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.dismiss();
                    doCall();
                }
            },3000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    public void doCall()
    {
        Api api=ApiClient.getApiClient().create(Api.class);
        Call<List<OcrText>> call=api.resultsText();
        call.enqueue(new Callback<List<OcrText>>() {
            @Override
            public void onResponse(Call<List<OcrText>> call, Response<List<OcrText>> response) {
                if(!response.isSuccessful()){
                    textView.setText(response.code());
                }else{
                    List<OcrText> ocrText=response.body();
                    for(OcrText text:ocrText)
                    {
                        String content=" ";
                        content+=text.getTextresult();
                        textView.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<OcrText>> call, Throwable t) {

            }
        });
    }
}
