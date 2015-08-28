/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 *
 * @author Nikolaj
 */
public class Exercise2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
//        WebImageCalculator task = new WebImageCalculator("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
//        
//        Thread t = new Thread(task);
//        
//        t.start();
//        t.join();
//        
//        System.out.print(task.getSum());

        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());

         WebTester tester = new WebTester();
        
        long start = System.currentTimeMillis();     
        tester.CalcSizesParallel();
        long end = System.currentTimeMillis();
        
        System.out.println("Time Parallel: " + (end - start));
        
        long start2 = System.currentTimeMillis();    
        tester.CalcSizes();
        long end2 = System.currentTimeMillis();

        System.out.println("Time Sequental: " + (end2 - start2));
    }

}
