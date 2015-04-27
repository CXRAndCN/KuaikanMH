package com.example.administrator.kuaikanmh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.kuaikanmh.BitmapHelper;
import com.example.administrator.kuaikanmh.R;
import com.example.administrator.kuaikanmh.bean.Comics;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaa on 15-4-25.
 */
public class RecommenAdapter extends BaseAdapter{
    private Context context;
    private List<Comics> list;

    public RecommenAdapter(Context context, List<Comics> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView=LayoutInflater.from(context).inflate(R.layout.main_list,parent,false);
            convertView.setTag(new ViewHolder(convertView));
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        Comics comics = list.get(position);
        holder.title.setText(comics.getTitle());
        holder.title_author.setText(comics.getTopic().getTitle());
        holder.txt_praise.setText(comics.getLikes_count()+"");
        holder.txt_comment.setText(comics.getComments_count()+"");
        BitmapHelper.getUtils().display(holder.image,comics.getCover_image_url());
        return convertView;
    }

    public void addAll(List<Comics> list) {
        list.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        list=new ArrayList<Comics>();
        notifyDataSetChanged();
    }

    public static class ViewHolder{
        @ViewInject(R.id.title)
        private TextView title;
        @ViewInject(R.id.title_author)
        private TextView title_author;
        @ViewInject(R.id.txt_praise)
        private TextView txt_praise;
        @ViewInject(R.id.txt_comment)
        private TextView txt_comment;
        @ViewInject(R.id.image)
        private ImageView image;

        public ViewHolder(View itemView){
            ViewUtils.inject(this,itemView);
        }
    }
}
