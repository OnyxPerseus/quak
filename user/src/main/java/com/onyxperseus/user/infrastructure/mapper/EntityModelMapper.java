package com.onyxperseus.user.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.onyxperseus.user.domain.model.Email;
import com.onyxperseus.user.domain.model.Phone;
import com.onyxperseus.user.domain.model.User;
import com.onyxperseus.user.domain.model.UserName;
import com.onyxperseus.user.infrastructure.entity.UserEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntityModelMapper {
    UserEntity toEntity(User user);
    User toModel(UserEntity userEntity);

    default UserName toUserName(String userName){
        return new UserName(userName);
    }

    default String fromUserName(UserName userName){
        return userName.value();
    }

    default Email toEmail(String email){
        return new Email(email);
    }

    default String fromEmail(Email email){
        return email.value();
    }

    default Phone  toPhone(String phone){
        return new Phone(phone);
    }

    default String fromPhone(Phone phone){
        return phone.value();
    }
}
