package com.github.curriculeon;

import com.github.curriculeon.utils.IOConsole;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by leon on 7/21/2020.
 */
public class ApplicationRunnerTest {
    @Ignore
    @Test
    public void test() { // TODO - replace boiler-plate logic with business logic
        // given
        Runnable runnable = new Arcade();

        // when
        runnable.run();


        // then
        Assert.assertNotNull(runnable.toString());
    }
}
