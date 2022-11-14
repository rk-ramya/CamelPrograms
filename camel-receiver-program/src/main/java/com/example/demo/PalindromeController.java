package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {

    @GetMapping("palindrome/string/{string}")
    public Palindrome findIfPalindrome(
	@PathVariable String string
	){

	      String  reverse="",result;
	      int length = string.length();   
	      for ( int i = length - 1; i >= 0; i-- )  
	         reverse = reverse + string.charAt(i);  
	      
	      result=string.equals(reverse)?"Input is a palindrome":"Input is not a palindrome";

	return new Palindrome(string,length,reverse,result);
    
	}
}
