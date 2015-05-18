package com.grupa.vjeverica.artjourney;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SliderElement {
    private ImageView iv;
    private ViewGroup.MarginLayoutParams params;
    private int index, position;

    public SliderElement(Context context, int resId, int index, int position){
        iv = new ImageView(context);
        iv.setImageResource(resId);
        iv.setId(R.id.imagePart1+index);
        this.index=index;
        this.position = position;
    }

    public void setParams(float width, float height, int size){
        params = (ViewGroup.MarginLayoutParams) iv.getLayoutParams();
        params.width=(int) ((width * (1 - 0.06f - (0.02f * (size - 1)))) / size);
        params.height=params.width;
        params.rightMargin = 0;
        params.leftMargin = (int) ((width * 0.03f) + ((position / size) * params.width) + ((position / size) * width * 0.02f));
        params.topMargin = (int) (((position % size) * width * 0.02f) + ((height - width) / 2) + ((position % size) * params.width));
        iv.setLayoutParams(params);
    }

    public void updateParams(float width, float height, int size){
        params.leftMargin = (int) ((width * 0.03f) + ((position / size) * params.width) + ((position / size) * width * 0.02f));
        params.topMargin = (int) (((position % size) * width * 0.02f) + ((height - width) / 2) + ((position % size) * params.width));
        iv.setLayoutParams(params);
    }

    public ImageView getIv() {
        return iv;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public int getIndex() {
        return index;
    }

    public ViewGroup.MarginLayoutParams getParams(){
        return params;
    }

    public void setListener(View.OnTouchListener tl){
        iv.setOnTouchListener(tl);
    }
}
