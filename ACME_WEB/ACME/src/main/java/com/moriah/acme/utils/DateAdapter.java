package com.moriah.acme.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
	// Fri, 3 Oct 2014 00:43:43 +0800
    //private SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
    
	// Fri, 3 Oct 2014 00:43:43 +0800
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    
    @Override
    public String marshal(Date date) throws Exception {
        return dateFormat.format(date);
    }
 
    @Override
    public Date unmarshal(String string) throws Exception {
        return dateFormat.parse(string);
    }
}
