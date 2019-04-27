package exam.domain;

public class Exam {
	/*
	 * 创建试卷类，包含试卷题目内容，选项内容；
	 */
	private String id;//试卷id
	private String title;//考试内容；
	private String chooseA;//A选项内容；
	private String chooseB;//B选项内容；
	private String chooseC;//C选项内容；
	private String chooseD;//D选项内容；
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChooseA() {
		return chooseA;
	}
	public void setChooseA(String chooseA) {
		this.chooseA = chooseA;
	}
	public String getChooseB() {
		return chooseB;
	}
	public void setChooseB(String chooseB) {
		this.chooseB = chooseB;
	}
	public String getChooseC() {
		return chooseC;
	}
	public void setChooseC(String chooseC) {
		this.chooseC = chooseC;
	}
	public String getChooseD() {
		return chooseD;
	}
	public void setChooseD(String chooseD) {
		this.chooseD = chooseD;
	}
	@Override
	public String toString() {
		return "Exam [id=" + id + ", title=" + title + ", chooseA=" + chooseA + ", chooseB=" + chooseB + ", chooseC="
				+ chooseC + ", chooseD=" + chooseD + "]";
	}
	
	
}
