package com.lifeihu.spring.cloud.weather.utils;

/**
 * Created by e-lifeihu on 2018/10/23.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * String Util.
 *  前台传递GZIP格式，进行转码
 * @since 1.0.0 2018年3月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class StringUtils {
    /**
     * 处理 Gizp 压缩的数据.
     *
     * @param str
     * @return
     * @throws IOException
     */
    public static String conventFromGzip(String str) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in;
        GZIPInputStream gunzip = null;

        in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
        gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }

        return out.toString();
    }


}