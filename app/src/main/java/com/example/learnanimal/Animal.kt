package com.example.learnanimal

class Animal {
    var name:String?=null
    var description:String?=null
    var image:Int?=null
    var isDangerous:Boolean?=null
    constructor(name:String, description:String, image:Int, isDangerous:Boolean){
        this.name = name
        this.description = description
        this.image = image
        this.isDangerous = isDangerous
    }
}