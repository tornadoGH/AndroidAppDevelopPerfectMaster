package com.example.android9_1_5_544;

import android.app.Dialog;
import android.inputmethodservice.ExtractEditText;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ExtractEditText varResultText = ( ExtractEditText )findViewById( R.id.textResult );

        final Button buttonDialog = ( Button )findViewById( R.id.buttonDialog );
        buttonDialog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //  Dialogクラスのインスタンス生成
                final Dialog varDialog = new Dialog( MainActivity.this );
                //  Dialogのインスタンスにビューを追加
                varDialog.setContentView( R.layout.dialog_set );
                //  Dialogにタイトル設定
                varDialog.setTitle("Original Dialog");
                //  Dialog表示
                varDialog.show();

                //  ダイアログのボタンを取得
                Button buttonOk = ( Button )varDialog.findViewById( R.id.buttonOk );
                //  リスナー設定
                buttonOk.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {

                        //  ダイアログを消去
                        varDialog.dismiss();
                        //  エディットテキストへ出力
                        varResultText.setText("OKボタンクリック");
                    }
                });
            }
        });

        final Button buttonClear = ( Button ) findViewById( R.id.buttonClear );
        buttonClear.setOnClickListener( new View.OnClickListener()
        {
            public void onClick( View view )
            {
                varResultText.getEditableText().clear();
            }
        });

    }
}
