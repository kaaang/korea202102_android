package com.koreait.graphicapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PhotoView extends View {
    Bitmap[] bitmaps = new Bitmap[8];//이미지 배열 준비
    int index=0;


    public PhotoView(Context context,AttributeSet attrs) {
        super(context, attrs);
        bitmaps[0]= BitmapFactory.decodeResource(context.getResources(),R.drawable.img0);
        bitmaps[1]= BitmapFactory.decodeResource(context.getResources(),R.drawable.img1);
        bitmaps[2]= BitmapFactory.decodeResource(context.getResources(),R.drawable.img2);
        bitmaps[3]= BitmapFactory.decodeResource(context.getResources(),R.drawable.img3);
        bitmaps[4]= BitmapFactory.decodeResource(context.getResources(),R.drawable.img4);
        bitmaps[5]= BitmapFactory.decodeResource(context.getResources(),R.drawable.img5);
        bitmaps[7]= BitmapFactory.decodeResource(context.getResources(),R.drawable.img6);

        for(int i=0;i<bitmaps.length;i++){
            bitmaps[i]=bitmaps[i].createScaledBitmap(bitmaps[i],600,550,true);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmaps[index],50,50,null);
    }
    
}
