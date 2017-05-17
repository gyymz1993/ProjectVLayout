package com.youngport.app.projectvlayout.VLayout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.youngport.app.projectvlayout.Adapter.DelegateRecyclerAdapter;
import com.youngport.app.projectvlayout.R;

/**
 * Created by admin on 2017/5/16.
 */

public class SingleLayoutHelperActivity extends Activity{

    private RecyclerView recyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        DelegateAdapter adapter =new DelegateAdapter(manager, true);

        adapter.addAdapter(initSingleLayout(this));
        recyclerview.setAdapter(adapter);
    }

    public static DelegateRecyclerAdapter initSingleLayout(Context context){
        SingleLayoutHelper singleLayoutHelper=new SingleLayoutHelper();
        //设置布局底部与下个布局的间隔
        singleLayoutHelper.setMarginBottom(20);
        //设置间距
        singleLayoutHelper.setMargin(20,20,20,20);
        DelegateRecyclerAdapter delegateRecyclerAdapter=new DelegateRecyclerAdapter(context,singleLayoutHelper);
        return delegateRecyclerAdapter;
    }


}
