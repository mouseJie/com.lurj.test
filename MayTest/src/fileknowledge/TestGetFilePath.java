package fileknowledge;

public class TestGetFilePath {
	public static void main(String[] args) {
		new TestGetFilePath().printFilePath();
	}
	
	private void printFilePath() {
		System.out.println(this.getClass().getResource(""));
		System.out.println(this.getClass().getResource("/"));
	}
}
