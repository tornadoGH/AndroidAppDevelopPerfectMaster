package com.example.android9_2_1_551;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int showTime = 10000;
        final ProgressDialog progressDialog = new ProgressDialog( MainActivity.this );

        //  プログレスのスタイルを設定
        progressDialog.setProgressStyle( ProgressDialog.STYLE_SPINNER );

        //  キャンセルを可能にする
        progressDialog.setCancelable( true );

        //  タイトル設定
        progressDialog.setTitle("実行中");

        //  メッセージ設定
        progressDialog.setMessage("10秒後にプログレスダイアログを終了");
        Handler handler = new Handler();
        handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, showTime );

        progressDialog.show();
    }
}
