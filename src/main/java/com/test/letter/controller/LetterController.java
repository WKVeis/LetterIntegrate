package com.test.letter.controller;

import com.test.letter.utils.Cover;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by veis on 2020/12/28
 */
@RestController
@RequestMapping("/v1/letter")
@Api(value = "Letter-Integrate", description = "demo")
public class LetterController {
    @PostMapping("/test")
    @ApiOperation(value = "User addition", notes = "Current class")
    public List<String> digitsToLetters(@RequestParam(value = "Please enter the numbers 0-99 consecutively, separated by \",\"", required = true, defaultValue = "2,3") String value) throws Exception {
        Cover cover = new Cover();
        return cover.coverToLetters(value);
    }

}