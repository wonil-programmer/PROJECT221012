import java.util.Scanner;
import java.util.Vector;
 
abstract class Shape{
	public Shape() {
	}
	public abstract void draw();
}
 
class Line extends Shape{
	public Line() {
		super();
	}
	//오버라이딩
	public void draw() {
		System.out.println("Line");
	}
}
 
class Rect extends Shape{
	public Rect() {
		super();
	}
	//오버라이딩
	public void draw() {
		System.out.println("Rect");
	}
}
 
class Circle extends Shape{
	public Circle() {
		super();
	}
	//오버라이딩
	public void draw() {
		System.out.println("Circle");
	}
}
 
class GraphicEditor{
	private Shape head,tail;
	private Scanner sc;
	Vector<Shape> v;
	//기본생성자
	public GraphicEditor(){
		v=new Vector<Shape>();
		head=null;
		tail=null;
		sc=new Scanner(System.in);
	}
	
	//에디터 실행 메서드
	void runEditor() {
		int choice;
		System.out.println("그래픽 에디터 beauty을 실행합니다.");
		
		do {
		System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
		choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("Line(1), Rect(2), Circle(3)>>");
				int option=sc.nextInt();
				put(option);
				break;
			case 2:
				System.out.print("삭제할 도형의 위치>>");
				int index=sc.nextInt();
				delete(index);
				break;
			case 3:
				print();
				break;
			case 4:
				break;
			default:
				System.out.println("다시 입력해주세요");
				break;
			}
		}while(choice!=4);
		System.out.println("beauty을 종료합니다.");
	}
	
	//리스트에 넣는 메서드
	void put(int num) {
		Shape g;
		//입력번호에 따라 Line,Rect,Circle객체 생성
		switch(num) {
		case 1:
			g=new Line();
			break;
		case 2:
			g=new Rect();
			break;
		case 3:
			g=new Circle();
			break;
		default:
			System.out.println("다시입력해주세요");
			return;
		}
		v.add(g);
		return;
	}
	void delete(int index) {
		if(index>v.size()) {
			System.out.println("삭제할 수 없습니다.");
			return;
		}
		v.remove(index);
	}
	
	void print() {
		for(int i=0;i<v.size();i++) {
			v.get(i).draw();
		}
	}
}
 
public class Ex10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicEditor ge=new GraphicEditor();
		ge.runEditor();
	}		
}