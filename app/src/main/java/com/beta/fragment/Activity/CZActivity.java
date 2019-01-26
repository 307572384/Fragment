package com.beta.fragment.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import com.beta.fragment.Fragment.S_Fragment_1;
import com.beta.fragment.R;

/**
 * Created by Kevein on 2019/1/23.21:20
 */

public class CZActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.s_fragment_main);
		FragmentManager fragmentManager = getFragmentManager();
		S_Fragment_1 s_fragment_1 = new S_Fragment_1();

		getFragmentManager().beginTransaction().replace(R.id.s_main, s_fragment_1).commit();
		//		getFragmentManager().beginTransaction().replace(R.id.s_main, s_fragment_1).commit();
		//		replaceFragment();
	}
	//	private void replaceFragment() {
	//		FragmentManager manager = getSupportFragmentManager();
	//		S_Fragment_1 s_fragment_1 = new S_Fragment_1();
	//		FragmentTransaction transaction = manager.beginTransaction();
	//		transaction.replace(R.id.s_main, s_fragment_1);
	//		transaction.commit();
	//	}
}
