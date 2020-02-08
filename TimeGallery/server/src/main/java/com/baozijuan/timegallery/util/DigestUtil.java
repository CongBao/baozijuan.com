package com.baozijuan.timegallery.util;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtil {

    private DigestUtil() {
    }

    public static String digest(String str) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        md.update(str.getBytes(StandardCharsets.UTF_8));
        return DatatypeConverter.printHexBinary(md.digest()).toUpperCase();
    }

}
