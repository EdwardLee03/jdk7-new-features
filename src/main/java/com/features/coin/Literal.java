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

import org.testng.annotations.Test;

/**
 * 字面量，是固定值的源代码表现形式。
 *
 * @author	lihg
 * @version 2013-11-17
 * @see 《Java Tutorial》 3.1.2 基本数据类型 P30
 */
public class Literal {

	@Test(description = "适合位操作")
	public void binary() {
		// 8-bit
		byte aByte = 0b00100001;
		
		// 16-bit
		short aShort = 0b0010000101000101;
		// 上一条语句为什么不需要类型强制转换，而下一条则需要？
		short anShort = (short) 0b1010000101000101;
		// 当心：当值超过类型的最大值时，类型会被自动升级为int！
		// 所以必须进行类型强制转换，但值已不是你期望的正数！
		
		// 32-bit
		int anInt = 0B101; // The B can be upper or lower case.
		
		
		assertEquals(aByte, (byte) 33);
		assertEquals(anShort, (short) -24251);
		assertEquals(aShort, (short) 8517);
		assertEquals(anInt, 5);
	}
	
	@Test(description = "适合表示很长的数字，如最大值、最小值、边界值")
	public void underscores() {
		// Note the "L" suffix:
		long creditCardNumber = 1234_5678_9012_3456L;
		long socailSecurityNumber = 999_99_9999L;

		long maxLong = 0x7fff_ffff_ffff_ffffL; // 可读性更强！
//		long MAX_VALUE = 0x7fffffffffffffffL; // Long.MAX_VALUE 原定义

		byte nibbles = 0b0010_0101;
		
		
		assertEquals(creditCardNumber, 1234567890123456L);
		assertEquals(socailSecurityNumber, 999999999L);

		assertEquals(maxLong, Long.MAX_VALUE);

		assertEquals(nibbles, (byte) 37);
	}
	
	@Test
	public void bond() {
		// Courtesy Josh Bloch
		int bond =
			 0000_____________0000________0000000000000000__000000000000000000+
		   00000000_________00000000______000000000000000__0000000000000000000+
		  000____000_______000____000_____000_______0000__00______0+
		 000______000_____000______000_____________0000___00______0+
		0000______0000___0000______0000___________0000_____0_____0+
		0000______0000___0000______0000__________0000___________0+
		0000______0000___0000______0000_________0000__0000000000+
		0000______0000___0000______0000________0000+
		 000______000_____000______000________0000+
		  000____000_______000____000_______00000+
		   00000000_________00000000_______0000000+
		     0000_____________0000________000000007;
		
		assertEquals(bond, 007);
	}

}
