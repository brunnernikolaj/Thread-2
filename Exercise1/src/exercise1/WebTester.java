/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Nikolaj
 */
public class WebTester {

    List<String> urls = Arrays.asList("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png",
            "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png",
            "https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");

    public void CalcSizesParallel() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(urls.size());

        List<WebImageCalculator> list = new ArrayList<>();

        for (String url : urls) {
            WebImageCalculator calc = new WebImageCalculator(url);
            list.add(calc);
            executor.submit(calc);
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        Optional<Integer> sum = list.stream().map(x -> x.getSum()).reduce((a, b) -> a + b);
        System.out.println(sum);
    }

    public void CalcSizes() throws InterruptedException {

        List<WebImageCalculator> list = new ArrayList<>();

        for (String url : urls) {
            WebImageCalculator calc = new WebImageCalculator(url);
            list.add(calc);
            calc.run();
        }

        Optional<Integer> sum = list.stream().map(x -> x.getSum()).reduce((a, b) -> a + b);
        System.out.println(sum);
    }
}
