package net.mikej.connectors.reddit.api.things;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModeratorListing {

    private final String kind;
    private final ModeratorData data;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ModeratorListing(@JsonProperty("kind") String kind, @JsonProperty("data") ModeratorData data) {
        this.kind = kind;
        this.data = data;
    }

    public String getKind() {
        return kind;
    }

    public ModeratorData getData() {
        return data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ModeratorData {

        private final Moderator[] children;

        public ModeratorData(@JsonProperty("children") Moderator[] children) {
            this.children = children;
        }

        public Moderator[] getChildren() {
            return children;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Moderator extends Thing {
        private final String author_flair_text;
        private final String[] mod_permissions;
        private final Long date;
        private final String rel_id;
        private final String author_flair_css_class;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        public Moderator(
          @JsonProperty("name") String name, 
          @JsonProperty("author_flair_text") String author_flair_text, 
          @JsonProperty("mod_permissions") String[] mod_permissions, 
          @JsonProperty("date") Long date, 
          @JsonProperty("rel_id") String rel_id, 
          @JsonProperty("id") String id, 
          @JsonProperty("author_flair_css_class") String author_flair_css_class) {
            super(id, name);
            this.author_flair_text = author_flair_text;
            this.mod_permissions = mod_permissions;
            this.date = date;
            this.rel_id = rel_id;
            this.author_flair_css_class = author_flair_css_class;
        }

        public String getAuthor_flair_text() {
            return author_flair_text;
        }

        public String[] getMod_permissions() {
            return mod_permissions;
        }

        public Long getDate() {
            return date;
        }

        public String getRel_id() {
            return rel_id;
        }

        public String getAuthor_flair_css_class() {
            return author_flair_css_class;
        }
    }
}