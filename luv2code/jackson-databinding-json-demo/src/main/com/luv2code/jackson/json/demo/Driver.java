package com.luv2code.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

            System.out.println("First name = " + student.getFirstName());
            System.out.println("Last Name = " + student.getLastName());

            Address tempAddress = student.getAddress();

            System.out.println("Street = " + tempAddress.getStreet());
            System.out.println("City = " + tempAddress.getCity());

            for(String tempLang: student.getLanguages()) {
                System.out.println(tempLang);
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}