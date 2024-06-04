package iodemo;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		ReadingSongsFile obj = new ReadingSongsFile();
		
		do {
			System.out.println("1. Fetch all songs name \n"
					+ "2. Fetch all artist name \n"
					+ "3. Fetch by year \n"
					+ "4. Fetch by artist name \n"
					+ "5. Fetch artist name wise\n"
					+ "6. Search by artist name "
					);
			int key = sc.nextInt();
			switch (key) {
			case 1:
				obj.songNames();
				break;

			case 2:
				obj.artistName();
				break;

			case 3:
				obj.allYear();
				System.out.println("\nEnter the year::");
				obj.fetchByYear(sc.next());
				break;

			case 4:
				System.out.println("Enter the Artist name::");
				sc.nextLine();
				obj.fetchByArtistName(sc.nextLine());
				break;
			case 5:
				obj.fetchForAllArtist();
				break;
			case 6:
				System.out.println("Enter the artist::");
				sc.nextLine();
				obj.searchArstistName(sc.nextLine());
				break;
			default:
				System.exit(0);
				break;
			}
		}while(true);

	}
}
