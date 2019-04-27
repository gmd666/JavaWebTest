package user.domain;
/**
 *User类的属性；
 *暂时用不到；
 * @author MaiBenBen
 *
 */
public class User {
	private char yourAnswer;
	private char trueAnswer;
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public char getYourAnswer() {
		return yourAnswer;
	}
	public void setYourAnswer(char yourAnswer) {
		this.yourAnswer = yourAnswer;
	}
	public char getTrueAnswer() {
		return trueAnswer;
	}
	public void setTrueAnswer(char c) {
		this.trueAnswer = c;
	}
	
}
