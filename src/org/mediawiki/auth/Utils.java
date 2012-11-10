package org.mediawiki.auth;

import javax.xml.transform.*;
import java.io.*;


import org.w3c.dom.Node;

import android.R;
import android.os.AsyncTask;
import android.os.Build;

public class Utils {
    public static <T> void executeAsyncTask(AsyncTask<T, ?, ?> task,
            T... params) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
        }
        else {
            task.execute(params);
        }
    }
    
    public static String getStringFromDOM(Node dom) {
       javax.xml.transform.Transformer transformer = null;
       try {
           transformer = TransformerFactory.newInstance().newTransformer();
       } catch (TransformerConfigurationException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (TransformerFactoryConfigurationError e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }

       StringWriter  outputStream = new StringWriter();
       javax.xml.transform.dom.DOMSource domSource = new javax.xml.transform.dom.DOMSource(dom);
       javax.xml.transform.stream.StreamResult strResult = new javax.xml.transform.stream.StreamResult(outputStream);

       try {
        transformer.transform(domSource, strResult);
       } catch (TransformerException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } 
       return outputStream.toString();
    }
}
