package com.muninn.share.models;

public enum CardType {
    List("list"),
    Note("note");

    private final String text;

    /**
     * @param text
     */
    CardType(final String text) {
        this.text = text;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }

    public static CardType fromString(String value) {
        for (CardType t : CardType.values()) {
            if (t.text == value) {
                return t;
            }
        }

        return null;
    }
}
