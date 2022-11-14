package com.example.banabada.controller;

import com.example.banabada.model.ProductEntity;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("banabada/orders")
public class OrdersController {



    /*
    //장바구니에 물건 넣기
    @PostMapping("/username/cart/{id}/{productId}")
    public String addCartItem(@PathVariable("id") Integer id, @PathVariable("itemId") Integer itemId, int amount) {

        UserDatabase userPageService = null;
        //@@Service 만들 필요 있음..??

        User user = userPageService.findUser(id);
        Object itemService;
         오류 : CartService 없어서 >> CartService 따로 만들건지, 여기에? 어떻게?
        AbstractReadWriteAccess.Item item = ProductEntity.itemView(itemId);

        Object CartEntity = null; //임시로 변경.. CartService 만들 필요
        CartEntity.addCart(user, item, amount);

        return "redirect:/item/view/{itemId}";


    */




/* 오류해결못함1114, CartController 따로 만들어야 함

    // 장바구니 담기
    @Transactional
    public void addCart(User user, ProductEntity newProduct, int amount) {

        // 유저 id로 해당 유저의 장바구니 찾기
        Cart cart = cartRepository.findByUserId(user.getId());

        // 장바구니가 존재하지 않는다면
        if (cart == null) {
            cart = Cart.createCart(user);
            cartRepository.save(cart);
        }

        Item item = itemRepository.findItemById(newItem.getId());
        CartItem cartItem = cartItemRepository.findByCartIdAndItemId(cart.getId(), item.getId());

        // 상품이 장바구니에 존재하지 않는다면 카트상품 생성 후 추가
        if (cartItem == null) {
            cartItem = CartItem.createCartItem(cart, item, amount);
            cartItemRepository.save(cartItem);
        }

        // 상품이 장바구니에 이미 존재한다면 수량만 증가
        else {
            CartItem update = cartItem;
            update.setCart(cartItem.getCart());
            update.setItem(cartItem.getItem());
            update.addCount(amount);
            update.setCount(update.getCount());
            cartItemRepository.save(update);
        }

        // 카트 상품 총 개수 증가
        cart.setCount(cart.getCount()+amount);


    }
        //총 상품 금액 표시
        //어쩌고..

 */
    }