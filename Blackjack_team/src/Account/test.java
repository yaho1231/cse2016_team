package Account;

public class test {

	public static void main(String[] args) {
		AccountController controller = new AccountController();
		controller.login("test");
		System.out.println(controller.getId() + " : " + controller.getScore());
		controller.setScore(100);
		System.out.println(controller.getId() + " : " + controller.getScore());
		controller.logout();
		System.out.println("--------------------");
		controller.login("no user");
		System.out.println(controller.getId() + " : " + controller.getScore());
		controller.setScore(100);
		System.out.println(controller.getId() + " : " + controller.getScore());
		controller.logout();
	}
}
