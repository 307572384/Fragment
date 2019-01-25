package com.beta.fragment.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beta.fragment.R;
import com.beta.fragment.bean.MessageSend;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Kevein on 2019/1/25.12:49
 */

public class BE_Fragment_1 extends Fragment implements View.OnClickListener{

	private View     view;
	/**
	 * Hello blank fragment
	 */
	private TextView mTv1;
	private Context  mContext;

	public BE_Fragment_1() {
		// Required empty public constructor
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = getActivity();
	}

	@Override
	public void onResume() {
		super.onResume();
		EventBus.getDefault().register(this);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void Fragment2ButtonClicked(MessageSend msgToSend) {
		mTv1.setText("点击了1后2给1传递的数据"+msgToSend.getMessage());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.be_fragment_1, container, false);
		initView(view);
		return view;
	}


	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	private void initView(View view) {
		mTv1 = (TextView) view.findViewById(R.id.be_tx_1);
		mTv1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.be_tx_1:
				EventBus.getDefault().post("fragment1");//告诉MainActivity,fragment1中的按钮点击了
				break;
		}
	}
}
