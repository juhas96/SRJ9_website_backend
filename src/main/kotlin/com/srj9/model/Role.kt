package com.srj9.model

import org.hibernate.annotations.NaturalId
import javax.persistence.*
import javax.print.DocFlavor.STRING


@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0L

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    var name: RoleName? = RoleName.ROLE_USER

    constructor()

    constructor(name: RoleName) {
        this.name = name
    }
}
