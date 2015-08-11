/* W2-D4-S6 MavenProcessContentTest.java */


package com.adobe.training.core;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.powermock.api.easymock.PowerMock.createMock;
import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.easymock.PowerMock.verifyAll;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.junit.Test;

public class MavenProcessContentTest {
    @Test
    public void testStripNonLettersOrNumbers() {
        ProcessContent pc = new ProcessContent();
        assertEquals("abc1", pc.stripNonLettersOrNumbers("a_b!c.1"));
    }
    
    @Test
    public void testGetContentPath()
        throws RepositoryException {
        //create a mock repository session and prepare the expected method calls
        final Session SESSION_MOCK = createMock(Session.class);
        final Node ROOT_NODE_MOCK = createMock(Node.class);
        expect(SESSION_MOCK.getRootNode()).andReturn(ROOT_NODE_MOCK);
        expect(ROOT_NODE_MOCK.hasNode(ProcessContent.CONTENT_NODENAME)).andReturn(true);
        
        final Node CONTENT_NODE_MOCK = createMock(Node.class);
        expect(ROOT_NODE_MOCK.getNode(ProcessContent.CONTENT_NODENAME)).andReturn(CONTENT_NODE_MOCK);
        expect(CONTENT_NODE_MOCK.getPath()).andReturn("/content");
        replayAll();
        
        ProcessContent pc = new ProcessContent();
        assertEquals("/content", pc.getContentPath(SESSION_MOCK));
        
        //verify that all expected methods calls have been executed
        verifyAll();
        
    }

}

/* W2-D4-S6 MavenProcessContentTest.java ends*/
