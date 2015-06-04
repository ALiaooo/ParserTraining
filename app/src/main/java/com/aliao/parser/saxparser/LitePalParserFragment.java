package com.aliao.parser.saxparser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.aliao.parser.R;
import com.aliao.parser.entity.LitePalAttr;

/**
 * Created by 丽双 on 2015/6/4.
 */
public class LitePalParserFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = LitePalParserFragment.class.getSimpleName();
    private TextView mTvResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_saxparser_litepal, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnParse = (Button) view.findViewById(R.id.btn_parse_litepal);
        btnParse.setOnClickListener(this);
        mTvResult = (TextView) view.findViewById(R.id.tvSaxParserResult);
    }


    @Override
    public void onClick(View v) {
        LitePalParser.parseLitePalConfiguration();
        showResult();
    }

    private void showResult() {
        LitePalAttr mLitePalAttr = LitePalAttr.getIntance();
        StringBuffer sb = new StringBuffer(mLitePalAttr.toString());
        for (String className:mLitePalAttr.getClassNames()){
            sb.append("/n"+className);
        }
        mTvResult.setText(sb.toString());
    }
}
