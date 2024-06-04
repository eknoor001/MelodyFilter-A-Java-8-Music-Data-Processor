package iodemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IODemo1 {
	public static void main(String[] args) {

		String filename = "testcases.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;

			while ((line = br.readLine()) != null) {
				try {
					int num = Integer.parseInt(line);
					System.out.println(num);
				} catch (Exception e) {
					System.out.println(line);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
