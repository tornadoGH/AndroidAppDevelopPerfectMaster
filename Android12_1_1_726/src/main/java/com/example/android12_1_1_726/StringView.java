package com.example.android12_1_1_726;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by kooka on 2016/07/22.
 */
public class StringView extends View {

    public StringView( Context context )
    {
        super( context );
        StringView.this.setBackgroundColor(Color.LTGRAY);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setAntiAlias( true );
        paint.setTextSize( 32 );
        paint.setColor( Color.rgb( 255, 0, 0 ));
        canvas.drawText("32spで表示", 0, 64, paint );

        paint.setTextSize( 48 );
        paint.setColor( Color.rgb( 0, 0, 255 ));
        canvas.drawText("48spで表示", 0, 64*2, paint );

        paint.setTextSize( 64 );
        paint.setColor( Color.rgb( 0, 0, 0 ));
        canvas.drawText("64spで表示", 0, 64*3, paint );

        paint.setTextSize( 48 );
        paint.setColor( Color.rgb( 0, 0, 0 ));
        canvas.drawText("画面サイズ:" + getWidth() + "*" + getHeight(), 0, 64*4, paint );
    }
}
