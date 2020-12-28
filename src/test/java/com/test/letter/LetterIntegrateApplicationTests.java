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


    @Test
    public void testCoverToLettersWhenInvalidInput() {
        Cover cover = new Cover();
        List<String> re = cover.coverToLetters("234");
        Assert.assertTrue(re.size() == 1);
    }

}
