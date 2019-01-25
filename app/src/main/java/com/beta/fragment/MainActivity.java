package com.beta.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.beta.fragment.Activity.BEActivity;
import com.beta.fragment.Activity.CZActivity;
import com.beta.fragment.Activity.TActivity;
import com.beta.fragment.Activity.TDActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private Button tf_1_low1;
	private Button tf_1_low2;
	private Button tf_low3;
	private Button tf_low4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		tf_1_low1 = (Button) findViewById(R.id.tf_1_low1);

		tf_1_low1.setOnClickListener(this);
		tf_1_low2 = (Button) findViewById(R.id.tf_1_low2);
		tf_1_low2.setOnClickListener(this);
		tf_low3 = (Button) findViewById(R.id.tf_low3);
		tf_low3.setOnClickListener(this);
		tf_low4 = (Button) findViewById(R.id.tf_low4);
		tf_low4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.tf_1_low1://动态Fragment
				Intent low1_intent = new Intent(MainActivity.this, TActivity.class);
				startActivity(low1_intent);
				break;
			case R.id.tf_1_low2://静态Fragment
				Intent low2_intent = new Intent(MainActivity.this, TDActivity.class);
				startActivity(low2_intent);
				break;

			case R.id.tf_low3:
				Intent low3_intent = new Intent(MainActivity.this, CZActivity.class);
				startActivity(low3_intent);
				break;
			case R.id.tf_low4://EventBus实现fragment之间数据通讯
				Intent low4_intent = new Intent(MainActivity.this, BEActivity.class);
				startActivity(low4_intent);
				break;
		}
	}
}
