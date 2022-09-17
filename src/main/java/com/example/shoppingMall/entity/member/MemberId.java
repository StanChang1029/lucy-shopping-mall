package com.example.shoppingMall.entity.member;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class MemberId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "member_email")
    private String memberEmail;
    
    @Column(name = "member_phone")
	private String memberPhone;
    
    
    public MemberId() {
    }

    public MemberId(String memberEmail, String memberPhone) {
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
    }
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberId that = (MemberId) o;
        return memberEmail.equals(that.memberEmail) &&
        		memberPhone.equals(that.memberPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberEmail, memberPhone);
    }

}