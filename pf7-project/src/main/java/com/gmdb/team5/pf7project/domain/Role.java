package com.gmdb.team5.pf7project.domain;

public enum Role {
    Actor("Actor"), Director("Director"), Producer("Producer"), Writer("Writer"), ExecutiveProducer("ExecutiveProducer"),
    AssistantDirector("AssistantDirector"), FilmEditor("FilmEditor"), SoundDesigner("SoundDesigner"), CostumeDesigner("CostumeDesigner"),
    CameraOperator("CameraOperator"),BoomOperator("BoomOperator"),PhotographyDirector("PhotographyDirector");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
