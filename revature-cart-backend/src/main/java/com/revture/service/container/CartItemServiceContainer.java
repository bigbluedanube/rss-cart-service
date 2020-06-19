package com.revture.service.container;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.revature.cart.dao.CartItemDao;
import com.revature.cart.model.CartItem;
import com.revature.service.CartItemService;

public class CartItemServiceContainer implements CartItemService {
	
	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public List<CartItem> getAllCartItems() {
		
		return cartItemDao.findAll();
	}

	@Override
	public CartItem getCartItemById(int id) {
		
		try {
			return cartItemDao.findById(id).get();
			
		} catch (NoSuchElementException e) {
			
			return null;
		}
	}

	@Override
	public CartItem createCartItem(CartItem item) {
		
		try {
			return cartItemDao.save(item);
		} catch (DataIntegrityViolationException e) {
			return null;
		}

	}

	@Override
	public void deleteCartItemById(int id) {
		
		cartItemDao.deleteById(id);

	}

	@Override
	public void updateCartItemById(int id) {
		// TODO Auto-generated method stub

	}

	/**
	 * Marks implementation
	 */
	@Override
	public CartItem updateCartItem(CartItem item) {
		
		try {
			cartItemDao.save(item);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
		}
		return null;
	}

}
