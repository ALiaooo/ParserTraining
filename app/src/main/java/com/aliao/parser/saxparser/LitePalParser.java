package com.aliao.parser.saxparser;

import android.content.res.AssetManager;

import com.aliao.parser.App;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by 丽双 on 2015/6/4.
 */
public class LitePalParser {

    private static LitePalParser parser;

    public static void parseLitePalConfiguration(){
        if (parser == null){
            parser = new LitePalParser();
        }
        parser.useSAXParser();
    }

    void useSAXParser(){

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            LitePalContentHandler handler = new LitePalContentHandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new InputSource(getConfigInputStream()));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取读取litepal.xml文件的输入流
     * @return
     */
    private InputStream getConfigInputStream(){
        AssetManager assetManager = App.getContext().getAssets();
        try {
            InputStream inputStream = assetManager.open("litepal.xml");
            return inputStream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
