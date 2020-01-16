package com.intentfuzzer;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by Administrator on 2018/8/21.
 */

public class AboutDialog extends Dialog {


    private Context context;

    public AboutDialog(Context context) {
        super(context);
        // TODO Auto-generated constructor stub

        this.context = context;
    }

    public AboutDialog(Context context, int theme){
        super(context, theme);
        this.context = context;


    }

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog);


    }

}
