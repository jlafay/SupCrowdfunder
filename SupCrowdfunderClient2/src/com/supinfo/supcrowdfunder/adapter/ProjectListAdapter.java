package com.supinfo.supcrowdfunder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.supinfo.supcrowdfunder.model.Project;

import java.util.List;

public class ProjectListAdapter extends BaseAdapter {

    private List<Project> projects;
    private LayoutInflater inflater;
    private int resource;
    private Context context;

    public ProjectListAdapter(Context context, int textViewResourceId, List<Project> projects) {
        this.projects = projects;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resource = textViewResourceId;
        this.context = context;
    }

    @Override
    public int getCount() {
        return projects.size();
    }

    @Override
    public Project getItem(int i) {
        return projects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parentView) {
        View view;
        TextView textView;

        if (convertView == null) {
            view = inflater.inflate(resource, parentView, false);
        } else {
            view = convertView;
        }
        textView = (TextView) view;
        Project project = getItem(i);
        textView.setText(project.getName() + "\n" +"Description :" + project.getShortContent() + "\n" + "Completion percent : " + project.getPercent() + "%");
        if (i % 2 == 0) {
            textView.setBackgroundColor(context.getResources().getColor(android.R.color.background_dark));
            textView.setTextColor(context.getResources().getColor(android.R.color.white));
        } else {
            textView.setBackgroundColor(context.getResources().getColor(android.R.color.background_light));
            textView.setTextColor(context.getResources().getColor(android.R.color.black));
        }
        return textView;
    }
}

