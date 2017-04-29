package cn.mldn.dtest;

import java.util.Base64;

public class TestCode {
	public static void main(String[] args) {
		String orgPass = "mldnjavahelloworldnihaoma" ;
		String newPass = Base64.getEncoder().encodeToString(orgPass.getBytes()) ;
		System.out.println(newPass);
		byte data [] = Base64.getDecoder().decode(newPass.getBytes()) ;
		System.out.println(new String(data));
	}
}
