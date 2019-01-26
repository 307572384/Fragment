package com.beta.fragment.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.beta.fragment.Fragment.F_WXFragment_1;
import com.beta.fragment.Fragment.F_WXFragment_2;
import com.beta.fragment.Fragment.F_WXFragment_3;
import com.beta.fragment.Fragment.F_WXFragment_4;
import com.beta.fragment.R;

/**
 * Created by Kevein on 2019/1/26.12:17
 */
//仿微信底部菜单栏的Fragment
public class FWXActivity extends Activity implements View.OnClickListener{
	//定位Fragment
	private Fragment weixinFragment   = new F_WXFragment_1();
	private Fragment contractFragment = new F_WXFragment_2();
	private Fragment findFragment     = new F_WXFragment_3();
	private Fragment meFragment       = new F_WXFragment_4();

	// tab中的四个帧布局
	private FrameLayout findFrameLayout, meFrameLayout, contractFrameLayout, weixinFrameLayout;

	// tab中的四个帧布局中的四个图片组件
	private ImageView findImageView, meImageView, contractImageView,weixinImageView;

	// tab中的四个帧布局中的四个图片对应文字
	private TextView findTextView, meTextView, contractTextView,weixinTextView;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.f_wx_fragment_main);
		// 初始化组件
		initView();

		// 初始化按钮单击事件
		initClickEvent();

		// 初始化所有fragment
		initFragment();

	}
	//初始化所有的Fragment
	private void initFragment()
	{
		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
		if(!weixinFragment.isAdded())
		{
			fragmentTransaction.add(R.id.content,weixinFragment);
			fragmentTransaction.hide(weixinFragment);
		}
		if(!contractFragment.isAdded())
		{
			fragmentTransaction.add(R.id.content,contractFragment);
			fragmentTransaction.hide(contractFragment);
		}
		if(!findFragment.isAdded())
		{
			fragmentTransaction.add(R.id.content,findFragment);
			fragmentTransaction.hide(findFragment);

		}
		if(!meFragment.isAdded())
		{
			fragmentTransaction.add(R.id.content,meFragment);
			fragmentTransaction.hide(meFragment);
		}
		hideAllFragment(fragmentTransaction);
		// 默认显示第一个fragment
		fragmentTransaction.show(weixinFragment);
		fragmentTransaction.commit();
	}
	/**
	 * 隐藏所有fragment
	 *
	 * @param fragmentTransaction
	 */
	private void hideAllFragment(FragmentTransaction fragmentTransaction) {
		fragmentTransaction.hide(weixinFragment);
		fragmentTransaction.hide(contractFragment);
		fragmentTransaction.hide(findFragment);
		fragmentTransaction.hide(meFragment);
	}
	private void initClickEvent() {
		findFrameLayout.setOnClickListener(this);
		meFrameLayout.setOnClickListener(this);
		contractFrameLayout.setOnClickListener(this);
		weixinFrameLayout.setOnClickListener(this);
	}
	//初始化组件
	private void initView() {
		findFrameLayout = (FrameLayout) findViewById(R.id.findLayout);
		meFrameLayout = (FrameLayout) findViewById(R.id.meLayout);
		contractFrameLayout = (FrameLayout) findViewById(R.id.contractLayout);
		weixinFrameLayout = (FrameLayout) findViewById(R.id.weixinLayout);

		findImageView = (ImageView) findViewById(R.id.findImageView);
		meImageView = (ImageView) findViewById(R.id.meImageView);
		contractImageView = (ImageView) findViewById(R.id.contractImageView);
		weixinImageView = (ImageView) findViewById(R.id.weixinImageView);

		findTextView = (TextView) findViewById(R.id.findTextView);
		meTextView = (TextView) findViewById(R.id.meTextView);
		contractTextView = (TextView) findViewById(R.id.contractTextView);
		weixinTextView = (TextView) findViewById(R.id.weixinTextView);
	}

	@Override
	public void onClick(View v) {
				switch (v.getId())
				{
					case R.id.weixinLayout:
						// 点击微信tab
						clickTab(weixinFragment);
						break;

					case R.id.contractLayout:
						// 点击联系人tab
						clickTab(contractFragment);
						break;

					case R.id.findLayout:
						// 点击发现tab
						clickTab(findFragment);
						break;

					case R.id.meLayout:
						// 点击我tab
						clickTab(meFragment);
						break;

					default:
						break;
				}
	}

	/**
	 * 点击下面的Tab按钮
	 *
	 * @param tabFragment
	 */
	private void clickTab(Fragment tabFragment)
	{
		//清除上次选中状态
		clearSeleted();

		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

		//隐藏所有Fragment
		hideAllFragment(fragmentTransaction);
		//显示该Fragment
		fragmentTransaction.show(tabFragment);
		//提交事务
		fragmentTransaction.commit();
		//改变tab的样式设置为选中状态
		changeTabStyle(tabFragment);
	}
	/**
	 * 清除上次选中状态
	 */
	private void clearSeleted() {
		if (!weixinFragment.isHidden()) {
			weixinImageView.setImageResource(R.drawable.ic_1);
			weixinTextView.setTextColor(Color.parseColor("#999999"));
		}

		if (!contractFragment.isHidden()) {
			contractImageView.setImageResource(R.drawable.ic_2);
			contractTextView.setTextColor(Color.parseColor("#999999"));
		}

		if (!findFragment.isHidden()) {
			findImageView.setImageResource(R.drawable.ic_3);
			findTextView.setTextColor(Color.parseColor("#999999"));
		}

		if (!meFragment.isHidden()) {
			meImageView.setImageResource(R.drawable.ic_4);
			meTextView.setTextColor(Color.parseColor("#999999"));
		}
	}
	/**
	 * 根据Fragment的状态改变样式
	 */
	private void changeTabStyle(Fragment tabFragment) {
		if (tabFragment instanceof F_WXFragment_1) {
			weixinImageView.setImageResource(R.drawable.ic_1);
			weixinTextView.setTextColor(Color.parseColor("#45C01A"));
		}

		if (tabFragment instanceof F_WXFragment_2) {
			contractImageView.setImageResource(R.drawable.ic_2);
			contractTextView.setTextColor(Color.parseColor("#45C01A"));
		}

		if (tabFragment instanceof F_WXFragment_3) {
			findImageView.setImageResource(R.drawable.ic_3);
			findTextView.setTextColor(Color.parseColor("#45C01A"));
		}

		if (tabFragment instanceof F_WXFragment_4) {
			meImageView.setImageResource(R.drawable.ic_4);
			meTextView.setTextColor(Color.parseColor("#45C01A"));
		}
	}
}
