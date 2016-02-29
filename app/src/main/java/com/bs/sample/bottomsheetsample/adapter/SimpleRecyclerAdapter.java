package com.bs.sample.bottomsheetsample.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bs.sample.bottomsheetsample.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by feifan on 16/2/29.
 * Contacts me:404619986@qq.com
 */
public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.SimpleHolder> {

    private Context context;

    public SimpleRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SimpleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_simple, parent, false);
        return new SimpleHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleHolder holder, int position) {
        int r = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        holder.textView.setText(String.valueOf(r) + "," + String.valueOf(g) + "," + String.valueOf(b));
        holder.textView.setBackgroundColor(Color.rgb(r, g, b));
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class SimpleHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.text)
        TextView textView;

        public SimpleHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
