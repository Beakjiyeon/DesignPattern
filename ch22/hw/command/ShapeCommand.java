package ch22.hw.command;

import ch22.hw.drawer.Drawable;
// ������ : ShapeCommand Ŭ���� ����
public class ShapeCommand implements Command {
	private String shape;
	private Drawable drawable;
	public ShapeCommand(Drawable drawable, String shape){
		this.shape = shape;
		this.drawable = drawable;
	}

	@Override
	public void execute() {
		drawable.setShape(shape);
	}
}
