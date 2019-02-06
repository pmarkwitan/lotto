package com.markwitan.lotto;

import java.util.Arrays;

public class GenerujWszystkieKombinacje {
	private static final int MAX_LICZBA = 49;

	public static void main(String[] args) {
		byte[][] result = generuj();
		System.out.println(result.length);
		System.out.println(Arrays.toString(result[0]));
		System.out.println(Arrays.toString(result[10886570])); //[11, 14, 25, 29, 31, 36]
		System.out.println(Arrays.toString(result[result.length - 1]));
	}
	
	public static byte[][] generuj() {
		byte[][] result = new byte[13_983_816][6];

		int licznik = 0;
		for (byte i1 = 1; i1 <= MAX_LICZBA - 5; i1++) {
			for (byte i2 = (byte)(i1 + 1); i2 <= MAX_LICZBA - 4; i2++) {
				for (byte i3 = (byte)(i2 + 1); i3 <= MAX_LICZBA - 3; i3++) {
					for (byte i4 = (byte)(i3 + 1); i4 <= MAX_LICZBA - 2; i4++) {
						for (byte i5 = (byte)(i4 + 1); i5 <= MAX_LICZBA - 1; i5++) {
							for (byte i6 = (byte)(i5 + 1); i6 <= MAX_LICZBA; i6++) {
								result[licznik++] = new byte[]{i1, i2, i3, i4, i5, i6};
							}
						}
					}
				}
			}
		}
		return result;
	}

}
