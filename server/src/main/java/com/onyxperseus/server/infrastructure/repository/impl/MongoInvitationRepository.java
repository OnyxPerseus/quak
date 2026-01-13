package com.onyxperseus.server.infrastructure.repository.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.onyxperseus.server.domain.model.Invitation;
import com.onyxperseus.server.domain.repository.InvitationRepository;
import com.onyxperseus.server.infrastructure.entity.InvitationEntity;
import com.onyxperseus.server.infrastructure.mapper.InvitationMapper;
import com.onyxperseus.server.infrastructure.repository.SpringDataInvitationRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class MongoInvitationRepository implements InvitationRepository {
    
    private final SpringDataInvitationRepository springDataInvitationRepository;
    private final InvitationMapper invitationMapper;
    
    @Override
    public Invitation save(Invitation invitation) {
        InvitationEntity entity = invitationMapper.toEntity(invitation);
        InvitationEntity saved = springDataInvitationRepository.save(entity);
        return invitationMapper.toModel(saved);
    }
    
    @Override
    public Optional<Invitation> findByCode(String code) {
        return springDataInvitationRepository.findByCode(code)
            .map(invitationMapper::toModel);
    }
    
    @Override
    public List<Invitation> findByServerId(String serverId) {
        ObjectId serverObjectId = new ObjectId(serverId);
        return springDataInvitationRepository.findByServerId(serverObjectId).stream()
            .map(invitationMapper::toModel)
            .collect(Collectors.toList());
    }
}
