package com.test.letter;

import com.test.letter.utils.Cover;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by veis on 2020/12/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LetterIntegrateApplicationTests {
	@Test
	public void testCoverToLetters() {
		Cover cover = new Cover();
        List<String> re = cover.coverToLetters("2,3");
        Assert.assertTrue(("[AD, AE, AF, BD, BE, BF, CD, CE, CF]").equals(re.toString()));
    }

    /**
     * When entering a number greater than 0-99
     */
    @Test
    public void testCoverToLettersWhenInvalidInput() {
        Cover cover = new Cover();
        List<String> re = cover.coverToLetters("234");
        Assert.assertTrue(re.size() == 1);
    }

    /**
     *When entering a number 0 or 1
     */
    @Test
    public void testCoverToLettersWhenSpecialInputBySingle() {
        Cover cover = new Cover();
        List<String> re = cover.coverToLetters("1");
        Assert.assertTrue(re.get(0).equals("None match"));
    }
    /**
     *When enter multiple digits and there are 1 or 0
     */
    @Test
    public void testCoverToLettersWhenSpecialInputForMulti() {
        Cover cover = new Cover();
        List<String> re = cover.coverToLetters("21");
        Assert.assertTrue("[A, B, C]".equals(re.toString()));
    }

}
