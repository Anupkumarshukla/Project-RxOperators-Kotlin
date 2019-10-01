package com.anupkumar.rxjavaoperetors.utils

import android.util.Log
import com.androidnetworking.error.ANError
import com.anupkumar.rxjavaoperetors.model.ApiUser
import com.anupkumar.rxjavaoperetors.model.User

import java.util.ArrayList

object Utils {



    fun getUserList() :  List<User>{
        val userList = ArrayList<User>()

        val userOne = User()
        userOne.firstname = "Anup"
        userOne.lastname = "Shukla"
        userList.add(userOne)

        val userTwo = User()
        userTwo.firstname = "Sameer"
        userTwo.lastname = "Sawant"
        userList.add(userTwo)

        val userThree = User()
        userThree.firstname = "Sumit"
        userThree.lastname = "Jadhaw"
        userList.add(userThree)
        return userList
    }

    fun getApiUserList():List<ApiUser>{
        val apiUserList = ArrayList<ApiUser>()

        val apiUserOne = ApiUser()
        apiUserOne.firstname = "Anup"
        apiUserOne.lastname = "Shukla"
        apiUserList.add(apiUserOne)

        val apiUserTwo = ApiUser()
        apiUserTwo.firstname = "Sameer"
        apiUserTwo.lastname = "Sawant"
        apiUserList.add(apiUserTwo)

        val apiUserThree = ApiUser()
        apiUserThree.firstname = "Sumit"
        apiUserThree.lastname = "Jadhaw"
        apiUserList.add(apiUserThree)

        return apiUserList
    }

    fun convertApiUserListToUserList(apiUserList:List<ApiUser> ):List<User> {
        val userList = ArrayList<User>()

        for (apiUser in apiUserList) {
            val user = User()
            user.firstname = apiUser.firstname!!
            user.lastname = apiUser.lastname!!
            userList.add(user)
        }
        return userList
    }

    fun convertApiUserListToApiUserList(apiUserList:List<ApiUser>):List<ApiUser>{
        return apiUserList
    }




    fun getUserListWhoLovesCricket():List<User>{
        val userList = ArrayList<User>()

        val userOne = User()
        userOne.id = 1
        userOne.firstname = "Anup"
        userOne.lastname = "Shukla"
        userList.add(userOne)

        val userTwo = User()
        userTwo.id = 2
        userTwo.firstname = "Sameer"
        userTwo.lastname = "Sawant"
        userList.add(userTwo)

        return userList

    }

    fun getUserListWhoLovesFootball():List<User>{
        val userList = ArrayList<User>()

        val userOne = User()
        userOne.id = 1
        userOne.firstname = "Anup"
        userOne.lastname = "Shukla"
        userList.add(userOne)

        val userTwo = User()
        userTwo.id = 3
        userTwo.firstname = "Sumit"
        userTwo.lastname = "Jadhaw"
        userList.add(userTwo)

        return userList
    }

    fun filterUserWhoLovesBoth(cricketFans:List<User>,footballFans:List<User>):List<User>{
     val userWhoLoveBoth = ArrayList<User>()
     for (cricketFan in cricketFans){
         for (footballFan in footballFans){
             if (cricketFan.id == footballFan.id){
                 userWhoLoveBoth.add(cricketFan)
             }
         }
     }
        return userWhoLoveBoth
    }


    fun logError(TAG:String,e:Throwable){
        if (e is ANError) {
            if (e.errorCode != 0) {
                // received ANError from server
                // error.getErrorCode() - the ANError code from server
                // error.getErrorBody() - the ANError body from server
                // error.getErrorDetail() - just a ANError detail
                Log.d(TAG, "onError errorCode : " + e.errorCode)
                Log.d(TAG, "onError errorBody : " + e.errorBody)
                Log.d(TAG, "onError errorDetail : " + e.errorDetail)
            } else {
                // error.getErrorDetail() : connectionError, parseError, requestCancelledError
                Log.d(TAG, "onError errorDetail : " + e.errorDetail)
            }
        } else {
            Log.d(TAG, "onError errorMessage : " + e.message)
        }
    }



}// This class in not publicly instantiable.
