package com.example.pathfinderproject.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CommentCreateBM {
    public CommentCreateBM() {
    }

    private String textContent;

    @NotBlank
    @Size(min=10)
    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
