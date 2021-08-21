package com.hackerrank.gevents.domain.converter;

import static java.util.Objects.isNull;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class YesNoConverter implements AttributeConverter<Boolean, String> {

    public final static String YES = "Y";
    public final static String NO = "N" ;

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if (isNull(attribute)) {
            return null;
        }
        return attribute ? YES : NO;
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if (isNull(dbData)) {
            return null;
        }

        if (dbData.equals(YES)) {
            return Boolean.TRUE;
        } else if (dbData.equals(NO)) {
            return Boolean.FALSE;
        } else {
            throw new IllegalStateException(
                    String.format("The value [%s] on the database is invalid!", dbData));
        }
    }
}
