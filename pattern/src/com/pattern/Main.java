package com.pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Transaction transaction = new Transaction(){
            protected boolean isExpired() {
                System.out.println("aaaa");
                return true;
            }
        };
    }
}
