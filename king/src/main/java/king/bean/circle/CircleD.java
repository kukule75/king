package king.bean.circle;

/**
 * @author YuXiaodan
 * @ClassName CircleD
 * @Description
 * @date 2017年11月22日 2017/11/22
 */
public class CircleD {

	private CircleE circleE;

	public CircleD(){}

	public CircleD(CircleE circleE) {
		this.circleE = circleE;
	}

	public CircleE getCircleE() {
		return circleE;
	}

	public void setCircleE(CircleE circleE) {
		this.circleE = circleE;
	}
}
