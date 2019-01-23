package com.beta.fragment.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.beta.fragment.R;

/*静态添加Fragment1*/
public class TActivity extends FragmentActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.t_fragment_main);
	}
}
