/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * @author Nikolaj
 */
public class WebImageCalculator implements Runnable {

    private int sum = 0;

    public int getSum() {
        return sum;
    }

    private String url;

    public WebImageCalculator(String url) {
        this.url = url;
    }

    @Override
    public synchronized void run() {
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try {
            InputStream is = new URL(url).openStream();
            byte[] bytebuff = new byte[4096];
            int read;
            while ((read = is.read(bytebuff)) > 0) {
                bis.write(bytebuff, 0, read);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

        byte[] array = bis.toByteArray();

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
    }
}
