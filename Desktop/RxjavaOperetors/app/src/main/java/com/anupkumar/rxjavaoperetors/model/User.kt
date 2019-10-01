package com.anupkumar.rxjavaoperetors.model

class User {
    var id: Long = 0
    lateinit var firstname: String
    lateinit var lastname: String
    var isFollowing: Boolean = false



    constructor(apiUser: ApiUser) {
        this.id = apiUser.id
        this.firstname = apiUser.firstname!!
        this.lastname = apiUser.lastname!!
    }

    constructor()


}