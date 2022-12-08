package Account;

import java.io.File;

public class AccountController {

	private final String filename = "accounts.csv";
	private Account account;


	/**
	 * 아이디를 받아 로그인한다.
	 * @param id 아이디
	 * @return 기존 회원이면 true, 새로운 회원이면 false
	 */
	public boolean login(String id){
		AccountReader reader = new AccountReader(filename);
		while (reader.getNextRecord()) {
			if (reader.id().equals(id)) {
				account = new Account(id, reader.score());
				reader.close();
				return true;
			}
		}
		account = new Account(id, 100);
		reader.close();
		return false;
	}

	public String getId() {
		return account.id();
	}
	public int getScore() {
		return account.score();
	}
	public void setScore(int score) {
		account.setScore(score);
	}

	public void logout() {
		AccountReader reader = new AccountReader(filename);
		AccountWriter writer = new AccountWriter(filename+".tmp");
		boolean written = false;
		while (reader.getNextRecord()) {
			if (reader.account().id().equals(account.id())) {
				writer.printAccount(account);
				written = true;
			} else {
				writer.printAccount(reader.account());
			}
		}
		if (!written) {
			writer.printAccount(account);
		}
		writer.printEOF();
		reader.close();
		writer.close();

		File file = new File(filename);
		file.delete();
		File file2 = new File(filename+".tmp");
		file2.renameTo(file);

	}


}