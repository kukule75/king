package king.bean.circle;

/**
 * @author YuXiaodan
 * @ClassName CircleB
 * @Description
 * @date 2017年09月23日 2017/9/23
 */
public class CircleB implements Circle{

	private Circle circleC;

	public CircleB() {}

	public CircleB(Circle circleC) {
		this.circleC = circleC;
	}

	@Override
	public void circle() {
		circleC.circle();
	}

	public void setCircleC(Circle circleC) {
		this.circleC = circleC;
	}
}
