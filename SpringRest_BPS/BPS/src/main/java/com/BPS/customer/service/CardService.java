package com.BPS.customer.service;

import java.util.List;

import com.BPS.customer.entities.Card;

public interface CardService {
	
	public List<Card> findByCardNo(String cardNo);

}
