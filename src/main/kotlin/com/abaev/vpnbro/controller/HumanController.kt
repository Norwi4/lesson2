package com.abaev.vpnbro.controller

import com.abaev.vpnbro.model.HumanData
import com.abaev.vpnbro.service.HumanAgeServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 1. Написать метод для того, чтоб получить список всех людей
 * 2. Написать метод для того, чтоб вывести всех пользователей, возрастом меньше 20
 * 3. Написать метод создания пользователя
 * 4. Реализовать полный CRUD
 */

/**
 * @author Abaev Evgeniy
 */
@RestController
@RequestMapping("/myapp")
class HumanController(
    final val humanAgeServiceImpl: HumanAgeServiceImpl
) {

    @GetMapping("/get-me/{id}")
    fun getMe(@PathVariable id: Long): HumanData? = humanAgeServiceImpl.getHumans(id)



    /**
     * Задание номер 3
     */
    @PostMapping("/add-user")
    fun addUser(@RequestBody human: HumanData): HumanData {
        return human
    }




    @PostMapping("/validate")
    fun validate(@RequestBody data: HumanData): String = humanAgeServiceImpl.validateAge(data)

    @PostMapping("/pluse-age")
    fun pluseAge(@RequestBody data: HumanData): HumanData {
        return humanAgeServiceImpl.pluseAge(data)
    }
}