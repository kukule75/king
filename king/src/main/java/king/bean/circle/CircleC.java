package king.bean.circle;

/**
 * @author YuXiaodan
 * @ClassName CircleC
 * @Description
 * @date 2017年09月23日 2017/9/23
 */
public class CircleC implements Circle{

	private Circle circleA;

	public CircleC() {}

	public CircleC(Circle circleA) {
		this.circleA = circleA;
	}

	@Override
	public void circle() {
		circleA.circle();
	}

	public void setCircleA(Circle circleA) {
		this.circleA = circleA;
	}
}
