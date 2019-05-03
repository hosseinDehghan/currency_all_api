package com.example.currency_api_down;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleTone {
    private  static VolleySingleTone mInstance;
    private RequestQueue requestQueue;
    private Context mCtx;
    private VolleySingleTone(Context context){
        mCtx=context;
     requestQueue=getRequestQue();
    }
    public RequestQueue getRequestQue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized VolleySingleTone getmInstance(Context context){

        if (mInstance==null){
            mInstance=new VolleySingleTone(context);
        }
        return mInstance;

    }
public <T> void addToRequestQue(Request<T> request){
        requestQueue.add(request);
}


}
