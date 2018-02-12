package dao.cn.com.alb.view.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import dao.cn.com.alb.R;
import dao.cn.com.alb.view.bean.LogsDetail;

/**
 * @name dao.cn.com.alb.view.adapter
 * @class name：Alb
 * @class describe
 * @anthor uway QQ:343251588
 * @time 2018/2/11 11:30
 * @change uway
 * @chang 2018/2/11 11:30
 * @class describe
 */


 public class UrlAdapter extends BaseAdapter {
    private List<LogsDetail> list;
    private Context context;

    public UrlAdapter(Context context, List<LogsDetail> list) {
        this.context = context;
        this.list = list;
    }

    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup arg2) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.info_item, null);


            holder.time = (TextView) convertView.findViewById(R.id.time);
            holder.type = (TextView) convertView.findViewById(R.id.type);
            holder.num = (TextView) convertView.findViewById(R.id.num);
            holder.adress = (TextView) convertView.findViewById(R.id.adress);





            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String nums=position+1+"";
        holder.num.setText(nums);
        holder.time.setText(list.get(position).getCreateTime());
        holder.type.setText(list.get(position).getEnilTypeName());
        holder.adress.setText(list.get(position).getUrl());



        return convertView;
    }
    class ViewHolder {
        TextView num;
        TextView  time;
        TextView  type;
        TextView  adress;


    }

}
