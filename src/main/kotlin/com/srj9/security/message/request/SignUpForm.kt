package com.srj9.security.message.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class SignUpForm {

    @Size(max = 50)
    var first_name: String? = null

    @Size(max = 50)
    var last_name: String? = null

    @NotBlank
    @Size(min = 3, max = 50)
    var username: String? = null

    @NotBlank
    @Size(max = 60)
    @Email
    var email: String? = null

    var role: Set<String>? = null

    @NotBlank
    @Size(min = 6, max = 40)
    var password: String? = null
}
