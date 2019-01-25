package com.beta.fragment.Fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.beta.fragment.R;

public class S_Fragment_1 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.s_fragment_1,container,false);
		Button btn = (Button)view.findViewById(R.id.load_fragment2_btn);

		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				S_Fragment_2 fragment_2 = S_Fragment_2.newInstance("从S_Fragment_2传来的参数");
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.add(R.id.s_main,fragment_2);
				transaction.commit();
				Toast.makeText(getActivity(),"点击了",Toast.LENGTH_SHORT).show();
			}
		});
		return view;
	}
}
