package exam.domain;

public class Exam {
	/*
	 * �����Ծ��࣬�����Ծ���Ŀ���ݣ�ѡ�����ݣ�
	 */
	private String id;//�Ծ�id
	private String title;//�������ݣ�
	private String chooseA;//Aѡ�����ݣ�
	private String chooseB;//Bѡ�����ݣ�
	private String chooseC;//Cѡ�����ݣ�
	private String chooseD;//Dѡ�����ݣ�
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
