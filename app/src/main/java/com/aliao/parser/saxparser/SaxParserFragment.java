package com.aliao.parser.saxparser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliao.parser.R;

/**
 * Created by 丽双 on 2015/6/4.
 */
public class SaxParserFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = SaxParserFragment.class.getSimpleName();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static final SaxParserFragment newInstance() {
        SaxParserFragment saxFragment = new SaxParserFragment();
        return saxFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_saxparser, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.btn_parse_beauty).setOnClickListener(this);
        view.findViewById(R.id.btn_parse_litepal).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SaxParserActivity saxActivity = (SaxParserActivity) getActivity();
        switch (v.getId()){
            case R.id.btn_parse_beauty:
                saxActivity.replaceBeauty();
                break;
            case R.id.btn_parse_litepal:
                saxActivity.replaceLitePal();
                break;
        }
    }
}
