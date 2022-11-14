package com.example.demo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Palindrome {

    private String string;
    private long length;
    private String reverse;
    private String result;
    public String getString() {
        return string;
    }
    public void setString(String string) {
        this.string = string;
    }
    public long getLength() {
        return length;
    }
    public void setLength(long length) {
        this.length = length;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public Palindrome(String string, long length, String reverse, String result) {
	super();
	this.string = string;
	this.length = length;
	this.reverse = reverse;
	this.result = result;
    }
    public Palindrome()
    {
	
    }
    public String getReverse() {
        return reverse;
    }
    public void setReverse(String reverse) {
        this.reverse = reverse;
    }
 
}
