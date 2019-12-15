package ch19.hw;
// 백지연 : 야식시간 추가하기(20:00~24:00)
public class NightMealState implements State{

	// 백지연 : 하나의 상태만 필요하므로, Singleton 패턴을 사용함
	// 백지연 : static 변수를 사용하면 클래스가 로드될때 객체가 생성된다.
	private static NightMealState singleton = new NightMealState();

	private NightMealState() { // 생성자는 private
		}
	public static State getInstance() {
		// TODO Auto-generated method stub
		return singleton;
	}
	@Override
	public void doClock(Context context, int hour) {
		// TODO Auto-generated method stub
		// 백지연 : 인자에서 제공된 시간이 야간이라면,
		if(hour<9||hour>=24||(hour>=17&&hour<20)) {
			context.changeState(NightState.getInstance());
		}
		// 백지연 : 인자에서 제공된 시간이 점심시간이라면,
		if(hour>=12&&hour<13) {
			context.changeState(NoonState.getInstance());
		}
		// 백지연 : 인자에서 제공된 시간이 주간시간이라면,
		if (((hour>=9&&hour<12)||(hour>=13&&hour<17))) {
			context.changeState(DayState.getInstance());
		}
	}
	// 금고 사용을 나타내는 메소드
	public void doUse(Context context) { 
		// 백지연 : (1) 기록남기기
		context.recordLog("금고사용(야식)"); // 주간에 금고를 사용했음을 기록
		// 백지연 : (2) 비상사태 통보하기
		context.callSecurityCenter("비상:야식의 금고사용");
	}
	// 백지연 : 비상벨을 사용하면 비상사태 통보가 간다.
	public void doAlarm(Context context) { // 비상벨
		context.callSecurityCenter("비상벨(야식)");
	}
	// 백지연 : 전화를 사용하면 경비센터의 자동응답기가 호출된다.
	public void doPhone(Context context) { 
		context.recordLog("일반 통화(야식)");
	}

	public String toString() { // 문자열 표현
			return "[야식]";
	}
	// 백지연 : doCCTV() 오버라이드
	@Override
	public void doCCTV(Context context) {
		// TODO Auto-generated method stub
		context.recordLog("CCTV: Off");
	}

	

}
