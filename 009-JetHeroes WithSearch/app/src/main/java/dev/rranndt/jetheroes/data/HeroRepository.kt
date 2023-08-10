package dev.rranndt.jetheroes.data

import dev.rranndt.jetheroes.model.Hero
import dev.rranndt.jetheroes.model.HeroesData

class HeroRepository {
    fun getHeroes(): List<Hero> = HeroesData.heroes

    fun searchHeroes(query: String): List<Hero> = HeroesData.heroes.filter {
        it.name.contains(query, ignoreCase = true)
    }
}