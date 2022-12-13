package account;

import java.io.FileWriter;
import java.io.PrintWriter;

public class AccountWriter {

	private PrintWriter outfile;

	public AccountWriter(String file_name) {
		try {
			outfile = new PrintWriter(new FileWriter(file_name));
		}
		catch (Exception e) {
			System.out.println("AccountWriter Error: " + file_name);
			throw new RuntimeException(e.toString());
		}
	}

	public void close() {
		outfile.close();
	}

	public void printAccount(Account a) {
		outfile.println(a.id() + "," + a.score());
	}
	public void printEOF() {
		outfile.println("!");
	}

}