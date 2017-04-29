package cn.mldn.dtest;

import cn.mldn.util.MD5Code;

public class TestMD5Code {
	public static void main(String[] args) {
		String orgPass = "hello" ;
		String encPass = new MD5Code().getMD5ofStr(orgPass) ;
		System.out.println(encPass);
		System.out.println(encPass.length());
	}
}
