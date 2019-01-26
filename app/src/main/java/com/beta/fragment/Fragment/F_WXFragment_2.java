package com.beta.fragment.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beta.fragment.R;

/**
 * Created by Kevein on 2019/1/26.12:18
 */
//这里是联系人
public class F_WXFragment_2 extends Fragment{
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		View lxrView = inflater.inflate(R.layout.f_wx_fragment_2,container,false);
		return lxrView;
	}
}
