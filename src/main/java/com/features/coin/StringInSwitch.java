/**
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.features.coin;

import static org.testng.Assert.*;

import org.testng.annotations.*;

/**
 * 在Switch语句中使用字符串.
 *
 * @author	lihg
 * @version 2013-11-18
 */
public class StringInSwitch {

	/**
	 * Strings In Switch.<p>
	 * 
	 * JLS §14.11 The switch Statement (语言规范)
	 * <pre>
	 * The type of the Expression must be char, byte, short, int, Character, Byte, 
	 * Short, Integer, <font color="red"><b>String</b></font>, or an enum type (§8.9), or a compile-time error occurs.
	 * </pre>
	 * 
	 * <font color="red"><b>为什么没有<tt>long</tt>类型？</b></font><p>
	 * 因为一般 case 个数不会很多，使用 int 足以表示，同时 {@link Object#hashCode()} 返回int。<p>
	 * 
	 * <tt>String</tt> 类型的 {@code case} 是如何实现的？<p>
	 * 编译器通过 {@code String#hashCode()} 将 String 类型转换为 int，
	 * 当 case 命中后，还会再通过 {@code String#equals(Object)} 确认值是否相等。(可能存在哈希冲突！)
	 */
	public static String strSwitch(String name) {
		switch (name) {
			case "Athos":
			case "Porthos":
			case "Aramis":
				return "A Musketeer";
			case "d’Artagnan":
				return "Not a Musketeer";
			
			default:
				throw new IllegalArgumentException("name is " + name);
		}
	}
	/* 编译后的字节码
	  public static java.lang.String strSwitch(java.lang.String);
	    Code:
	       0: aload_0
	       1: dup
	       2: astore_1
	       3: invokevirtual #16                 // Method java/lang/String.hashCode:()I
	       6: lookupswitch  { // 4
	              63588121: 48
	             795572743: 60
	            1272526859: 72
	            1969174055: 84
	               default: 102
	          }
	      48: aload_1
	      49: ldc           #22                 // String Athos
	      51: invokevirtual #24                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
	      54: ifne          96
	      57: goto          102
	      60: aload_1
	      61: ldc           #28                 // String d’Artagnan
	      63: invokevirtual #24                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
	      66: ifne          99
	      69: goto          102
	      72: aload_1
	      73: ldc           #30                 // String Porthos
	      75: invokevirtual #24                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
	      78: ifne          96
	      81: goto          102
	      84: aload_1
	      85: ldc           #32                 // String Aramis
	      87: invokevirtual #24                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
	      90: ifne          96
	      93: goto          102
	      96: ldc           #34                 // String A Musketeer
	      98: areturn
	      99: ldc           #36                 // String Not a Musketeer
	     101: areturn
	     102: new           #38                 // class java/lang/IllegalArgumentException
	     105: dup
	     106: new           #40                 // class java/lang/StringBuilder
	     109: dup
	     110: ldc           #42                 // String name is
	     112: invokespecial #44                 // Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
	     115: aload_0
	     116: invokevirtual #47                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
	     119: invokevirtual #51                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
	     122: invokespecial #55                 // Method java/lang/IllegalArgumentException."<init>":(Ljava/lang/String;)V
	     125: athrow
	 */
	
	@Test(dataProvider = "strSwitch")
	public void stringInSwitch(String str, String expected) {
		assertEquals(strSwitch(str), expected); 
	}
	@DataProvider(name = "strSwitch")
	protected static final Object[][] strSwitchTestData() {
		Object[][] testData = new Object[][] {
				{ "Athos", "A Musketeer" }, 
				{ "Porthos", "A Musketeer" }, 
				{ "Aramis", "A Musketeer" }, 
				{ "d’Artagnan", "Not a Musketeer" }
		};
		return testData;
	}

}
