package org.cloud.basic;

import java.util.Scanner;

public class Guest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		int number= (int)(Math.random()*10);
		System.out.println(number);
		int guest;
		do {
		    System.out.println("guest number:");
		    guest = scanner.nextInt();
		} while(guest!= number);
		System.out.println("guest");
		scanner.close();
	}

}
