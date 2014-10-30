/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oshi.software.os.unix;

import jna.platform.unix.UNameInfo;
import lombok.Value;
import oshi.software.os.OperatingSystemVersion;

/**
 *
 * @author Yann D'Isanto
 */
@Value
public final class UnixOperatingSystemVersion implements OperatingSystemVersion {

    private final String kernelVersion;

    private final String kernelRelease;

    private final String machine;

    public static UnixOperatingSystemVersion of(UNameInfo info) {
        return new UnixOperatingSystemVersion(info.getVersion(), info.getRelease(), info.getMachine());
    }
}
