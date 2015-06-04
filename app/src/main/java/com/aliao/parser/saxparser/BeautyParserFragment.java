package com.aliao.parser.saxparser;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aliao.parser.App;
import com.aliao.parser.R;
import com.aliao.parser.entity.Beauty;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by 丽双 on 2015/6/4.
 */
public class BeautyParserFragment extends Fragment {

    public static final String TAG = BeautyParserFragment.class.getSimpleName();
    private ArrayList<Beauty> mBeautyList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_saxparser_beauty, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBeautyList = new ArrayList<>();
        saxParser();
        setTextResult(view);
    }


    private void saxParser() {

        AssetManager assetManager = App.getContext().getAssets();
        try {

            InputStream inputStream = assetManager.open("beauty.xml");

            InputSource inputSource = new InputSource(inputStream);

            SAXParserFactory spf = SAXParserFactory.newInstance();

            SAXParser saxParser = spf.newSAXParser();

            XMLReader xmlReader = saxParser.getXMLReader();

            BeautySaxHandler saxHandler = new BeautySaxHandler(mBeautyList);

            xmlReader.setContentHandler(saxHandler);

            xmlReader.parse(inputSource);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setTextResult(View view) {
        String result = "";

        for (Beauty b : mBeautyList) {
            result += b.toString();
        }

        TextView textView = (TextView) view.findViewById(R.id.tvSaxParserResult);
        textView.setText("解析结果：" + result);
    }

}
