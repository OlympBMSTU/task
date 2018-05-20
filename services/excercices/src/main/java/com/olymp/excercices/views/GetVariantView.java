package com.olymp.excercices.views;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetVariantView {
    private Subject subject;
    @JsonCreator
    GetVariantView(@JsonProperty("subject") Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return this.subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
