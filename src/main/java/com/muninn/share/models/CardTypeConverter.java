package com.muninn.share.models;

import org.springframework.core.convert.converter.Converter;

public class CardTypeConverter implements Converter<String, CardType> {
    @Override
    public CardType convert(String label) {
        CardType type = CardType.fromString(label);
        // Should handle null
        return type;
    }
}
