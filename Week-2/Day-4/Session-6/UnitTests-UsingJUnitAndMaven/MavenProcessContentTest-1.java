/* W2-D4-S6 MavenProcessContentTest.java */




package com.adobe.training.core;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MavenProcessContentTest {
    @Test
    public void testStripNonLettersOrNumbers() {
        ProcessContent pc = new ProcessContent();
        assertEquals("abc1", pc.stripNonLettersOrNumbers("a_b!c.1"));
    }
}

/* W2-D4-S6 MavenProcessContentTest.java ends*/