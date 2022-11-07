package com.example.banabada.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class PostController {

    /* 상품 등록 (POST) :: 추후 사용 논의
    @PostMapping("/item/new/itemedit")
    public String itemSave(Item item, @AuthenticationPrincipal PrincipalDetails principalDetails, MultipartFile imgFile) throws Exception {
        if(principalDetails.getUser().getRole().equals("ROLE_ADMIN") || principalDetails.getUser().getRole().equals("ROLE_SELLER")) {
            // 판매자
            item.setSeller(principalDetails.getUser());
            itemService.saveItem(item, imgFile);

            return "redirect:/main";
        } else {
            return "redirect:/main";+
        }
    }

     */
}
