package com.study.reader.model

data class MUser(
    val id: String? = null,
    val userId: String,
    val displayName: String,
    val avatarUrl: String,
    val quote: String,
    val profession: String
) {
    fun toMap(): HashMap<String, Any> {
        return hashMapOf(
            "user_id" to this.userId,
            "display_name" to this.displayName,
            "avatar_url" to this.avatarUrl,
            "quote" to this.quote,
            "profession" to this.profession,
        )
    }
}
