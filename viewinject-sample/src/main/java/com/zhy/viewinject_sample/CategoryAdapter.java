package com.zhy.viewinject_sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.ioc.Bind;
import com.zhy.ioc.ViewInjector;

import java.util.List;


/**
 * Created by zhy on 16/4/12.
 */
public class CategoryAdapter extends ArrayAdapter<String>
{
    private LayoutInflater mInflater;
    private Context mContext;

    public CategoryAdapter(Context context, List<String> objects)
    {
        super(context, -1, objects);
        mContext = context;

        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.item_category, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.idTitleTv.setText(getItem(position));

        return convertView;
    }


    static class ViewHolder
    {
        @Bind(R.id.id_icon_iv)
        ImageView idIconIv;
        @Bind(R.id.id_title_tv)
        TextView idTitleTv;

        ViewHolder(View view)
        {
            ViewInjector.injectView(this,view);
        }
    }
}
