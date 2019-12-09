package com.example.nguyen.fakeapp.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Data {
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("email_verified_at")
    @Expose
    var emailVerifiedAt: Any? = null
    @SerializedName("address")
    @Expose
    var address: Any? = null
    @SerializedName("province")
    @Expose
    var province: Any? = null
    @SerializedName("district")
    @Expose
    var district: Any? = null
    @SerializedName("phone_number")
    @Expose
    var phoneNumber: String? = null
    @SerializedName("identification")
    @Expose
    var identification: List<Any>? = null
    @SerializedName("avatar")
    @Expose
    var avatar: Any? = null
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null
    @SerializedName("cash")
    @Expose
    var cash: Int? = null
    @SerializedName("status")
    @Expose
    var status: Int? = null
    @SerializedName("status_title")
    @Expose
    var statusTitle: String? = null
    @SerializedName("verify")
    @Expose
    var verify: Int? = null
    @SerializedName("verify_title")
    @Expose
    var verifyTitle: String? = null
    @SerializedName("fb_id")
    @Expose
    var fbId: Any? = null
    @SerializedName("expired_vip_time")
    @Expose
    var expiredVipTime: Int? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("province_id")
    @Expose
    var provinceId: Int? = null
    @SerializedName("district_id")
    @Expose
    var districtId: Int? = null
    @SerializedName("access_token")
    @Expose
    var accessToken: String? = null
    @SerializedName("identification_urls")
    @Expose
    var identificationUrls: List<Any>? = null
    @SerializedName("is_vip")
    @Expose
    var isVip: Int? = null
    @SerializedName("vip_name")
    @Expose
    var vipName: String? = null
    @SerializedName("unread_room")
    @Expose
    var unreadRoom: Int? = null
    @SerializedName("unread_notifications")
    @Expose
    var unreadNotifications: Int? = null
    @SerializedName("policy_id")
    @Expose
    var policyId: Int? = null
    @SerializedName("bank_accounts")
    @Expose
    var bankAccounts: List<Any>? = null
    @SerializedName("removed_users")
    @Expose
    var removedUsers: List<Any>? = null

}