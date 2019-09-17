package king.bean.command;

/**
 * @author YuXiaodan
 * @ClassName CommandA
 * @Description
 * @date 2018年04月09日 2018/4/9
 */
public class CommandA extends Command{

	private Receiver receiver;

	public CommandA(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.doSomething();
	}
}
