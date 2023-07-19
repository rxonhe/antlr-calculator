package com.choinhet.calculator.controller

import com.choinhet.calculator.service.CalculatorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("api/v1/calculator")
class CalculatorController(private val calculatorService: CalculatorService) {
    @PostMapping("/evaluate")
    fun evaluateExpression(@RequestBody expression: String): ResponseEntity<Float> {
        val result = calculatorService.calculate(expression)
        return ResponseEntity.ok(result)
    }
}
