package com.example.banabada.repository;

import lombok.Getter;

//유저 권한 관련 설정
@Getter
public enum MemberRole {
    ADMIN("ROLE_ADMIN"), //관리자(BANABADA), ver1에서 만들어놓기만 ver 2 이상:: 아이템 수정 등 기능 추가 예정
    MEMBER("ROLE_MEMBER"); //일반 유저

    MemberRole(String value){
        this.value = value;
    }

    private String value;
}
