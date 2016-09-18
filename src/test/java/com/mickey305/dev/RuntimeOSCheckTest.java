package com.mickey305.dev;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RuntimeOSCheckTest {
    private static final String WINDOWS = "windows";
    private static final String MAC = "mac";
    private static final String LINUX = "linux";
    private static final String SUN_OS = "sunos";
    private static final String UNIX = "unix";

    private Set<String> platforms;

    @Before
    public void setUp() throws Exception {
        platforms = new HashSet<>();

        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.startsWith(WINDOWS)) platforms.add(WINDOWS);
        if (osName.startsWith(MAC)) platforms.add(MAC);
        if (osName.startsWith(LINUX)) platforms.add(LINUX);
        if (osName.startsWith(SUN_OS)) platforms.add(SUN_OS);

        if (osName.startsWith(MAC) || osName.startsWith(LINUX) || osName.startsWith(SUN_OS))
            platforms.add(UNIX);
    }

    @After
    public void tearDown() throws Exception {
        platforms = null;
    }

    @Test
    public void isWindows() throws Exception {
        if (platforms.contains(WINDOWS))
            if (RuntimeOSCheck.isWindows()) assertTrue(true);
            else fail();
    }

    @Test
    public void isMac() throws Exception {
        if (platforms.contains(MAC))
            if (RuntimeOSCheck.isMac()) assertTrue(true);
            else fail();
    }

    @Test
    public void isLinux() throws Exception {
        if (platforms.contains(LINUX))
            if (RuntimeOSCheck.isLinux()) assertTrue(true);
            else fail();
    }

    @Test
    public void isSunOS() throws Exception {
        if (platforms.contains(SUN_OS))
            if (RuntimeOSCheck.isSunOS()) assertTrue(true);
            else fail();
    }

    @Test
    public void isUnix() throws Exception {
        if (platforms.contains(UNIX))
            if (RuntimeOSCheck.isUnix()) assertTrue(true);
            else fail();
    }

}