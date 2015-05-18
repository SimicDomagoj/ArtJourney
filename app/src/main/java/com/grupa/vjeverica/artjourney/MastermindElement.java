package com.grupa.vjeverica.artjourney;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MastermindElement {
    private ImageView iv;
    private ViewGroup.MarginLayoutParams params;
    private int index, dotColor, resource;

    public MastermindElement(Context context, int resId, int index, int dotColor){
        iv = new ImageView(context);
        resource = resId;
        iv.setImageResource(resource+dotColor);
        iv.setId(R.id.mastermindDot1+index);
        this.index=index;
        this.dotColor = dotColor;
    }

    public void setParams(float width, float height, int brOfDots){
        params = (ViewGroup.MarginLayoutParams) iv.getLayoutParams();
        params.width=(int) (width * 0.1f);
        params.height=params.width;
        params.leftMargin = (int) (((6-brOfDots) * width * 0.05f) + (width * 0.03f) + (params.width * index) + (index * width * 0.01f));
        params.topMargin = (int)(height * 0.8f);
        iv.setLayoutParams(params);
    }

    public void incIndex(int brOfElements){
        dotColor++;
        dotColor%=brOfElements;
        iv.setImageResource(resource+dotColor);
    }

    public int getIndex() {
        return index;
    }

    public int getDotColor() {
        return dotColor;
    }

    public ImageView getIv() {
        return iv;
    }

    public ViewGroup.MarginLayoutParams getParams(){
        return params;
    }

    public void setListener(View.OnClickListener cl){
        iv.setOnClickListener(cl);
    }

    public void setTopMargin(int location){
        params.topMargin = location;
    }
}
