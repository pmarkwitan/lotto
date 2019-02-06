package com.markwitan.lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SprawdzWygrane {
	public static void main(String[] args) {
		SprawdzWygrane sw = new SprawdzWygrane();
//		sw.testoweLosowanie();
		sw.testoweLosowanieWygrane();
	}
	
	private byte ileTrafionych(byte[] liczbyLotto, byte[] liczbyGracza) {
		byte result = 0;
		for (byte i : liczbyGracza) {
			if (Arrays.binarySearch(liczbyLotto, i) >= 0) {
				result++;
			}
		}
		
		return result;
	}
	
	private void sprawdzanieWsrodWszystkich() {
		byte[][] wszystkieKombinacje = GenerujWszystkieKombinacje.generuj();
		byte[] sprawdzana = ChybilTrafil.losujLiczby();
		System.out.println("Sprawdzane liczby to: " + Arrays.toString(sprawdzana));
		for (int i = 0; i < wszystkieKombinacje.length; i++) {
			boolean wszystkieZgodne = true;
			for (int j = 0; j < wszystkieKombinacje[0].length; j++) {
				if (wszystkieKombinacje[i][j] != sprawdzana[j]) {
					wszystkieZgodne = false;
					break;
				}
			}
			if (wszystkieZgodne) {
				System.out.println("Trafienie w " + i + " kombinacji.");
				break;
			}
		}
	}

	private void testoweLosowanie() {
		byte[] liczbyLotto = ChybilTrafil.losujLiczby();
		System.out.println("Liczby Lotto to: " + Arrays.toString(liczbyLotto));
		byte[][] liczbyGraczy = ChybilTrafil.testoweLosowanie(20);
		for (byte[] tab : liczbyGraczy) {
			System.out.println("Sprawdzane liczby to: " + Arrays.toString(tab) + "\ttrafieñ: " + ileTrafionych(liczbyLotto, tab));
		}
	}

	private void testoweLosowanieWygrane() {
		byte tmp;
		Map<Integer, Integer> wygrane = new HashMap<>();
		byte[] liczbyLotto = ChybilTrafil.losujLiczby();
		System.out.println("Liczby Lotto to: " + Arrays.toString(liczbyLotto));
		byte[][] liczbyGraczy = ChybilTrafil.testoweLosowanie(1_000_000);
		for (byte[] tab : liczbyGraczy) {
			tmp = ileTrafionych(liczbyLotto, tab);
			if (tmp >= 3) {
				wygrane.put((int)tmp, wygrane.getOrDefault((int)tmp, 0) + 1);
			}
		}
		for (int i = 3; i <= 6; i++) {
			System.out.println(String.format("%d trafienia: %d", i, wygrane.getOrDefault(i, 0)));
		}
		System.out.println(String.format("Zak³ady kosztowa³y: %d\nWygrana: %d",
				liczbyGraczy.length * 3,
				24 * wygrane.getOrDefault(3, 0) + 145 * wygrane.getOrDefault(4, 0) + 5_500 * wygrane.getOrDefault(5, 0) + 2_000_000 * wygrane.getOrDefault(6, 0)));
	}
}
