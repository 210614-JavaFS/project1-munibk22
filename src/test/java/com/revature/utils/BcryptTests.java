//package com.revature.utils;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mindrot.jbcrypt.BCrypt;
//
//public class BcryptTests {
//
//	public static String password;
//	public static String hashedPw = BCrypt.hashpw(password, BCrypt.gensalt());
//	static Bcrypt bcrypt = new Bcrypt();
//	public static boolean result;
//
//	@BeforeAll
//	public static void bCryptUtil() {
//		System.out.println("In before all");
//		bcrypt = new Bcrypt();
//	}
//
//	@BeforeEach
//	public void setPassword() {
//		System.out.println("In before each");
//		password = "password";
//		hashedPw = BCrypt.hashpw(password, BCrypt.gensalt());
//	}
//
//	@AfterEach
//	public void clearResult() {
//		System.out.println("In after each");
//		password = "";
//		result = true;
//	}
//
//	@AfterAll
//	public static void clearBCryptUtil() {
//		System.out.println("In after all");
//		bcrypt = null;
//	}
//
//	@Test
//	public void testLogin() {
//		System.out.println("In after all");
//		result = bcrypt.checkPw("password");
//		assertEquals(true, result);
//
//	}
//
//	@Test
//	public void test2() {
//		System.out.println("In after all");
//		result = bcrypt.checkPw(hashedPw);
//		assertEquals(result, true);
////		assertTrue(result.equals("password"));
//
//	}
//
//}
