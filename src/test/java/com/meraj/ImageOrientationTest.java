package com.meraj;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class ImageOrientationTest {

    private ImageOrientation imageOrientation;

    @Before
    public void setUp() {
        imageOrientation = new ImageOrientation();
    }

    @Test
    public void getImageOrientation() throws Exception {
        assertEquals(1, getOrientation("one.jpg"));
        assertEquals(2, getOrientation("two.jpg"));
        assertEquals(3, getOrientation("three.jpg"));
    }

    private int getOrientation(String fileName) throws Exception {
        final InputStream imageStream = getClass().getClassLoader().getResourceAsStream(fileName);
        final byte[] imageContent = IOUtils.toByteArray(imageStream);
        return this.imageOrientation.getImageOrientation(imageContent);
    }
}