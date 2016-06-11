package com.example.y.slideview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * by y on 2016/6/7.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<String> data;
    private Context context;

    public RecyclerViewAdapter(List<String> data) {
        this.data = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("RtlHardcoded")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setData(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final View view;

        public ViewHolder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.tv);
            view = itemView.findViewById(R.id.view);

        }

        @SuppressLint("RtlHardcoded")
        public void setData(String data) {

            tv.setText(data);

            switch (data) {

                case "1":

                    tv.setGravity(Gravity.CENTER);
                    tv.setBackgroundColor(Color.WHITE);
                    view.setVisibility(View.VISIBLE);

                    break;

                default:

                    tv.setGravity(Gravity.LEFT);
                    view.setVisibility(View.GONE);
                    //noinspection deprecation
                    tv.setBackgroundColor(context.getResources().getColor(R.color.colorItemBackgound));

                    break;

            }

        }
    }
}
