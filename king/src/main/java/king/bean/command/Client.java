package king.bean.command;

/**
 * @author YuXiaodan
 * @ClassName Client
 * @Description
 * @date 2018年04月09日 2018/4/9
 */
public class Client {

	public static void main(String[] args) {

		Receiver receiver = new Receiver();

		Command command = new CommandA(receiver);

//		command.execute();

		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.action();
	}
}
