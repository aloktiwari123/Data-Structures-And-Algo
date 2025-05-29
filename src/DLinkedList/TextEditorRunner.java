package DLinkedList;

public class TextEditorRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextEditor obj = new TextEditor();
		obj.addText("leetcode");
		System.out.println(obj.deleteText(4));
		obj.addText("practice");
		System.out.println(obj.cursorRight(3));
		System.out.println(obj.cursorLeft(8));
		System.out.print(obj.deleteText(10));
		System.out.println(obj.cursorLeft(2));
		System.out.println(obj.cursorRight(6));
	}

}
