package com.onyxperseus.user.interfaces.rest.v1.dto;

public record UserResource(String id, String userName, String email, String displayName, String phone, int gender) {
}
