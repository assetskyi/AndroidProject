package com.assetskyi.apiwkabyasset.data.model


import com.google.gson.annotations.SerializedName

data class Nobels(
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("nobelPrizes")
    val nobelPrizes: List<NobelPrize>
) {
    data class Links(
        @SerializedName("first")
        val first: String,
        @SerializedName("last")
        val last: String,
        @SerializedName("next")
        val next: String,
        @SerializedName("self")
        val self: String
    )

    data class Meta(
        @SerializedName("count")
        val count: Int,
        @SerializedName("disclaimer")
        val disclaimer: String,
        @SerializedName("license")
        val license: String,
        @SerializedName("limit")
        val limit: Int,
        @SerializedName("offset")
        val offset: Int,
        @SerializedName("terms")
        val terms: String
    )

    data class NobelPrize(
        @SerializedName("awardYear")
        val awardYear: String,
        @SerializedName("category")
        val category: Category,
        @SerializedName("categoryFullName")
        val categoryFullName: CategoryFullName,
        @SerializedName("dateAwarded")
        val dateAwarded: String,
        @SerializedName("laureates")
        val laureates: List<Laureate>,
        @SerializedName("links")
        val links: List<Link>,
        @SerializedName("prizeAmount")
        val prizeAmount: Int,
        @SerializedName("prizeAmountAdjusted")
        val prizeAmountAdjusted: Int
    ) {
        data class Category(
            @SerializedName("en")
            val en: String,
            @SerializedName("no")
            val no: String,
            @SerializedName("se")
            val se: String
        )

        data class CategoryFullName(
            @SerializedName("en")
            val en: String,
            @SerializedName("no")
            val no: String,
            @SerializedName("se")
            val se: String
        )

        data class Laureate(
            @SerializedName("fullName")
            val fullName: FullName,
            @SerializedName("id")
            val id: String,
            @SerializedName("knownName")
            val knownName: KnownName,
            @SerializedName("links")
            val links: List<Link>,
            @SerializedName("motivation")
            val motivation: Motivation,
            @SerializedName("nativeName")
            val nativeName: String,
            @SerializedName("orgName")
            val orgName: OrgName,
            @SerializedName("portion")
            val portion: String,
            @SerializedName("sortOrder")
            val sortOrder: String
        ) {
            data class FullName(
                @SerializedName("en")
                val en: String
            )

            data class KnownName(
                @SerializedName("en")
                val en: String
            )

            data class Link(
                @SerializedName("action")
                val action: String,
                @SerializedName("href")
                val href: String,
                @SerializedName("rel")
                val rel: String,
                @SerializedName("types")
                val types: String
            )

            data class Motivation(
                @SerializedName("en")
                val en: String,
                @SerializedName("no")
                val no: String,
                @SerializedName("se")
                val se: String
            )

            data class OrgName(
                @SerializedName("en")
                val en: String,
                @SerializedName("no")
                val no: String
            )
        }

        data class Link(
            @SerializedName("action")
            val action: String,
            @SerializedName("href")
            val href: String,
            @SerializedName("rel")
            val rel: String,
            @SerializedName("types")
            val types: String
        )
    }
}