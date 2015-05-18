package com.grupa.vjeverica.artjourney;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import com.metaio.sdk.MetaioDebug;
import com.metaio.sdk.jni.IGeometry;
import com.metaio.sdk.jni.IMetaioSDKCallback;
import com.metaio.sdk.jni.Vector3d;
import com.metaio.tools.io.AssetsManager;


public class showPictureAR extends ARViewActivity{
    private String mTrackingFile;

    private IGeometry mMan;

    @Override
    protected void onStart() {
        super.onStart();
        final Bundle b = getIntent().getExtras();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(showPictureAR.this,b.getString("size"),Toast.LENGTH_LONG).show();
            }
        }, 2000);
    }

    @Override
    protected int getGUILayout() {
        return R.layout.activity_show_picture_ar;
    }

    @Override
    protected IMetaioSDKCallback getMetaioSDKCallbackHandler() {
        return null;
    }

    @Override
    protected void loadContents() {
        Bundle b = getIntent().getExtras();

        mTrackingFile = AssetsManager.getAssetPath(this,"metaio/TrackingData_Marker.xml");

        boolean result = metaioSDK.setTrackingConfiguration(mTrackingFile);
        MetaioDebug.log("Tracking data loaded " + result );

        String modelPath = AssetsManager.getAssetPath(this, b.getString("res"));
        if(modelPath != null){
            mMan = metaioSDK.createGeometry(modelPath);
            if(mMan != null){
                mMan.setScale(new Vector3d(1.f, 1.0f, 1.f));
                mMan.setVisible(true);
                MetaioDebug.log("LoadedGeometry" + modelPath);
            }

        }
    }

    @Override
    protected void onGeometryTouched(IGeometry geometry) {

    }
}
