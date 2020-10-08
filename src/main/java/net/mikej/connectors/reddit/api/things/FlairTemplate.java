package net.mikej.connectors.reddit.api.things;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlairTemplate {
    final String allowableContent;
    final String text;
    final FlairTextColor textColor;
    final Boolean modOnly;
    final String backgroundColor;
    final String id;
    final String cssClass;
    final Integer maxEmojis;
    final String[] richText;
    final Boolean textEditable;
    final Boolean overrideCss;
    final String type;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public FlairTemplate(
            @JsonProperty("allowable_content") String allowableContent,
            @JsonProperty("text") String text,
            @JsonProperty("text_color") FlairTextColor textColor,
            @JsonProperty("mod_only") Boolean modOnly,
            @JsonProperty("background_color") String backgroundColor,
            @JsonProperty("id") String id,
            @JsonProperty("css_class") String cssClass,
            @JsonProperty("max_emojis") Integer maxEmojis,
            @JsonProperty("rich_text") String[] richText,
            @JsonProperty("text_editable") Boolean textEditable,
            @JsonProperty("override_css") Boolean overrideCss,
            @JsonProperty("type") String type) {
        this.allowableContent = allowableContent;
        this.text = text;
        this.textColor = textColor;
        this.modOnly = modOnly;
        this.backgroundColor = backgroundColor;
        this.id = id;
        this.cssClass = cssClass;
        this.maxEmojis = maxEmojis;
        this.richText = richText;
        this.textEditable = textEditable;
        this.overrideCss = overrideCss;
        this.type = type;
    }

    public String getAllowableContent() {
        return allowableContent;
    }

    public String getText() {
        return text;
    }

    public FlairTextColor getTextColor() {
        return textColor;
    }

    public Boolean getModOnly() {
        return modOnly;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getId() {
        return id;
    }

    public String getCssClass() {
        return cssClass;
    }

    public Integer getMaxEmojis() {
        return maxEmojis;
    }

    public String[] getRichText() {
        return richText;
    }

    public Boolean getTextEditable() {
        return textEditable;
    }

    public Boolean getOverrideCss() {
        return overrideCss;
    }

    public String getType() {
        return type;
    }
}