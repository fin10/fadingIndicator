package com.ugurtekbas.fadingindicator;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ugurtekbas.fadingindicatorlibrary.FadingIndicator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Fragment to use customized indicators.
 * Created by Ugur Tekbas
 */
public class CustomizedFragment extends Fragment {

    private CustomizedAdapter adapter;
    private Unbinder unbinder;

    @BindView(R.id.viewpagerCustomized) ViewPager viewpagerCustomized;
    @BindView(R.id.squareIndicator) FadingIndicator indicator;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_customized, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);

        int[] pics = {
                R.mipmap.pic5,
                R.mipmap.pic6,
                R.mipmap.pic7,
                R.mipmap.pic8
        };

        adapter = new CustomizedAdapter(getContext(),pics);
        viewpagerCustomized.setAdapter(adapter);
        viewpagerCustomized.setCurrentItem(2);
        indicator.setViewPager(viewpagerCustomized);

        return fragmentView;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}