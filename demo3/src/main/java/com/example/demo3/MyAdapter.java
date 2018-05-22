package com.example.demo3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        List<UserBean> mlist;
        private Context context ;
        private setOnItemClickListener listener;

    public MyAdapter(List<UserBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;

    }

    @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_login,parent,false);

            ViewHolder holder = new ViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

            ((ViewHolder)holder).name.setText(mlist.get(position).getName());
            ((ViewHolder)holder).img.setImageResource(mlist.get(position).getImg());
//            ((ViewHolder)holder).title.setText(list.get(position).getTitle());
//            Picasso.with(context).load(list.get(position).getThumbnail_pic_s()).into(((ViewHolder)holder).img);
//
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.setOnItemListener(position);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.setOnItemLongListener(position);
                    return false;
                }
            });
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            private final TextView name;
           // private final TextView title;
         private final ImageView img;

            public ViewHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.tv_name);
             //   title = itemView.findViewById(R.id.title);
              img = itemView.findViewById(R.id.img);
            }


        }


        public interface setOnItemClickListener{

         void    setOnItemListener(int position);
         void    setOnItemLongListener(int position);
        }


        public void setOnClickListener(setOnItemClickListener listener){
            this.listener=listener;
        }
    }


