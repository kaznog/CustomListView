package com.kaznog.as.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kaznog on 2014/09/23.
 */
public class ModelAdapter extends ArrayAdapter<Model> {
    public ModelAdapter(Context context, int resource, List<Model> objects) {
        super(context, R.layout.list_row, objects);
    }
    private class ViewHolder {
        TextView title;
        Switch togglrswitch;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
            TextView title = (TextView)convertView.findViewById(R.id.title);
            Switch toggleswitch = (Switch)convertView.findViewById(R.id.toggleswitch);
            toggleswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    int pos = (Integer)compoundButton.getTag();
                    getItem(pos).setToggleswitch(isChecked);
                }
            });
            holder.title = title;
            holder.togglrswitch = toggleswitch;

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        Model entry = getItem(position);
        holder.title.setText(entry.getTitle());
        holder.togglrswitch.setTag(position);
        holder.togglrswitch.setChecked(entry.isToggleswitch());
        return convertView;
    }
}
