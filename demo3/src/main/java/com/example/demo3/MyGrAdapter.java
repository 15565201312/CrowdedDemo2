package com.example.demo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class MyGrAdapter extends BaseAdapter{
private List<UserBean> users;
private Context context ;

    public MyGrAdapter(List<UserBean> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder vh = null;
        if (view==null){
            vh= new ViewHolder();


            view= LayoutInflater.from(context).inflate(R.layout.item_login,null);
            vh.name=view.findViewById(R.id.tv_name);
            vh.img=view.findViewById(R.id.img);

            view.setTag(vh);
        }else {
            vh= (ViewHolder) view.getTag();
        }

        vh.name.setText(users.get(i).getName());
        vh.img.setImageResource(users.get(i).getImg());

        return view;
    }


    class ViewHolder {
        TextView name;
        ImageView img;
    }
}
