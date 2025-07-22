package com.gooseBumps.member_practice.common;

import com.gooseBumps.member_practice.common.constant.PostType;
import jakarta.persistence.AttributeConverter;

public class PostTypeConverter implements AttributeConverter<PostType, String> {
    @Override
    public String convertToDatabaseColumn(PostType attribute) {
        return attribute != null ? attribute.getCodeValue() : null;
    }

    @Override
    public PostType convertToEntityAttribute(String dbData) {
        return dbData != null ? PostType.fromCode(dbData) : null;
    }
}

