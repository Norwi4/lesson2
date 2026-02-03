package com.abaev.vpnbro.service

import com.abaev.vpnbro.dao.HumanRepositoryImpl
import com.abaev.vpnbro.model.HumanData
import org.springframework.stereotype.Service

/**
 * @author Abaev Evgeniy
 */
@Service
class HumanAgeServiceImpl(
    final var humanRepositoryImpl: HumanRepositoryImpl
) {

    fun getHumans(id: Long): HumanData {
        return humanRepositoryImpl.getHumanById(id)
    }

    fun validateAge(person: HumanData): String {
        return if (person.age < 18) {
            "Тебе меньше 18 лет. Подрасти еще"
        } else {
            "Проходи, дорогой!"
        }
    }

    fun pluseAge(person: HumanData): HumanData {
        return HumanData(person.id, person.name, person.lastName, person.age + 1)
    }
}