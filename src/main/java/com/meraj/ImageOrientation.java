package com.meraj;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifIFD0Directory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ImageOrientation {

    public int getImageOrientation(byte[] imageContent) throws ImageProcessingException, IOException, MetadataException {
        final Metadata metadata = ImageMetadataReader.readMetadata(new ByteArrayInputStream(imageContent));
        final ExifIFD0Directory exifDirectory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
        return exifDirectory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
    }
}
