package com.aliao.parser.saxparser;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

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
 * Created by 丽双 on 2015/6/3.
 */
public class SaxParserActivity extends Activity {

    private ArrayList<Beauty> mBeautyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sax);

        mBeautyList = new ArrayList<>();

        saxParser();

        setTextResult();
    }

    private void saxParser() {

        AssetManager assetManager = getResources().getAssets();
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


    private void setTextResult() {
        String result = "";

        for (Beauty b : mBeautyList) {
            result += b.toString();
        }

        TextView textView = (TextView) findViewById(R.id.tvSaxParserResult);
        textView.setText("解析结果："+result);
    }

}
