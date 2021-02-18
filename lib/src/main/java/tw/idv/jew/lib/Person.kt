package tw.idv.jew.lib

fun main(){
    val p = Person()
    p.height = 1.7f
    p.weight = 65f
    println("Your BMI is ${p.getBmi()}")
}

class Person {
    var weight: Float = 0.0f
    var height: Float = 0f

    fun getBmi(): Float {
        val bmi = weight / (height * height)
        return bmi
    }
}