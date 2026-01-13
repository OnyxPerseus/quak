package com.onyxperseus.server.application.port.impl;

import org.springframework.stereotype.Component;

import com.onyxperseus.common.util.RandomStringUtil;
import com.onyxperseus.server.domain.port.StringRandomPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class StringRandomImpl implements StringRandomPort {

    @Override
    public String generateRandomString(int length) {
        return RandomStringUtil.generateRandomString(length);
    }
    
}
