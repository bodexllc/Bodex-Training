/* W2-D4-S6 : SlingProcessContentTest.java */



package com.adobe.training.core.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.sling.jcr.api.SlingRepository;
import org.apache.sling.junit.annotations.SlingAnnotationsTestRunner;
import org.apache.sling.junit.annotations.TestReference;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.adobe.training.core.ProcessContent;

@RunWith(SlingAnnotationsTestRunner.class)
public class SlingProcessContentTest {

    @TestReference
    private SlingRepository repository;
    
    
    @Test
    public void testRepoName() {
        assertTrue(repository.getDescriptor(Repository.REP_NAME_DESC).equals("Apache Jackrabbit Oak"));
    }
    
    @Test
    public void testGetContentPath() {
        Session adminSession= null;
        try {
            adminSession = repository.loginAdministrative(null);
            ProcessContent tc = new ProcessContent();
            assertEquals("/content", tc.getContentPath(adminSession));
        } catch (RepositoryException e) {
            
            
        }finally {
            if(adminSession != null) {
                if (adminSession.isLive())
                    adminSession.logout();
            }
        }
        
    }
}

/* W2-D4-S6 : SlingProcessContentTest.java ends*/

