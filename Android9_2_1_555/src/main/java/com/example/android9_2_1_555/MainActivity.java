package com.example.android9_2_1_555;

import android.app.ProgressDialog;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = ( Button )findViewById( R.id.button );
        button.setOnClickListener( new View.OnClickListener()
        {
            public void onClick( View view )
            {
                final ProgressDialog progress = new ProgressDialog( MainActivity.this );
                progress.setTitle("Show this progress");
                progress.setMessage("Wait for a while...");
                progress.setProgressStyle( ProgressDialog.STYLE_HORIZONTAL );
                progress.setCancelable( true );
                progress.setMax( 100 );     //  プログレスバーの最大値
                progress.show();

                /*
                    引数１　onFinishを呼び出すまでの時間（ミリ秒）
                    引数２　onTickが呼び出される間隔（ミリ秒）
                 */
                CountDownTimer countDownTimer = new CountDownTimer( 10000, 100 )
                {
                    //  引数 amount … このタイマー（クラス）が終了するまでの残り時間
                    public void onTick( long amount )
                    {
                        //  プログレスバーの状態更新
                        progress.setProgress(( int )(( 10000-amount)/100 ));
                        Log.d("amount", String.format("%d:%d", amount, ( int )(( 10000-amount)/100 )));
                    }
                    public void onFinish()
                    {
                        //  プログレスダイアログ終了
                        progress.dismiss();
                    }
                };
                countDownTimer.start();
            }
        });
    }
}
