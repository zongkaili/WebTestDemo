package com.kelly.web;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kelly.web.webview.WebActivity;
import com.kelly.web.webview.WebViewActivity;

/**
 * Created by zongkaili on 2017/6/28.
 */

public class RecyclerAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private String[] mContents;
    public RecyclerAdapter(Context context, String[] contents){
        mContext = context;
        mContents = contents;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder)holder;
        viewHolder.mTxtContent.setText(mContents[position]);
        viewHolder.mTxtContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                WebViewActivity.loadUrl(v.getContext(), "https://github.com/zongkaili?tab=stars", "加载中...");
                mContext.startActivity(new Intent(mContext, WebActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mContents.length;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView mTxtContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTxtContent = (TextView) itemView.findViewById(R.id.tv_content);
        }

    }

}
