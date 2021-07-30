package com.example.getdatafromservertest;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    /// fetch data from server using get method....
    // --/posts?postId=1
    @GET("people/{personName}")
    Call<GetData> getPersonData(@Path("personName") String name);

    @Headers("Content-Type: application/json")
    @GET("peopleAll")
    Call<List<GetData>> getPersonDataWithJsonArray();
//    // multiple Query
//    @GET("posts")
//    Call<List<Post>> getPosts(
//            @Query("userId") Integer[] userId,
//            @Query("_sort") String sort,
//            @Query("_order") String order
//    );
//
//    @GET("posts")
//    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);
//
//    //---/posts/1/comments
//    @GET("posts/{id}/comments")
//    Call<List<Comment>> getComments(@Path("id") int postId);
//
    //full url
    @GET
    Call<List<GetData>> getPersonDataWithFullUrl(@Url String url);

    @GET
    Call<GetData> getPersonDataWithFullUrlOne(@Url String url);
//
//    //// send data to the server by post method
//
//    @POST("posts")
//    Call<Post> createPost(@Body Post post);
//
//    @FormUrlEncoded
//    @POST("posts")
//    Call<Post> createPost(
//            @Field("userId") int userId,
//            @Field("title") String title,
//            @Field("body") String text
//    );
//
//    @FormUrlEncoded
//    @POST("posts")
//    Call<Post> createPost(@FieldMap Map<String, String> fields);
}
