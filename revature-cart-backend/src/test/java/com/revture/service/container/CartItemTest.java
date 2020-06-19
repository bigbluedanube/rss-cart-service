package com.revture.service.container;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.cart.dao.CartItemDao;
import com.revature.cart.model.CartItem;
import com.revature.service.CartItemService;

@SpringBootTest
class CartItemTest {
	
	@Autowired
	CartItemService cartItemService;
	
	@BeforeEach
	public void setUp() throws Exception {
		// clear cartItem table
		List<CartItem> ci_List = cartItemService.getAllCartItems();
		for(CartItem c : ci_List) {
			cartItemService.deleteCartItemById(c.getCartItemId());
		}
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
