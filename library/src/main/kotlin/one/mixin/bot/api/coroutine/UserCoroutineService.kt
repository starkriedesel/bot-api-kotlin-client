package one.mixin.bot.api.coroutine

import com.google.gson.JsonObject
import one.mixin.bot.api.MixinResponse
import one.mixin.bot.vo.Account
import one.mixin.bot.vo.AccountRequest
import one.mixin.bot.vo.GhostKey
import one.mixin.bot.vo.GhostKeyRequest
import one.mixin.bot.vo.PinRequest
import one.mixin.bot.vo.RpcRequest
import one.mixin.bot.vo.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserCoroutineService {

    @POST("users")
    suspend fun createUsers(@Body request: AccountRequest): MixinResponse<User>

    @POST("pin/update")
    suspend fun createPin(@Body request: PinRequest): MixinResponse<User>

    @POST("pin/verify")
    suspend fun pinVerify(@Body request: PinRequest): MixinResponse<User>

    @POST("pin/update")
    suspend fun updatePin(@Body request: PinRequest): MixinResponse<Account>

    @GET("me")
    suspend fun getMe(): MixinResponse<Account>

    @POST("multisigs/{id}/cancel")
    suspend fun cancelMultisigs(@Path("id") id: String): MixinResponse<Void>

    @POST("multisigs/{id}/sign")
    suspend fun signMultisigs(@Path("id") id: String, @Body pinRequest: PinRequest): MixinResponse<Void>

    @POST("multisigs/{id}/unlock")
    suspend fun unlockMultisigs(@Path("id") id: String, @Body pinRequest: PinRequest): MixinResponse<Void>

    @POST("outputs")
    suspend fun readGhostKeys(@Body ghostKeyRequest: GhostKeyRequest): MixinResponse<GhostKey>

    @POST("external/proxy")
    suspend fun mixinMainnetRPC(
        @Body rpcRequest: RpcRequest
    ): JsonObject

    @GET("search/{query}")
    suspend fun search(@Path("query") query: String): MixinResponse<User>
}
