package king.bean.circle;

/**
 * @author YuXiaodan
 * @ClassName CircleA
 * @Description
 * @date 2017年09月23日 2017/9/23
 */
public class CircleA implements Circle{

	private Circle circleB;

	public CircleA(){}

	public CircleA(Circle circleB) {
		this.circleB = circleB;
	}

	@Override
	public void circle() {
		circleB.circle();
	}

	public void setCircleB(Circle circleB) {
		this.circleB = circleB;
	}
}
