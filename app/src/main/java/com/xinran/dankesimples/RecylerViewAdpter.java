package com.xinran.dankesimples;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by houqixin on 2017/11/13.
 */

public class RecylerViewAdpter extends RecyclerView.Adapter<RecylerViewAdpter.ViewHolder>{

    public List<String> mDatas;
    public LayoutInflater mInflater;

    public RecylerViewAdpter(List<String> datas, Context context){
        mDatas=datas;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyerview_item,
                parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mTv = (TextView) view
                .findViewById(R.id.text_view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final String str=mDatas.get(position);
        holder.mTv.setText(str);
        holder.mTv.setTag(position);
        holder.mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tag= (int) view.getTag();
                if(tag==position&&mOnItemClickListner!=null){
                    mOnItemClickListner.onItemClick(str,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDatas==null?0:mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTv;

        public ViewHolder(View itemView) {
            super(itemView);
        }

    }
    private OnItemClickListner mOnItemClickListner;
    public void setOnItemClickListner(OnItemClickListner onItemClickListner){
        this.mOnItemClickListner=onItemClickListner;

    }

    public interface  OnItemClickListner{
        void onItemClick(String str,int point);
    }

}
