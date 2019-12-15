package ch19.hw;

// �߰��� ���¸� ��Ÿ���� Ŭ����
public class NightState implements State {
	private static NightState singleton = new NightState();

	private NightState() { // �����ڴ� private
	}

	public static State getInstance() { // ������ �ϳ��� �ν��Ͻ��� ��´�.
		return singleton;
	}

	public void doClock(Context context, int hour) { // �ð�����
		// ���ڿ��� ������ �ð��� �ְ��� �ð��̸�, 
		
		// ������ : ���ڿ��� ������ �ð��� ���ɽð��̶��,
		if(hour>=12&&hour<13) {
			context.changeState(NoonState.getInstance());
		}
		// ������ : ���ڿ��� ������ �ð��� �߽Ľð��̶��,
		if(hour>=20&&hour<24) {
			context.changeState(NightMealState.getInstance());
		}
		// ������ : ���ڿ��� ������ �ð��� �ְ��ð��̶��,
		if (((hour>=9&&hour<12)||(hour>=13&&hour<17))) {
			context.changeState(DayState.getInstance());
		}		
	}

	public void doUse(Context context) { // �ݰ���
		context.callSecurityCenter("���:�߰��� �ݰ���");
	}

	public void doAlarm(Context context) { // ���
		context.callSecurityCenter("���(�߰�)");
	}

	public void doPhone(Context context) { // �Ϲ� ��ȭ
		context.recordLog("�߰��� ��ȭ ����");
	}

	public String toString() { // ���ڿ� ǥ��
		return "[�߰�]";
	}
	// ������ : doCCTV() �������̵�
	@Override
	public void doCCTV(Context context) {
		// TODO Auto-generated method stub
		context.recordLog("CCTV: �ػ� 1200 dpi�� ����");
	}	
}
