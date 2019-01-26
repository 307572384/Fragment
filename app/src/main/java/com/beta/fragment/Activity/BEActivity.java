package com.beta.fragment.Activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.beta.fragment.Fragment.BE_Fragment_1;
import com.beta.fragment.Fragment.BE_Fragment_2;
import com.beta.fragment.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

//实现Eventbus对Fragment的消息传输
public class BEActivity extends AppCompatActivity {
	private FragmentManager mFragmentManager;
	private BE_Fragment_1   be_fragment1;
	private BE_Fragment_2   be_fragment2;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用bundle进行Fragment传输
		if (savedInstanceState == null) {
			be_fragment1 = new BE_Fragment_1();
			be_fragment2 = new BE_Fragment_2();

		} else {//生成一个key以便后续调用
			be_fragment1 = (BE_Fragment_1) mFragmentManager.getFragment(savedInstanceState, "fragment1");
			be_fragment2 = (BE_Fragment_2) mFragmentManager.getFragment(savedInstanceState, "fragment2");

		}
		mFragmentManager = getSupportFragmentManager();
		setContentView(R.layout.be_fragment_main);
		initFragmentSelected(0);
	}

	/*注册和取消注册代码*/
	@Override
	protected void onResume() {
		super.onResume();
		EventBus.getDefault().register(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void FragmentButtonClicked(String str) {
		switch (str) {
			case "fragment1":
				Toast.makeText(getApplicationContext(), "fragment1点击", Toast.LENGTH_LONG).show();
				initFragmentSelected(1);//展示fragment2界面
				break;
			case "fragment2":
				Toast.makeText(getApplicationContext(), "fragment2点击", Toast.LENGTH_LONG).show();
				initFragmentSelected(0);//展示fragment1界面
				break;//

			default:
				break;
		}
	}

	/**
	 * 初始化fragment
	 *
	 * @param i
	 */
	private void initFragmentSelected(int i) {
		FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
		hindFragments(fragmentTransaction);
		switch (i) {
			case 0:
				if (!be_fragment1.isAdded()) {
					fragmentTransaction.add(R.id.be_Fa, be_fragment1, "navitionFragment1");
				}
				fragmentTransaction.show(be_fragment1);
				break;
			case 1:
				if (!be_fragment2.isAdded()) {
					fragmentTransaction.add(R.id.be_Fa, be_fragment2, "navitionFragment1");
				}
				fragmentTransaction.show(be_fragment2);
				break;
			default:
				break;
		}
		fragmentTransaction.commit();
	}

	/**
	 * 隐藏fragment
	 *
	 * @param fragmentTransaction
	 */
	private void hindFragments(FragmentTransaction fragmentTransaction) {
		if (be_fragment1 != null) {
			fragmentTransaction.hide(be_fragment1);
		}
		if (be_fragment2 != null) {
			fragmentTransaction.hide(be_fragment2);
		}
	}
}
