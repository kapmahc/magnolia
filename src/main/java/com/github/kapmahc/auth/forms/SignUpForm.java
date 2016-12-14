package com.github.kapmahc.auth.forms;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by flamen on 16-12-13.
 */

public class SignUpForm implements Serializable {
    @Email
    private String email;
    @Size(min = 2, max = 255)
    private String name;
    @NotNull
    @Size(min = 6)
    private String password;
    private String passwordConfirmation;
}
