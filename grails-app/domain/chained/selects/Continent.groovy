package chained.selects

class Continent {

    static hasMany = [countries: Country]

    String continent

    static constraints = {
        continent blank: false, unique: true
    }

    String toString() {
        continent
    }

    static mapping = {
        sort "continent"
    }
}
