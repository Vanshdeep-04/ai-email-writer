package com.email.writer;

import lombok.Data;

@Data // From lombok - Used to generate Getters, Setters , constructors etc
public class EmailRequest {
    private String emailContent;
    private String tone;
}
