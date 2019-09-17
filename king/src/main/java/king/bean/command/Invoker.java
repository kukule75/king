package king.bean.command;

/**
 * @author YuXiaodan
 * @ClassName Invoker
 * @Description
 * @date 2018年04月09日 2018/4/9
 */
public class Invoker {

	private Command command;

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void action() {
		this.command.execute();
	}
}
