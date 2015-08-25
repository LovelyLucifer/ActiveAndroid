package com.ycp.activeandroid.adapter;

import java.util.ArrayList;

import com.ycp.activeandroid.R;
import com.ycp.activeandroid.model.Student;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class StuAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<Student> list;

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	public StuAdapter(Context context, ArrayList<Student> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder = null;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = View.inflate(context, R.layout.item_stu, null);
			holder.btn_del = (Button) convertView.findViewById(R.id.btn_del);
			holder.tv = (TextView) convertView.findViewById(R.id.tv);
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		final Student stu = list.get(position);
		holder.tv.setText(stu.name+"\n"+stu.age);
		holder.btn_del.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				stu.delete();
				list.remove(position);
				notifyDataSetChanged();
			}
		});
		
		return convertView;
	}

	class ViewHolder{
		Button btn_del;
		TextView tv;
	}
}
