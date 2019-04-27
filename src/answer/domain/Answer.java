package answer.domain;

public class Answer {
	String id;//¿¼ÊÔ±àºÅ
	String answer;//¿¼ÊÔ´ð°¸£»
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + "]";
	}
}
