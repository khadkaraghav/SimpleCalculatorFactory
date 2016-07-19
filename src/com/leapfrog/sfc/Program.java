/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.sfc;

import com.leapfrog.sfc.command.MathCommand;
import com.leapfrog.sfc.command.MathFactory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Anonymous
 */
public class Program {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the file name");
        String fileName = input.next();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                String[] token = line.split(",");
                if (token.length >= 3) {
                    double x = Double.parseDouble(token[0]);
                    String key = token[1];
                    double y = Double.parseDouble(token[2]);

                    MathCommand cmd = MathFactory.get(key);
                    if (cmd != null) {
                        double solution = cmd.calculate(x, y);
                        System.out.println(solution);
                        content.append(x + key + y + "=" + solution + "\r\n");
                        
                    } else {
                        System.out.println("Invalid Command");
                    }
                }

            }
            reader.close();
            System.out.println("Enter filename for solutions");
            fileName=input.next();
            
            FileWriter writer= new FileWriter(fileName);
            writer.write(content.toString());
            writer.close();
            
            }
        
            catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}