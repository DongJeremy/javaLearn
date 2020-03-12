package org.cloud.thinkinjava;

import java.util.function.Supplier;

class Emp {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
}

public class App {
    public static void main(String[] args) {
        Supplier<String> supplier = String::new;
        
        System.out.println(supplier.get());//""
        Supplier<Emp> supplierEmp = Emp::new;
        Emp emp = supplierEmp.get();
        emp.setName("dd");
        System.out.println(emp.getName());
    }
}
