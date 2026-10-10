package Phase3.homework;

import java.io.File;
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        try (var sc = new Scanner(new File("C:\\eclipse\\eclipse\\workspace\\Programming_Basic_Study\\src\\Phase3\\homework\\services_products.txt"))) {
            var cols = sc.hasNext() ? sc.nextLine().split("\t") : null;
            if (cols == null) {
                return;
            }
            
            var total = 0;
            
            while (cols != null) {
            	var middleTotal = 0;
            	var category = cols[0];
            	
            	while (cols != null && cols[0].equals(category)) {
            		var smallTotal = 0;
            		var code = cols[1];
            		
            		while (cols != null && cols[1].equals(code)) {
            			var name = cols[2];
            			var price = Integer.parseInt(cols[3]);
            			
            			smallTotal += price;
            			System.out.printf("%s\t%s\t%s\t%d\n",category, code, name, price);
            			cols = sc.hasNext() ? sc.nextLine().split("\t") : null;
            		}
            		
            		System.out.printf("小計\t\t\t%d\n", smallTotal);
            		middleTotal += smallTotal;
            		
            		
            	}
            	
            	System.out.printf("中計\t\t\t%d\n", middleTotal);
            	total += middleTotal;
            	
                /*if (!cols[0].equals(category)) {
                    
                    middleTotal += smallTotal;
                    smallTotal = 0;
                    code = cols[1];
                    
                    total += middleTotal;
                    middleTotal = 0;
                    category = cols[0];
                } else if (!cols[1].equals(code)) {
                    System.out.printf("小計\t\t\t%d\n", smallTotal);
                    middleTotal += smallTotal;
                    smallTotal = 0;
                    code = cols[1];
                }*/
                /*var name = cols[2];
                var price = Integer.parseInt(cols[3]);
                smallTotal += price;
                System.out.printf("%s\t%s\t%s\t%d\n", category, code, name, price);
                cols = sc.hasNext() ? sc.nextLine().split("\t") : null;
            }*/
            /*System.out.printf("小計\t\t\t%d\n", smallTotal);
            middleTotal += smallTotal;
            System.out.printf("中計\t\t\t%d\n", middleTotal);
            total += middleTotal;*/
            System.out.printf("合計\t\t\t%d\n", total);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}