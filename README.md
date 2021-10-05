# lotto
To jest testowy projekt. Przypomnienie operacji na tablicach Java.

To przykład kolorowania składni języka Java:
```java
public static byte[][] testoweLosowanie(int liczbaGraczy) {
	byte[][] wylosowaneLiczbyGraczy = new byte[liczbaGraczy][];
	for (int i = 0; i < liczbaGraczy; i++) {
		wylosowaneLiczbyGraczy[i] = losujLiczby();
	}
	return wylosowaneLiczbyGraczy;
}
```
