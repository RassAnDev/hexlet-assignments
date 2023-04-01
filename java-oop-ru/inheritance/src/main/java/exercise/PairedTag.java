package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    String tagName;
    private String tagBody;
    private Map<String, String> attributes;
    private List<Tag> childrenTags;

    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List<Tag> childrenTags) {
        this.tagName = tagName;
        this.attributes = attributes;
        this.tagBody = tagBody;
        this.childrenTags = childrenTags;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagBody() {
        return this.tagBody;
    }

    public void serTagBody(String tagBody) {
        this.tagBody = tagBody;
    }

    public List<Tag> getChildrenTags() {
        return this.childrenTags;
    }

    public void setChildrenTags(List<Tag> childrenTags) {
        this.childrenTags = childrenTags;
    }

    public String toString() {
        String singleTag = childrenTags.stream()
                .map(x -> x.toString())
                .collect(Collectors.joining());
        return "<" + getTagName() + attributes.entrySet().stream()
                .map( x -> " " + x.getKey() + "=\"" + x.getValue() + "\"")
                .collect(Collectors.joining())
                + ">" + getTagBody() + singleTag + "</" + getTagName() + ">".trim();
    }
}
// END
