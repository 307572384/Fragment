package com.beta.fragment.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beta.fragment.R;
import com.beta.fragment.bean.MessageSend;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Kevein on 2019/1/25.12:49
 */

public class BE_Fragment_2 extends Fragment implements View.OnClickListener {

	private View     view;
	/**
	 * Hello blank fragment
	 */
	private TextView mTv2;
	private Context  mContext;

	/**
	 * Hello blank fragment
	 */

	public BE_Fragment_2() {
		// Required empty public constructor
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.be_fragment_2, container, false);
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


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.be_tx_2:
				EventBus.getDefault().post("fragment2");
				EventBus.getDefault().post(new MessageSend("，我是fragment2，我给你发个信息"));
				break;
		}
	}

	private void initView(View view) {
		mTv2 = (TextView) view.findViewById(R.id.be_tx_2);
		mTv2.setOnClickListener(this);
	}
}
