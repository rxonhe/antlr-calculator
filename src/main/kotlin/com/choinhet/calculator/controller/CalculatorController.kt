package com.choinhet.calculator.controller

import com.choinhet.calculator.service.CalculatorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/calculator")
class CalculatorController(private val calculatorService: CalculatorService) {
    @PostMapping("/evaluate")
    fun evaluateExpression(@RequestBody expression: String): ResponseEntity<Int> {
        val result = calculatorService.calculate(expression)
        return ResponseEntity.ok(result)
    }
}
