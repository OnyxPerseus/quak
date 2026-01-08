package com.onyxperseus.server.infrastructure.mapper;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class ObjectIdMapper {
    public String toString(ObjectId objectId) {
        return objectId != null ? objectId.toHexString() : null;
    }

    public ObjectId toObjectId(String id) {
        return id != null ? new ObjectId(id) : null;
    }
}
