package ch03.hw;
//백지연 : [이름]Display 클래스 추가하기
//백지연 : AbstractDisplay의 하위 클래스
public class BeakJiYeonDisplay extends AbstractDisplay {
	// 백지연 : 멤버 변수 name, studentId, grade 생성
	String name;
	String studentId;
	int grade;
	// 백지연 : 이름, 학번, 학년을 입력 받는 생성자
	public BeakJiYeonDisplay(String name, String studentId, int grade){
		this.name=name;
		this.studentId=studentId;
		this.grade=grade;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	// 백지연 : open(): “====================“와 그 다음 줄에 본인의 학과(예:덕성여대 컴퓨터학과)를 출력하는 메소드
	public void open() {
		System.out.println("====================");
		System.out.println("덕성여대 컴퓨터학과");
		
	}
	@Override
	// 백지연 : print(): 속성에 유지하고 있는 자기 이름과 학번, 학년을 출력하는 메소드
	public void print() {
		System.out.println("학번 "+studentId+" / "+grade+"학년 / "+name);
	}
	@Override
	// 백지연 : close(): “템플릿 메소드 패턴 숙제입니다.”와 그 다음 줄에 “====================를 출력하는 메소드
	public void close() {
		System.out.println("템플릿 메소드 패턴 숙제입니다.");
		System.out.println("====================");
		
	}

}
