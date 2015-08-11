/* W2-D4-S6 ProcessContent.java */


package com.adobe.training.core;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

public class ProcessContent {


    protected static final String CONTENT_NODENAME = "content";
    
    public String stripNonLettersOrNumbers(String in) {
        if(in != null) {
            return in.replaceAll( "[^\\p{L}\\p{N}]", "");
        } else {
            return null;
        }
        
    }
    
    public String getContentPath(Session session)  throws RepositoryException {
        Node rootNode = session.getRootNode();
        if (rootNode.hasNode(CONTENT_NODENAME))  {
            Node contentNode = rootNode.getNode(CONTENT_NODENAME);
            return contentNode.getPath();
        
        } else {
            return rootNode.getPath();
        }
    }
    
}

/* W2-D4-S6 ProcessContent.java */


