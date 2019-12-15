package ch19.hw;
// ������ : �߽Ľð� �߰��ϱ�(20:00~24:00)
public class NightMealState implements State{

	// ������ : �ϳ��� ���¸� �ʿ��ϹǷ�, Singleton ������ �����
	// ������ : static ������ ����ϸ� Ŭ������ �ε�ɶ� ��ü�� �����ȴ�.
	private static NightMealState singleton = new NightMealState();

	private NightMealState() { // �����ڴ� private
		}
	public static State getInstance() {
		// TODO Auto-generated method stub
		return singleton;
	}
	@Override
	public void doClock(Context context, int hour) {
		// TODO Auto-generated method stub
		// ������ : ���ڿ��� ������ �ð��� �߰��̶��,
		if(hour<9||hour>=24||(hour>=17&&hour<20)) {
			context.changeState(NightState.getInstance());
		}
		// ������ : ���ڿ��� ������ �ð��� ���ɽð��̶��,
		if(hour>=12&&hour<13) {
			context.changeState(NoonState.getInstance());
		}
		// ������ : ���ڿ��� ������ �ð��� �ְ��ð��̶��,
		if (((hour>=9&&hour<12)||(hour>=13&&hour<17))) {
			context.changeState(DayState.getInstance());
		}
	}
	// �ݰ� ����� ��Ÿ���� �޼ҵ�
	public void doUse(Context context) { 
		// ������ : (1) ��ϳ����
		context.recordLog("�ݰ���(�߽�)"); // �ְ��� �ݰ� ��������� ���
		// ������ : (2) ������ �뺸�ϱ�
		context.callSecurityCenter("���:�߽��� �ݰ���");
	}
	// ������ : ����� ����ϸ� ������ �뺸�� ����.
	public void doAlarm(Context context) { // ���
		context.callSecurityCenter("���(�߽�)");
	}
	// ������ : ��ȭ�� ����ϸ� ������� �ڵ�����Ⱑ ȣ��ȴ�.
	public void doPhone(Context context) { 
		context.recordLog("�Ϲ� ��ȭ(�߽�)");
	}

	public String toString() { // ���ڿ� ǥ��
			return "[�߽�]";
	}
	// ������ : doCCTV() �������̵�
	@Override
	public void doCCTV(Context context) {
		// TODO Auto-generated method stub
		context.recordLog("CCTV: Off");
	}

	

}
