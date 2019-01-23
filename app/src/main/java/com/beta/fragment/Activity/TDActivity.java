package com.beta.fragment.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.beta.fragment.Fragment.T_Fragment_1;
import com.beta.fragment.Fragment.T_Fragment_2;
import com.beta.fragment.R;

//动态删除、添加、替换、显示、隐藏Fragment
public class TDActivity extends FragmentActivity implements View.OnClickListener {
	private Button      btn_show_fragment1;
	private Button      btn_show_fragment2;
	private FrameLayout fragment_container;
	private Button      add_frag1;
	private Button      add_frag2;
	private Button      remove_frag1;
	private Button      remove_frag2;
	private Button      btn_repalce_frag1;
	private Button      btn_hide_frag1;
	private Button      btn_show_frag1;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.t_fragment_main_dt);
		initView();

	}

	private void addFragment(Fragment fragment, String tag) {
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.fragment_container, fragment, tag);
		transaction.commit();
	}

	private void initView() {
		btn_show_fragment1 = (Button) findViewById(R.id.btn_show_fragment1);
		btn_show_fragment2 = (Button) findViewById(R.id.btn_show_fragment2);
		fragment_container = (FrameLayout) findViewById(R.id.fragment_container);

		btn_show_fragment1.setOnClickListener(this);
		btn_show_fragment2.setOnClickListener(this);
		add_frag1 = (Button) findViewById(R.id.add_frag1);
		add_frag1.setOnClickListener(this);
		add_frag2 = (Button) findViewById(R.id.add_frag2);
		add_frag2.setOnClickListener(this);
		remove_frag1 = (Button) findViewById(R.id.remove_frag1);
		remove_frag1.setOnClickListener(this);
		remove_frag2 = (Button) findViewById(R.id.remove_frag2);
		remove_frag2.setOnClickListener(this);
		btn_repalce_frag1 = (Button) findViewById(R.id.btn_repalce_frag1);
		btn_repalce_frag1.setOnClickListener(this);
		btn_hide_frag1 = (Button) findViewById(R.id.btn_hide_frag1);
		btn_hide_frag1.setOnClickListener(this);
		btn_show_frag1 = (Button) findViewById(R.id.btn_show_frag1);
		btn_show_frag1.setOnClickListener(this);
	}

	private void removeFragment2() {
		FragmentManager manager = getSupportFragmentManager();
		Fragment fragment = manager.findFragmentByTag("fragment2");
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.remove(fragment);
		transaction.commit();
		/*因为fragment1在fragment2的下方所以我们如果移除的的时候不用tag的话那么我们将不会看到移除的效果*/
	}

	private void removeFragment1() {
		FragmentManager manager = getSupportFragmentManager();
		Fragment fragment = manager.findFragmentByTag("fragment1");
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.remove(fragment);
		transaction.commit();
	}

	private void replaceFragment1() {
		FragmentManager manager = getSupportFragmentManager();
		T_Fragment_2 fragment2 = new T_Fragment_2();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.fragment_container, fragment2);
		transaction.commit();
	}
	private void hideFragment1()
	{

		FragmentManager manager = getSupportFragmentManager();
		//创建一个Fragment管理器
		Fragment fragment1 = manager.findFragmentByTag("fragment1");
		//绑定fragment TAG 为Fragment1
		FragmentTransaction transaction = manager.beginTransaction();
		//初始化传输
		transaction.hide(fragment1);
		//隐藏fragment1
		transaction.addToBackStack("hide fragment1");
		//回滚到隐藏fragment1
		transaction.commit();
		//开始事件
	}
	private void showFragment1()
	{

		FragmentManager manager = getSupportFragmentManager();
		//创建一个Fragment管理器
		Fragment fragment1 = manager.findFragmentByTag("fragment1");
		//绑定fragment TAG 为Fragment1
		FragmentTransaction transaction = manager.beginTransaction();
		//初始化传输
		transaction.show(fragment1);
		//隐藏fragment1
		transaction.addToBackStack("show fragment1");
		//回滚到隐藏fragment1
		transaction.commit();
		//开始事件
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_show_fragment1:
				FragmentManager manager = getSupportFragmentManager();
				FragmentTransaction transaction = manager.beginTransaction();
				T_Fragment_1 fragment1 = new T_Fragment_1();//新建一个Fragment对象
				transaction.add(R.id.fragment_container, fragment1);
				transaction.commit();
				break;
			case R.id.btn_show_fragment2:
				FragmentManager manager2 = getSupportFragmentManager();
				FragmentTransaction transaction2 = manager2.beginTransaction();
				T_Fragment_2 fragment2 = new T_Fragment_2();//新建一个Fragment对象
				transaction2.add(R.id.fragment_container, fragment2);
				transaction2.commit();
				break;
			case R.id.add_frag1:

				T_Fragment_1 fragmenta1 = new T_Fragment_1();
				addFragment(fragmenta1, "fragment1");

				break;
			case R.id.add_frag2:

				T_Fragment_2 fragmenta2 = new T_Fragment_2();
				addFragment(fragmenta2, "fragment2");
				break;
			case R.id.remove_frag1:

				T_Fragment_1 fragment_1 = new T_Fragment_1();
				removeFragment1();
				break;
			case R.id.remove_frag2:
				T_Fragment_2 fragment_2 = new T_Fragment_2();
				removeFragment2();
				break;
			case R.id.btn_repalce_frag1:
				replaceFragment1();
				break;
			case R.id.btn_hide_frag1:
				hideFragment1();
				break;
			case R.id.btn_show_frag1:
				showFragment1();
				break;
		}
	}
}
