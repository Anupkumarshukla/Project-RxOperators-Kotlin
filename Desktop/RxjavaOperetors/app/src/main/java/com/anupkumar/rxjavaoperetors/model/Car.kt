package com.anupkumar.rxjavaoperetors.model


import io.reactivex.Observable

class Car {

    private var brand:String?=null

    fun setBrand(brand:String){
        this.brand = brand
    }

    fun brandDeferObservable(): Observable<String> {
        return Observable.defer { Observable.just(brand) }
    }

}