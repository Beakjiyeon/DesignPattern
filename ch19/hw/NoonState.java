package ch19.hw;
// ������ : ���ɽð�(12:00~12:59) �߰�
public class NoonState implements State{

	// ������ : �ϳ��� ���¸� �ʿ��ϹǷ�, Singleton ������ �����
	// ������ : static ������ ����ϸ� Ŭ������ �ε�ɶ� ��ü�� �����ȴ�.
	private static NoonState singleton = new NoonState();

	private NoonState() { // �����ڴ� private
	}
	public static State getInstance() {
		// TODO Auto-generated method stub
		return singleton;
	}

	@Override
	public void doClock(Context context, int hour) {
		// TODO Auto-generated method stub
		// ������ : ���ڿ��� ������ �ð��� �߰��̶��,
		if(hour<9||(hour>=17&&hour<20)) {
			context.changeState(NightState.getInstance());
		}
		
		// ������ : ���ڿ��� ������ �ð��� �߽Ľð��̶��,
		if(hour>=20&&hour<=24) {
			context.changeState(NightMealState.getInstance());
		}
		// ������ : ���ڿ��� ������ �ð��� �ְ��ð��̶��,
		if (((hour>=9&&hour<12)||(hour>=13&&hour<17))) {
			context.changeState(DayState.getInstance());
		}
	}

	// �ݰ� ����� ��Ÿ���� �޼ҵ�
	// ������ : �ݰ� ����ϸ� ����Ϳ� �����°� �뺸
	public void doUse(Context context) { 
		// ������ : ���ɽð��� �ݰ��� �뺸
		context.callSecurityCenter("���:���ɽð��� �ݰ���");
	}

	// ������ : ����� ����ϸ� ����Ϳ� ����� �뺸
	public void doAlarm(Context context) { // ���
		context.callSecurityCenter("���(���ɽð�)");
	}

	// ������ : ��ȭ�� ����ϸ� ������� �ڵ�����Ⱑ ȣ��
	public void doPhone(Context context) { 
		context.recordLog("�Ϲ� ��ȭ(���ɽð�)");
	}

	public String toString() { // ���ڿ� ǥ��
		return "[���ɽð�]";
	}

	// ������ : doCCTV() �������̵�
	@Override
	public void doCCTV(Context context) {
		// TODO Auto-generated method stub
		context.recordLog("CCTV: �ػ� 300 dpi�� ����");
	}
	

}
