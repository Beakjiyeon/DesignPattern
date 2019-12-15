package ch19.hw;

// �ְ��� ���¸� ��Ÿ���� Ŭ����
public class DayState implements State {
	// �ϳ��� ���¸� �ʿ��ϹǷ�, Singleton ������ �����
	private static DayState singleton = new DayState();

	private DayState() { // �����ڴ� private
	}

	public static State getInstance() { // ������ �ϳ��� �ν��Ͻ��� ��´�.
		return singleton;
	}

	// �ð��� �����ϴ� �޼ҵ�
	public void doClock(Context context, int hour) { 
		// ������ : ���ڿ��� ������ �ð��� �߰��̶��,
		if(hour<9||(hour>=24)||(hour>=17&&hour<20)) {
			context.changeState(NightState.getInstance());
		}
		// ������ : ���ڿ��� ������ �ð��� ���ɽð��̶��,
		if(hour>=12&&hour<13) {
			context.changeState(NoonState.getInstance());
		}
		// ������ : ���ڿ��� ������ �ð��� �߽Ľð��̶��,
		if(hour>=20&&hour<24) {
			context.changeState(NightMealState.getInstance());
		}
		
	}

// ���ְ� ���¡����� �ϴ� ���� ǥ���ϴ� �޼ҵ�

	// �ݰ� ����� ��Ÿ���� �޼ҵ�
	public void doUse(Context context) { 
		context.recordLog("�ݰ���(�ְ�)"); // �ְ��� �ݰ� ��������� ���
	}

	// ��󺧷� ����͸� ȣ���ϴ� �޼ҵ�
	public void doAlarm(Context context) { // ���
		context.callSecurityCenter("���(�ְ�)");
	}

	// ����Ϳ� �Ϲ���ȭ�� ��
	public void doPhone(Context context) { 
		context.callSecurityCenter("�Ϲ� ��ȭ(�ְ�)");
	}

	public String toString() { // ���ڿ� ǥ��
		return "[�ְ�]";
	}
	// ������ : doCCTV() �������̵�
	@Override
	public void doCCTV(Context context) {
		// TODO Auto-generated method stub
		context.recordLog("CCTV: �ػ� 600 dpi�� ����");
	}
}
