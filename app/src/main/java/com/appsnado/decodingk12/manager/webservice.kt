package com.appsnado.decodingk12.manager


class webservice {
    /*private var apiService: WebServiceProxy? = null
    private var mDialog: KProgressHUD? = null
    private var activity: Activity? = null

    fun WebServices(
        activity: Activity?,
        token: String,
        baseURLTypes: BaseURLTypes?
    ) {
        when (baseURLTypes) {
            BASE_URL -> apiService = WebServiceFactory.getInstanceBaseURL(token)
            XML_URL -> apiService = WebServiceFactory.getInstanceXML()
        }
        this.activity = activity
        mDialog = UIHelper.getProgressHUD(this.activity)
        if (!this.activity!!.isFinishing) mDialog.show()
    }

    fun WebServices(
        activity: Activity?,
        token: String,
        baseURLTypes: BaseURLTypes,
        isShowLoader: Boolean
    ) {
        when (baseURLTypes) {
            BASE_URL -> apiService = WebServiceFactory.getInstanceBaseURL(token)
            XML_URL -> apiService = WebServiceFactory.getInstanceXML()
        }
        this.activity = activity
        if (isShowLoader) {
            mDialog = UIHelper.getProgressHUD(this.activity)
            if (!this.activity!!.isFinishing) mDialog.show()
        }
    }


    private fun IsResponseError(response: Response<WebResponse<Any>>): Boolean {
        return !(response != null && !response.isSuccessful() && response.errorBody() != null)
    }


    private fun hasValidStatus(response: Response<WebResponse<Any>>): Boolean {
        return if (response != null && response.body() != null) {
            response.body().isSuccess()
        } else {
            false
        }
    }


    *//**
     * TO UPLOAD FILE
     *
     * @param multiFileModelArrayList
     * @param jsonStringBody
     * @param callBack
     *//*
    fun postMultipartAPIWithSameKeyAttachments(
        path: String?,
        multiFileModelArrayList: ArrayList<MultiFileModel>,
        jsonStringBody: String?,
        callBack: IRequestWebResponseAnyObjectCallBack
    ) {
        val partArrayList: ArrayList<MultipartBody.Part> = ArrayList()
        val attachments =
            arrayOfNulls<MultipartBody.Part>(multiFileModelArrayList.size())
        if (jsonStringBody != null && !jsonStringBody.isEmpty()) {
            try {
                val jsonObject = JSONObject(jsonStringBody)
                val keys: Iterator<*> = jsonObject.keys()
                while (keys.hasNext()) {
                    val key = keys.next() as String
                    val value = jsonObject.getString(key)
                    partArrayList.add(MultipartBody.Part.createFormData(key, value))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (!multiFileModelArrayList.isEmpty()) {
            for (i in 0 until multiFileModelArrayList.size()) {
                if (multiFileModelArrayList[i]
                        .getFile() == null || !multiFileModelArrayList[i].getFile().exists()
                ) {
                    dismissDialog()
                    UIHelper.showShortToastInCenter(activity, "File is empty.")
                    return
                }
                val multipart = getMultipart(
                    multiFileModelArrayList[i].getFileType(),
                    multiFileModelArrayList[i].getFile(),
                    multiFileModelArrayList[i].getKeyName()
                )
                attachments[i] = multipart
            }
        }
        try {
            if (Helper.isNetworkConnected(activity, true)) {
                apiService.postMultipartWithSameKeyAPI(path, partArrayList, attachments).enqueue(
                    object : Callback<WebResponse<Any>>() {
                        fun onResponse(
                            call: Call<WebResponse<Any>>,
                            response: Response<WebResponse<Any?>?>
                        ) {
                            validateIfWebResponse(response, callBack)
                        }

                        fun onFailure(
                            call: Call<WebResponse<Any>>,
                            t: Throwable?
                        ) {
                            UIHelper.showShortToastInCenter(
                                activity,
                                "Something went wrong, Please check your internet connection."
                            )
                            dismissDialog()
                            callBack.onError("")
                        }
                    })
            } else {
                dismissDialog()
                callBack.onError("Internet Error")
            }
        } catch (e: Exception) {
            dismissDialog()
            e.printStackTrace()
        }
    }


    *//**
     * TO UPLOAD FILE
     *
     * @param multiFileModelArrayList
     * @param jsonStringBody
     * @param callBack
     *//*
    fun putMultipartAPI(
        path: String?,
        multiFileModelArrayList: ArrayList<MultiFileModel>?,
        jsonStringBody: String?,
        callBack: IRequestWebResponseAnyObjectCallBack
    ) {
        val partArrayList: ArrayList<MultipartBody.Part> = ArrayList()
        if (jsonStringBody != null && !jsonStringBody.isEmpty()) {
            try {
                val jsonObject = JSONObject(jsonStringBody)
                val keys: Iterator<*> = jsonObject.keys()
                while (keys.hasNext()) {
                    val key = keys.next() as String
                    val value = jsonObject.getString(key)
                    partArrayList.add(MultipartBody.Part.createFormData(key, value))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (multiFileModelArrayList != null && !multiFileModelArrayList.isEmpty()) {
            for (multiFileModel in multiFileModelArrayList) {
                if (multiFileModel.getFile() == null || !multiFileModel.getFile().exists()) {
                    dismissDialog()
                    UIHelper.showShortToastInCenter(activity, "File is empty.")
                    return
                }
                val multipart = getMultipart(
                    multiFileModel.getFileType(),
                    multiFileModel.getFile(),
                    multiFileModel.getKeyName()
                )
                partArrayList.add(multipart)
            }
        }

        // Method Spoofing
        partArrayList.add(MultipartBody.Part.createFormData("_method", "PUT"))
        try {
            if (Helper.isNetworkConnected(activity, true)) {
                apiService.postMultipartAPI(path, partArrayList).enqueue(
                    object : Callback<WebResponse<Any?>?>() {
                        fun onResponse(
                            call: Call<WebResponse<Any?>?>?,
                            response: Response<WebResponse<Any?>?>
                        ) {
                            validateIfWebResponse(response, callBack)
                        }

                        fun onFailure(
                            call: Call<WebResponse<Any>>,
                            t: Throwable?
                        ) {
                            UIHelper.showShortToastInCenter(
                                activity,
                                "Something went wrong, Please check your internet connection."
                            )
                            dismissDialog()
                            callBack.onError("")
                        }
                    })
            } else {
                dismissDialog()
                callBack.onError("Internet Error")
            }
        } catch (e: Exception) {
            dismissDialog()
            e.printStackTrace()
        }
    }

    *//**
     * TO UPLOAD FILE
     *
     * @param multiFileModelArrayList
     * @param jsonStringBody
     * @param callBack
     *//*
    fun postMultipartAPI(
        path: String?,
        multiFileModelArrayList: ArrayList<MultiFileModel>?,
        jsonStringBody: String?,
        callBack: IRequestWebResponseAnyObjectCallBack
    ) {
        val partArrayList: ArrayList<MultipartBody.Part> = ArrayList()
        if (jsonStringBody != null && !jsonStringBody.isEmpty()) {
            try {
                val jsonObject = JSONObject(jsonStringBody)
                val keys: Iterator<*> = jsonObject.keys()
                while (keys.hasNext()) {
                    val key = keys.next() as String
                    val value = jsonObject.getString(key)
                    partArrayList.add(MultipartBody.Part.createFormData(key, value))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (multiFileModelArrayList != null && !multiFileModelArrayList.isEmpty()) {
            for (multiFileModel in multiFileModelArrayList) {
                if (multiFileModel.getFile() == null || !multiFileModel.getFile().exists()) {
                    dismissDialog()
                    UIHelper.showShortToastInCenter(activity, "File is empty.")
                    return
                }
                val multipart = getMultipart(
                    multiFileModel.getFileType(),
                    multiFileModel.getFile(),
                    multiFileModel.getKeyName()
                )
                partArrayList.add(multipart)
            }
        }
        try {
            if (Helper.isNetworkConnected(activity, true)) {
                apiService.postMultipartAPI(path, partArrayList).enqueue(
                    object : Callback<WebResponse<Any?>?>() {
                        fun onResponse(
                            call: Call<WebResponse<Any?>?>?,
                            response: Response<WebResponse<Any?>?>
                        ) {
                            validateIfWebResponse(response, callBack)
                        }

                        fun onFailure(
                            call: Call<WebResponse<Any?>?>?,
                            t: Throwable?
                        ) {
                            UIHelper.showShortToastInCenter(
                                activity,
                                "Something went wrong, Please check your internet connection."
                            )
                            dismissDialog()
                            callBack.onError("")
                        }
                    })
            } else {
                dismissDialog()
                callBack.onError("Internet Error")
            }
        } catch (e: Exception) {
            dismissDialog()
            e.printStackTrace()
        }
    }


    *//**
     * WEB CALL DELETE
     *
     * @param path
     * @param requestData can give null or empty
     * @param callBack
     * @return
     *//*
    fun deleteAPIAnyObject(
        path: String?,
        requestData: String?,
        callBack: IRequestWebResponseAnyObjectCallBack
    ): Call<WebResponse<Any?>?>? {
//        RequestBody bodyRequestData = getRequestBody(okhttp3.MediaType.parse("application/json; charset=utf-8"), requestData);

//        MultipartBody.Part multipartBody = MultipartBody.Part.create(bodyRequestData);
        val webResponseCall: Call<WebResponse<Any?>?> =
            apiService.deleteAPIWebResponseAnyObject(path)
        try {
            if (Helper.isNetworkConnected(activity, true)) {
                webResponseCall.enqueue(object : Callback<WebResponse<Any?>?>() {
                    fun onResponse(
                        call: Call<WebResponse<Any?>?>?,
                        response: Response<WebResponse<Any?>?>
                    ) {
                        validateIfWebResponse(response, callBack)
                    }

                    fun onFailure(
                        call: Call<WebResponse<Any?>?>?,
                        t: Throwable?
                    ) {
                        UIHelper.showShortToastInCenter(
                            activity,
                            "Something went wrong, Please check your internet connection."
                        )
                        dismissDialog()
                        callBack.onError("")
                    }
                })
            } else {
                dismissDialog()
            }
        } catch (e: Exception) {
            dismissDialog()
            e.printStackTrace()
        }
        return webResponseCall
    }


    *//**
     * WEB CALL POST
     *
     * @param path
     * @param requestData
     * @param callBack
     * @return
     *//*
    fun postAPIAnyObject(
        path: String?,
        requestData: String,
        callBack: IRequestWebResponseAnyObjectCallBack
    ): Call<WebResponse<Any?>?>? {
        val bodyRequestData =
            getRequestBody(MediaType.parse("application/json; charset=utf-8"), requestData)

//        MultipartBody.Part multipartBody = MultipartBody.Part.create(bodyRequestData);
        val webResponseCall: Call<WebResponse<Any?>?> =
            apiService.postAPIWebResponseAnyObject(path, bodyRequestData)
        try {
            if (Helper.isNetworkConnected(activity, true)) {
                webResponseCall.enqueue(object : Callback<WebResponse<Any?>?>() {
                    fun onResponse(
                        call: Call<WebResponse<Any?>?>?,
                        response: Response<WebResponse<Any?>?>
                    ) {
                        validateIfWebResponse(response, callBack)
                    }

                    fun onFailure(
                        call: Call<WebResponse<Any?>?>?,
                        t: Throwable?
                    ) {
                        UIHelper.showShortToastInCenter(
                            activity,
                            "Something went wrong, Please check your internet connection."
                        )
                        dismissDialog()
                        callBack.onError("")
                    }
                })
            } else {
                dismissDialog()
            }
        } catch (e: Exception) {
            dismissDialog()
            e.printStackTrace()
        }
        return webResponseCall
    }


    *//**
     * WEB CALL GET
     *
     * @param path
     * @param queryMap
     * @param callBack
     * @return
     *//*
    fun getAPIAnyObject(
        path: String?,
        queryMap: Map<String?, Any?>?,
        callBack: IRequestWebResponseAnyObjectCallBack
    ): Call<WebResponse<Any?>?>? {
        val webResponseCall: Call<WebResponse<Any?>?> =
            apiService.getAPIForWebresponseAnyObject(path, queryMap)
        try {
            if (Helper.isNetworkConnected(activity, true)) {
                webResponseCall.enqueue(object : Callback<WebResponse<Any?>?>() {
                    fun onResponse(
                        call: Call<WebResponse<Any?>?>?,
                        response: Response<WebResponse<Any?>?>
                    ) {
                        validateIfWebResponse(response, callBack)
                    }

                    fun onFailure(
                        call: Call<WebResponse<Any?>?>?,
                        t: Throwable?
                    ) {
                        UIHelper.showShortToastInCenter(
                            activity,
                            "Something went wrong, Please check your internet connection."
                        )
                        dismissDialog()
                        callBack.onError("")
                    }
                })
            } else {
                dismissDialog()
            }
        } catch (e: Exception) {
            dismissDialog()
            e.printStackTrace()
        }
        return webResponseCall
    }


    fun validateIfWebResponse(
        response: Response<WebResponse<Any?>?>,
        callBack: IRequestWebResponseAnyObjectCallBack?
    ) {
        dismissDialog()
        if (response.body() == null) {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonFactory.getSimpleGson()))
                .build()
            val errorConverter: Converter<ResponseBody, WebResponse<Any>> =
                retrofit.responseBodyConverter<Any>(
                    WebResponse::class.java, arrayOfNulls(0)
                )
            var error: WebResponse<Any>? = null
            try {
                error = errorConverter.convert(response.errorBody())
            } catch (e: IOException) {
                e.printStackTrace()
            }
            if (response.code() === WebServiceConstants.PARAMS_TOKEN_EXPIRE) {
//                UIHelper.showToast(activity, "TOKEN ERROR " + PARAMS_TOKEN_EXPIRE);
                tokenRefresh()
            } else if (response.code() === WebServiceConstants.PARAMS_TOKEN_BLACKLIST) {
                UIHelper.showAlertDialog(
                    activity,
                    "Token Authentication Failed, Kindly login again"
                )
                SharedPreferenceManager.getInstance(activity).clearDB()
                clearAllActivitiesExceptThis(MainActivity::class.java)
            } else {
                errorToastForObject(error, true)
            }
            callBack!!.onError(error)
            return
        }
        if (response.isSuccessful() && response.body().isSuccess()) {
            callBack?.requestDataResponse(response.body())
        } else {
            callBack!!.onError(errorToastForObject(response))
        }
    }

    fun tokenRefresh() {
        val bodyRequestData =
            getRequestBody(MediaType.parse("application/json; charset=utf-8"), "")
        val webResponseCall: Call<WebResponse<Any>> = apiService.postAPIWebResponseAnyObject(
            WebServiceConstants.PATH_GET_REFRESH,
            bodyRequestData
        )
        try {
            if (Helper.isNetworkConnected(activity, true)) {
                webResponseCall.enqueue(object : Callback<WebResponse<Any?>?>() {
                    fun onResponse(
                        call: Call<WebResponse<Any?>?>?,
                        response: Response<WebResponse<Any?>?>
                    ) {
                        if (response.body() == null) {
                            UIHelper.showAlertDialog(
                                activity,
                                "Token Authentication Failed, Kindly login again"
                            )
                            SharedPreferenceManager.getInstance(activity).clearDB()
                            clearAllActivitiesExceptThis(MainActivity::class.java)
                            return
                        }
                        if (response.isSuccessful() && response.body().isSuccess()) {
                            val sharedPreferenceManager: SharedPreferenceManager =
                                SharedPreferenceManager.getInstance(activity)
                            val userModelWrapper: UserModelWrapper =
                                GsonFactory.getSimpleGson().fromJson(
                                    GsonFactory.getSimpleGson().toJson(response.body().result),
                                    UserModelWrapper::class.java
                                )
                            sharedPreferenceManager.putObject(
                                AppConstants.KEY_CURRENT_USER_MODEL,
                                userModelWrapper.getUser()
                            )
                            sharedPreferenceManager.putValue(
                                AppConstants.KEY_TOKEN,
                                userModelWrapper.getUser().getAccessToken()
                            )
                            //
                            UIHelper.showAlertDialog(activity, "Token refreshed successfully")
                            if (activity is HomeActivity) {
                                reload()
                            } else {
                                clearAllActivitiesExceptThis(HomeActivity::class.java)
                            }
                        } else {
                            UIHelper.showAlertDialog(
                                activity,
                                "Token Authentication Failed, Kindly login again"
                            )
                            SharedPreferenceManager.getInstance(activity).clearDB()
                            clearAllActivitiesExceptThis(MainActivity::class.java)
                        }
                    }

                    fun onFailure(
                        call: Call<WebResponse<Any?>?>?,
                        t: Throwable?
                    ) {
                        dismissDialog()
                        UIHelper.showAlertDialog(
                            activity,
                            "Token Authentication Failed, Kindly login again"
                        )
                        SharedPreferenceManager.getInstance(activity).clearDB()
                        clearAllActivitiesExceptThis(MainActivity::class.java)
                    }
                })
            } else {
                dismissDialog()
            }
        } catch (e: Exception) {
            dismissDialog()
            e.printStackTrace()
        }
    }

    fun getMultipart(
        fileType: FileType,
        file: File,
        keyName: String?
    ): MultipartBody.Part {
        return MultipartBody.Part.createFormData(
            keyName, file.getName(),
            RequestBody.create(
                MediaType.parse(
                    fileType.canonicalForm()
                        .toString() + "/" + FileManager.getExtension(file.getName())
                ), file
            )
        )
    }


    private fun getRequestBody(form: MediaType?, trim: String): RequestBody {
        return RequestBody.create(
            form, trim
        )
    }


    private fun dismissDialog() {
        if (mDialog != null) {
            mDialog.dismiss()
        }
    }


    private fun errorToastForObject(
        response: WebResponse<Any>?,
        showDialogIfTrueToastIfFalse: Boolean
    ): String? {
        var responseMessage = ""
        if (response != null) {
            responseMessage = response.message
        }
        if (responseMessage.isEmpty()) {
            UIHelper.showShortToastInCenter(activity, "API Response Error")
        } else {
            UIHelper.showShortToastInCenter(activity, responseMessage)
            //            if (showDialogIfTrueToastIfFalse && activity instanceof BaseActivity && response.errorList != null && !response.errorList.isEmpty()) {
//                ErrorDialogFragment.newInstance(response.errorList, null).show(((BaseActivity) activity).getSupportFragmentManager(), "ErrorDialogFragment");
//            } else {
//
//            }
        }
        return responseMessage
    }


    private fun errorToastForObject(response: Response<WebResponse<Any?>?>): String? {
        var responseMessage = ""
        if (response.body() != null) {
            responseMessage =
                if (response.body().message != null) response.body().message else response.errorBody()
                    .toString()
        }
        if (responseMessage.isEmpty()) {
            UIHelper.showShortToastInCenter(activity, "API Response Error ")
        } else {
            UIHelper.showShortToastInCenter(activity, responseMessage)
        }
        return responseMessage
    }


    interface IRequestWebResponseAnyObjectCallBack {
        fun requestDataResponse(webResponse: WebResponse<Any?>?)
        fun onError(`object`: Any?)
    }

    interface IRequestWebResponseJustObjectCallBack {
        fun requestDataResponse(webResponse: Any?)
        fun onError(`object`: Any?)
    }


    fun reload() {
        val intent = activity!!.intent
        activity!!.overridePendingTransition(0, 0)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        activity!!.finish()
        activity!!.overridePendingTransition(0, 0)
        activity!!.startActivity(intent)
    }


    fun clearAllActivitiesExceptThis(cls: Class<*>?) {
        val intents = Intent(activity, cls)
        intents.addFlags(
            Intent.FLAG_ACTIVITY_NEW_TASK
                    or Intent.FLAG_ACTIVITY_CLEAR_TOP
                    or Intent.FLAG_ACTIVITY_CLEAR_TASK
        )
        activity!!.startActivity(intents)
        activity!!.finish()
    }

*/
}