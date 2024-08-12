package com.muninn.share.models;

public enum TagColor {
    Red("red"),
    Orange("orange"),
    Yellow("yellow"),
    Green("green"),
    Cyan("cyan"),
    Blue("blue"),
    Magenta("magenta");

    private final String text;

    TagColor(final String text) {
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

    public static TagColor fromString(String value) {
        for (TagColor t : TagColor.values()) {
            if (t.text == value) {
                return t;
            }
        }

        return null;
    }
}
