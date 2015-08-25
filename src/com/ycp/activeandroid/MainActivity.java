package com.ycp.activeandroid;

import java.util.ArrayList;
import java.util.List;

import com.activeandroid.query.Select;
import com.ycp.activeandroid.adapter.StuAdapter;
import com.ycp.activeandroid.model.Student;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener{

	private Button add_btn;
	private ListView lv;
	private StuAdapter adapter;
	private ArrayList<Student> list = new ArrayList<Student>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	
	private void initView() {
		add_btn = (Button) findViewById(R.id.add);
		lv = (ListView) findViewById(R.id.lv);
		adapter = new StuAdapter(this, list);
		lv.setAdapter(adapter);
		List<Student> stus = new Select().from(Student.class).execute();
		for(int i=0;i<stus.size();i++){
			Student stu = stus.get(i);
			stu.name = "ycp";
			stu.save();
		}
		list.addAll(stus);
		for(int i=0;i<8;i++){
			Student stu = new Student();
			stu.name = "lilei"+i;
			stu.age = 10 +i;
			stu.save();
			list.add(stu); 
		}
		adapter.notifyDataSetChanged();
		 add_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Student stu = new Student();
				stu.name = "lucy";
				stu.age = 10 ;
				stu.save();
				list.add(stu);
				adapter.notifyDataSetChanged();
			}
		});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()){
		
		}
	}

}
