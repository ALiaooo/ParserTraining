package com.aliao.parser.saxparser;

import com.aliao.parser.entity.Beauty;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by 丽双 on 2015/6/3.
 */
public class BeautySaxHandler extends DefaultHandler{
    private ArrayList<Beauty> mList;
    private Beauty beauty;
    private String content;

    public BeautySaxHandler(ArrayList<Beauty> mBeautyList) {
        this.mList = mBeautyList;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        content = new String(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if ("beauty".equals(localName)){
            beauty = new Beauty();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if ("name".equals(localName)){
            beauty.setName(content);
        }else if("age".equals(localName)){
            beauty.setAge(content);
        }else if ("beauty".equals(localName)){
            mList.add(beauty);
        }
    }
}
