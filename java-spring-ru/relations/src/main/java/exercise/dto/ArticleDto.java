package exercise.dto;

import exercise.model.Category;


// BEGIN
public class ArticleDto {
    private String name;

    private String body;

    private Category category;

    public String getName() {
        return this.name;
    }

    public String getBody() {
        return this.body;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
// END
