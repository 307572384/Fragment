package com.beta.fragment.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beta.fragment.R;

/**
 * Created by Kevein on 2019/1/23.21:53
 */

public class S_Fragment_2 extends Fragment {
	public static S_Fragment_2 newInstance(String text) {
		S_Fragment_2 fragmentx = new S_Fragment_2();
		Bundle args = new Bundle();
		args.putString("param", text);
		fragmentx.setArguments(args);
		return fragmentx;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.s_fragment_2, container, false);
		if (getArguments() != null) {
			String mParam1 = getArguments().getString("param");
			TextView tv = (TextView) view.findViewById(R.id.textview);
			tv.setText(mParam1);
		}
		return view;
	}
}
