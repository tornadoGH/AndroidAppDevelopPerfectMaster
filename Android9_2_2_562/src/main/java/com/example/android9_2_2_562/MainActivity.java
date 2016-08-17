package com.example.android9_2_2_562;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private ProgressDialog progressDialog;
    private Thread thread;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = ( Button )findViewById( R.id.button );
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                handler = new Handler(MainActivity.this);

//              @Override
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        for( int i=0;i<100;i++ )
                        {
                            try {
                                Thread.sleep( 100 );    //  100ミリ秒スリープ
                            }
                            catch ( Exception e )
                            {
                                e.printStackTrace();
                            }
                            handler.sendEmptyMessage( 0 );  //  ハンドラーに0を送る
                        }
                        handler.sendEmptyMessage( 1 );  //  ハンドラーに1を送る
                        thread = null;  //  スレッド破棄
                    }
                };

                progressDialog = new ProgressDialog( MainActivity.this );

                progressDialog.setProgressStyle( ProgressDialog.STYLE_HORIZONTAL );

                progressDialog.setTitle( R.string.app_name );

                progressDialog.setMessage( getString( R.string.message ));

                progressDialog.setCancelable( false );  //  キャンセル無効

                progressDialog.setProgress( 0 );

                progressDialog.setMax( 100 );

                progressDialog.show();

                //  スレッドのインスタンスを生成
                thread = new Thread( runnable );
                //  スレッド開始
                thread.start();
            }
        });
    }

    public void OnPause()
    {
        //  アクティビティが裏に回った場合はスレッドを破棄
        handler.sendEmptyMessage( 1 );
        thread = null;
    }

    @Override
    public boolean handleMessage(Message msg )
    {
        switch ( msg.what )
        {
            case 0:
                //  プログレスバーの表示を１増やす
                progressDialog.incrementProgressBy( 1 );
                return true;
            case 1:
                //  プログレスバーを閉じる
                progressDialog.dismiss();
                return true;

            default:
                return false;
        }
    }
}
