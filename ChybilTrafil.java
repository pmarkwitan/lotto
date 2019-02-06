package com.markwitan.lotto;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ChybilTrafil {
	private static Random r = new Random(System.currentTimeMillis());
	private ChybilTrafil() {}
	
	public static byte[] losujLiczby() {
		byte result[] = new byte[6];
		Set<Integer> tmp = new TreeSet<>();
		while (tmp.size() < 6) {
			tmp.add(r.nextInt(48) + 1);
		}

		int l = 0;
		for (int i : tmp.toArray(new Integer[0])) {
			result[l++] = (byte)i;
		}

		return result;
	}
	
	public static byte[][] testoweLosowanie(int liczbaGraczy) {
		byte[][] wylosowaneLiczbyGraczy = new byte[liczbaGraczy][];
		for (int i = 0; i < liczbaGraczy; i++) {
			wylosowaneLiczbyGraczy[i] = losujLiczby();
		}

		return wylosowaneLiczbyGraczy;
	}
}
