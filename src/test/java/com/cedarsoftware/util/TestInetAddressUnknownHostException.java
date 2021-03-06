package com.cedarsoftware.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * Created by kpartlow on 4/19/2014.
 */
@PowerMockIgnore("javax.management.*")
@RunWith(PowerMockRunner.class)
@PrepareForTest({InetAddress.class, InetAddressUtilities.class})
public class TestInetAddressUnknownHostException
{
    @Test
    public void testGetIpAddressWithUnkownHost() throws Exception
    {
        PowerMockito.mockStatic(InetAddress.class);
        PowerMockito.when(InetAddress.getLocalHost()).thenThrow(new UnknownHostException());
        Assert.assertArrayEquals(new byte[]{0, 0, 0, 0}, InetAddressUtilities.getIpAddress());
        Assert.assertEquals("localhost", InetAddressUtilities.getHostName());
    }
}
