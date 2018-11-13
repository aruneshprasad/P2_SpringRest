package bps.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames="card_no"))
public class Card {

	@Id
	@Column(unique = true, name="card_no")
	private String cardNo;
	
	@Basic
	@Column(name="card_type")
	private String cardType;
	
	@Basic
	@Column(name="card_validity")
	private String cardValidity;
	
	public String getCardNo() {
		return cardNo;
	}
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	public String getCardType() {
		return cardType;
	}
	
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	public String getCardValidity() {
		return cardValidity;
	}
	
	public void setCardValidity(String cardValidity) {
		this.cardValidity = cardValidity;
	}
	
}
