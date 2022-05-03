package com.github.ejchathuranga.newsapp.domain

import com.github.ejchathuranga.newsapp.data.model.ValidateResponse
import com.github.ejchathuranga.newsapp.data.model.api.MainResponse
import retrofit2.Response

class ResponseValidator {
    fun validateResponse(response: Response<MainResponse>): ValidateResponse{
        if (response.code() == 200){
            val body: MainResponse? = response.body()
            if (body != null && body.status.equals("ok")){
                return ValidateResponse(true, body.articles)
            }else
                return ValidateResponse(false, "Error from Rest Api")
        }
        return ValidateResponse(false, "Error from Rest Api")
    }
}