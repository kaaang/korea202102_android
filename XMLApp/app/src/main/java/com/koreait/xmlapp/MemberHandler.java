package com.koreait.xmlapp;

import android.util.Log;

import com.koreait.xmlapp.domain.Member;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MemberHandler extends DefaultHandler {
    String TAG=this.getClass().getName();

    List<Member> list;
    Member member;
    boolean isMember;
    boolean isName;
    boolean isPhone;
    boolean isAddr;


    @Override
    public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
        if(tag.equals("members")){
            list = new ArrayList<Member>();
        }else if(tag.equals("member")){
            member = new Member();
        }else if(tag.equals("name")){
            isName=true;
        }else if(tag.equals("phone")){
            isPhone=true;
        }else if(tag.equals("addr")){
            isAddr=true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch,start,length);


        if(isName){
          member.setName(data);
        }else if(isPhone){
            member.setPhone(data);
        }else if(isAddr){
            member.setAddr(data);
        }


    }

    @Override
    public void endElement(String uri, String localName, String tag) throws SAXException {
        if(tag.equals("name")){
            isName=false;
        }else if(tag.equals("phone")){
            isPhone=false;
        }else if(tag.equals("addr")){
            isAddr=false;
        }else if(tag.equals("member")){
            list.add(member);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        Log.d(TAG,"Record"+list.size());
    }
}
